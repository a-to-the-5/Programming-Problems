import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class UVA558 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
		 new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		int cases = Integer.parseInt(br.readLine().trim());
		out:while(cases-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] distance = new int[n];
			Edge[] edges = new Edge[m];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[0] = 0;
			for(int i = 0; i<m; i++){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(x, y, t);
			}
			for(int i = 0; i<n; i++){
				for(Edge e:edges){
					if(distance[e.x]<Integer.MAX_VALUE &&distance[e.y]>e.t+distance[e.x])
						distance[e.y] = distance[e.x]+e.t;
				}
			}
			boolean cycle = false;
			for(Edge e:edges){
				if(distance[e.x]<Integer.MAX_VALUE &&distance[e.y]>e.t+distance[e.x]){
					System.out.println("possible");
					continue out;
				}
			}
			System.out.println("not possible");
		}
	}
}

class Edge{
	int x;
	int y;
	int t;
	public Edge(int x, int y, int t) {
		super();
		this.x = x;
		this.y = y;
		this.t = t;
	}
}
