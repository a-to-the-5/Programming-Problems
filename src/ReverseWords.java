import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReverseWords {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("B-large.in")));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("B-large.out")));
		int cases = Integer.parseInt(br.readLine().trim());
		for(int i = 1; i<=cases;i++){
			String[] inp = br.readLine().split(" ");
			bw.write("Case #"+i+":");
			for(int j = inp.length-1; j>=0; j--){
				bw.write(" "+inp[j]);
			}
			bw.write("\n");
		}
		bw.close();
	}
}
