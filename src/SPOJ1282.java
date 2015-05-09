import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class SPOJ1282 {
	static int[] dx = new int[]{-1,0,1}; 
	static char[][] map;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
		  new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		/*for(int i = 0; i<200; i++)
			System.out.print('.');
		System.out.println();
		for(int i = 0; i<200; i++){
			System.out.print('.');
			for(int j = 2; j<200; j++){
				System.out.print('#');
			}
			System.out.print('.');
			System.out.println();
		}
		for(int i = 0; i<200; i++)
			System.out.print('.');*/
		int cases = Integer.parseInt(br.readLine().trim());
		while(cases-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][];
			for(int i = 0; i<n; i++){
				map[i] = br.readLine().toCharArray();
			}
			int count = 0;
			
			for(int i = 0; i<n; i++){
				for(int j = 0; j<m; j++){
					if(map[i][j]=='#'){
						dfs(i,j);
						count ++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	static void dfs(int x, int y){
		Stack<Integer> xs = new Stack<Integer>();
		Stack<Integer> ys = new Stack<Integer>();
		xs.push(x); ys.push(y);
		while(!xs.isEmpty()){
			x = xs.pop();
			y = ys.pop();
			map[x][y] = '.';
			for(int i:dx){
				for(int j:dx){
					if(x+i>=0 && x+i<n && y+j>=0 && y+j<m && map[x+i][y+j]=='#'){
						xs.push(x+i);
						ys.push(y+j);
					}
				}
			}
		}
	}
}
