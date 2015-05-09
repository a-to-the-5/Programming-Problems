import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;


public class PageHopping {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] path = new int[101][101];
		DecimalFormat df = new DecimalFormat("0.000");
		int c = 1;
		while(true){
			for(int[] i:path)
				Arrays.fill(i, Integer.MAX_VALUE/3);
			String[] inp = br.readLine().trim().split("\\s+");
			if(inp[0].equals("0")&& inp[1].equals("0"))
				return;
			HashSet<Integer> nodes = new HashSet<Integer>();
			int a, b, max = 0;
			for(int i =0; i<inp.length; i+=2)
			{
				path[a=Integer.parseInt(inp[i])][b=Integer.parseInt(inp[i+1])] = 1;
				if(a>0){
					nodes.add(a);nodes.add(b);
				}
				if(a>max)max = a;
				if(b>max)max = b;
			}
			
			for(int k : nodes)
				for(int i : nodes)
					for(int j : nodes)
						 path[i][j] = Math.min( path[i][j], path[i][k]+path[k][j] );
			int total = 0;
			for(int i : nodes)
				for(int j : nodes)
				{
					if(i!=j)
						total+=path[i][j];
				}
			
			System.out.println("Case "+c+": average length between pages = "+
					df.format(total/(nodes.size()*(nodes.size()-1.0)))+" clicks");
			c++;
		}
	}
}
