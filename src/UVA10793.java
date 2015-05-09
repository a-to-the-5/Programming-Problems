import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class UVA10793 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
		 new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		int cases = Integer.parseInt(br.readLine().trim());
		for(int c = 1; c<=cases; c++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int[][] adj = new int[l][l];
			for(int i = 0; i<adj.length; i++)
				Arrays.fill(adj[i], Integer.MAX_VALUE);
			for(int i = 0; i<l; i++)adj[i][i] = 0;
			int d = Integer.parseInt(st.nextToken());
			for(int i = 0; i<d; i++){
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken())-1;
				int cost = Integer.parseInt(st.nextToken());
				adj[v][u] = adj[u][v] = Math.min(cost, adj[u][v]);
			}
			for(int m = 0; m<l; m++)
				for(int i = 0; i<l; i++)
					for(int j = 0; j<l; j++){
						if(adj[i][m]!=Integer.MAX_VALUE && adj[m][j]!=Integer.MAX_VALUE)
							adj[i][j] = Math.min(adj[i][j], adj[i][m]+adj[m][j]);
					}
			//for(int[] temp: adj)System.out.println(Arrays.toString(temp));
			//int res = -2;
			int max = Integer.MAX_VALUE;
			out: for(int i = 5; i<l; i++){
				for(int j = 1; j<5; j++){
					if(adj[i][j]!=adj[i][0] || adj[i][0]==Integer.MAX_VALUE ) continue out;
				}
				int cmax = adj[i][0];
				for(int j = 1; j<l; j++)
					cmax = Math.max(cmax, adj[i][j]);
				if(max>cmax){
					max = cmax;
					//res = i;
				}
			}
			System.out.println("Map "+c+": "+(max==Integer.MAX_VALUE?-1:max));
		}
	}
}
