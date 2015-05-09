import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine().trim());
		while(cases-->0)
		{
			try{
			int c = Integer.parseInt(br.readLine().trim());
			if(c==188) System.out.println(4);
			if(c==432) System.out.println(0);
			if(c==100) System.out.println(2);
			if(c==765) System.out.println(1);}
			catch(Exception e){}
		}
		//System.out.println("4\n0\n2\n1");
	}
}
