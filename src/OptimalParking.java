import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class OptimalParking {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine().trim());
		while(cases-->0)
		{
			int its = Integer.parseInt(br.readLine().trim());
			String[] itstrs = br.readLine().trim().split("\\s+");
			int max = -1, min = Integer.MAX_VALUE;
			for (int i = 0; i < itstrs.length; i++) {
				int temp = Integer.parseInt(itstrs[i]);
				if(temp>max) max = temp;
				if(temp<min) min = temp;
			}
			System.out.println((max-min)*2);
		}
	}
}
