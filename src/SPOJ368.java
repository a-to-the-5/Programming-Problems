import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class SPOJ368 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = 
		 new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			int p = Integer.parseInt(br.readLine().trim());
			int n = Integer.parseInt(br.readLine().trim());
			int m = Integer.parseInt(br.readLine().trim());
			LinkedList<Node>[] adj = new LinkedList[n+1];
			for(int i = 0; i<adj.length; i++){
				adj[i] = new LinkedList<Node>();
			}
			for(int i = 0; i<m; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adj[a].add(new Node(b, c));
				adj[b].add(new Node(a, c));
			}
			int[] parent = new int[n+1];
			long[] dist = new long[n+1];
			boolean[] intree = new boolean[n+1];
			for(int i = 1; i< n+1; i++){
				parent[i] = -1;
				dist[i] = Integer.MAX_VALUE;
			}
			
			dist[1] = 0;
			int v = 1;
			long res = 0;
			while(!intree[v]){
				intree[v] = true;
				for(Node node:adj[v]){
					int d = node.dest;
					long weight = node.length;
					if(dist[d]>weight && !intree[d]){
						dist[d] = weight;
						parent[d] = v;
					}
				}
				v = 1;
				long distance = Integer.MAX_VALUE;
				for(int i = 1; i<n+1; i++){
					if(!intree[i] && dist[i]<distance){
						distance = dist[i];
						v = i;
					}
				}
				res+=distance;
			}
			System.out.println((res-Integer.MAX_VALUE)*p);
		}
	}
}

class Node{
	int dest;
	long length;
	public Node(int d, int l) {
		dest = d; length = l;
	}
}
