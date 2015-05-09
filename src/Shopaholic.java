import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Shopaholic {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine().trim());
		while(cases-->0)
		{
			int its = Integer.parseInt(br.readLine().trim());
			String[] itstrs = br.readLine().trim().split("\\s+");
			int[] items = new int[its];
			for (int i = 0; i < itstrs.length; i++) {
				items[i] = Integer.parseInt(itstrs[i]);
			}
			Arrays.sort(items);
			int res = 0;
			for(int i = items.length-3; i>=0; i-=3){
				res+=items[i];
			}
			System.out.println(res);
		}
	}
}
