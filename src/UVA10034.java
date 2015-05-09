import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class UVA10034 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
		 new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		int cases = Integer.parseInt(br.readLine().trim());
		boolean first = true;
		while(cases-->0){
			br.readLine();
			double res = 0;
			int n = Integer.parseInt(br.readLine().trim());
			double[] xs = new double[n];
			double[] ys = new double[n];
			for(int i = 0; i<n; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				xs[i] = Double.parseDouble(st.nextToken());
				ys[i] = Double.parseDouble(st.nextToken());
			}
			boolean[] intree = new boolean[n];
			double[] dist = new double[n];
			Arrays.fill(dist, Double.POSITIVE_INFINITY);
			dist[0] = 0;
			int v = 0;
			while(!intree[v]){
				intree[v] = true;
				for(int i = 0; i<xs.length; i++){
					double d1 = (xs[i]-xs[v]);
					double d2 = (ys[i]-ys[v]);
					double d = Math.sqrt(d1*d1+d2*d2);
					if(dist[i]> d){
						dist[i] = d;
					}
				}
				v = 0;
				double d = Double.POSITIVE_INFINITY;
				for(int i = 0; i<xs.length; i++){
					if(!intree[i] && dist[i]<d){
						d = dist[i];
						v = i;
					}
				}
				res+=dist[v];
			}
			res-=dist[v];
			System.out.printf((first?"":"\n")+"%.2f\n",res);
			first = false;
		}
	}
}
