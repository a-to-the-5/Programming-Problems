import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class StoreCredit {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("A-large.in")));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("A-large.out")));
		int cases = Integer.parseInt(br.readLine().trim());
		out: for(int i = 1; i<=cases;i++){
			int c = Integer.parseInt(br.readLine().trim());
			br.readLine();
			String[] inp = br.readLine().trim().split("\\s+");
			int[] vals = new int[inp.length];
			for(int j = 0; j<inp.length; j++){
				vals[j] = Integer.parseInt(inp[j]);
			}
			for(int j = 0; j<inp.length; j++){
				for(int k = 0; k<inp.length; k++){
					if(j==k)continue;
					if(vals[j]+vals[k]==c){
						if(j<k)
							bw.write("Case #"+i+": "+(j+1)+" "+(k+1)+"\n");
						else
							bw.write("Case #"+i+": "+(k+1)+" "+(j+1)+"\n");
						continue out;
					}
				}
			}
		}
		bw.close();
	}
}
