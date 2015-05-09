import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class UVA10004 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = 
		 new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		int n;
		out: while((n=Integer.parseInt(br.readLine().trim()))!=0){
			boolean[][] con = new boolean[n][n];
			int l = Integer.parseInt(br.readLine().trim());
			for(int i = 0; i<l; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				con[a][b] = con[b][a] = true; 
			}
			int[] colors = new int[n];
			Arrays.fill(colors, -1);
			LinkedList<Integer> q = new LinkedList<Integer>();
			q.add(0);
			colors[0] = 0;
			while(!q.isEmpty()){
				int current = q.removeFirst();
				for(int i = 0; i<n; i++){
					if(con[current][i]){
						if(colors[current]==colors[i]){
							System.out.println("NOT BICOLORABLE.");
							continue out;
						}
						if(colors[i]==-1){
							q.add(i);
							colors[i] = (colors[current]+1)%2;
						}
					}
				}
			}
			System.out.println("BICOLORABLE.");
		}
	}
}
