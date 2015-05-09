import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class SPOJ96 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
		  new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		boolean first = true;
		while(true){
			if(!first)
				br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			LinkedList<Integer>[] adj = new LinkedList[h*w];
			for(int i = 0; i<adj.length; i++)
				adj[i] = new LinkedList<Integer>();
			String[] shop = new String[h];
			for(int i =0; i<h; i++){
				shop[i] = br.readLine();
			}
			first = false;
		}
	}
}
