import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SPOJ381 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
		 new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		String s;
		while(!(s = br.readLine().trim()).equals("0")){
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			double[][] adj = new double[n+1][n+1];
			for(double[] a:adj)
				Arrays.fill(a, Double.POSITIVE_INFINITY);
			for(int i = 0; i<m; i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				adj[a][b] = (100-p)/100.0;
				adj[b][a] = (100-p)/100.0;
			}
			double[] dist = new double[n+1];
			boolean[] visited = new boolean[n+1];
			Arrays.fill(dist, Double.POSITIVE_INFINITY);
			dist[1] = 0;
			int v = 1;
			while(!visited[v]){
				System.out.println(Arrays.toString(dist));
				visited[v] = true;
				for(int i = 1; i<adj[v].length; i++){
					if(adj[v][i]!=Double.POSITIVE_INFINITY){
						double d = adj[v][i]+dist[v];
						if(!visited[i] && dist[i]>d){
							dist[i] = d;
						}
					}
				}
				v = 1;
				double d = Double.POSITIVE_INFINITY;
				for(int i = 1; i<n+1; i++){
					if(!visited[i] && d>dist[i]){
						d = dist[i];
						v = i;
					}
				}
			}
			System.out.println(((1-dist[n])*100)+" percent");
		}
	}
}
