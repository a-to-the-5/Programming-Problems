import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class T9Spelling {
	
	static String[] vals = new String[]{"2","22","222","3","33","333","4","44","444",
		"5", "55", "555", "6", "66", "666", "7", "77", "777", "7777", "8", "88", "888",
		"9", "99", "999", "9999"};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("C-large.in")));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C-large.out")));
		int cases = Integer.parseInt(br.readLine().trim());
		for(int i = 1; i<=cases;i++){
			StringBuilder res = new StringBuilder("");
			String in = br.readLine();
			for(char c:in.toCharArray()){
				String v;
				if(c==' ') v="0";
				else v = vals[c-'a'];
				if(res.length()>0 && res.charAt(res.length()-1)==v.charAt(0))
					res.append(' ');
				res.append(v);
			}
			bw.write("Case #"+i+": "+res.toString()+"\n");
		}
		
		bw.close();
	}
}
