import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;


public class Contacts {
	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\abdo\\Desktop\\b");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("all2.vcf")));
		for(File ff: f.listFiles()){
			BufferedReader br = new BufferedReader(new FileReader(ff));
			String s;
			while((s = br.readLine())!=null)
				bw.write(s+"\r\n");
			br.close();
		}
		bw.close();
		
	}
}
