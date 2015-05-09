import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class SPOJ1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
		  new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedList<Integer>[] adj = new LinkedList[n];
		boolean [] visited = new boolean[n];
		int [] parent = new int[n];
		Arrays.fill(parent, -1);
		for(int i = 0; i<adj.length; i++)
			adj[i] = new LinkedList<Integer>();
		for(int i = 0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			adj[a].add(b);
			adj[b].add(a);
		}
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(0);
		visited[0] = true;
		out:while(!q.isEmpty()){
			int current = q.removeFirst();
			LinkedList<Integer> neighbors = adj[current];
			for(int ne:neighbors){
				if(visited[ne] && ne!=parent[current]){
					System.out.println("NO");
					return;
				}
				if(!visited[ne]){
					q.add(ne);
					visited[ne] = true;
					parent[ne] = current;
				}
			}
		}
		for(boolean b:visited)
			if(!b){
				System.out.println("NO");
				return;
			}
		
		System.out.println("YES");
	}
}
