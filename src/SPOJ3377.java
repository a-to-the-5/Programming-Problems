import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class SPOJ3377 {
	static ArrayList<Integer>[] adj;
	static int[] color;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
		  new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		int cases = Integer.parseInt(br.readLine().trim());
		out:for(int scenario = 1; scenario<=cases; scenario++){
			System.out.println("Scenario #"+scenario+":");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n];
			visited = new boolean[n];
			color = new int[n];
			for(int i = 0; i<adj.length; i++){
				adj[i] = new ArrayList<Integer>();
			}
			for(int i = 0; i<e; i++){
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int d = Integer.parseInt(st.nextToken())-1;
				adj[s].add(d);
				adj[d].add(s);
			}
			for(int i = 0; i<n; i++){
				if(!visited[i] && !dfs(i,1)){
					System.out.println("Suspicious bugs found!\n");
					continue out;
				}
			}
			System.out.println("No suspicious bugs found!\n");
		}
	}
	
	static boolean dfs(int node, int c){
		if(color[node]==0){
			color[node] = c;
		} else {
			if(color[node]!=c)
				return false;
		}
		//if(visited[node]) return true;
		visited[node] = true;
		ArrayList<Integer> ns = adj[node];
		
		for(int n:ns){
			if(visited[n] && color[n]!=color[node]%2+1) return false;
			if(!visited[n] && !dfs(n, color[node]%2+1)) return false;
		}
		return true;
	}
}
