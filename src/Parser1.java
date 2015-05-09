import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Vector;


public class Parser1 {
	static String lookAhead;
	static Lab5Analyzer lxr;
	static Vector<Double> ress = new Vector<Double>();
	public static void main(String[] args) throws Exception {
		lxr = new Lab5Analyzer(
				new BufferedReader(new FileReader
						("C:/Users/abdo/My GUC/compilers/lab/comp lab 5/MMParser.in")));
		BufferedWriter bw = new BufferedWriter(new FileWriter
				("C:/Users/abdo/My GUC/compilers/lab/comp lab 5/My_MMParser.out"));
		lookAhead = lxr.next_token();
		list();
		for (int i = 1; i <= ress.size(); i++)
			bw.write(i+") "+roundTwoDecimals(ress.get(i-1))+"\r\n");
		bw.close();
	}
	
	static void match(String expectedToken) throws Exception {
		if(lookAhead.startsWith(expectedToken.substring(0,2)))
			lookAhead = lxr.next_token();
		else
			throw new ParsingError();
	}
	
	static void list() throws Exception{
		while(lookAhead!=null){
			ress.add(expr());
			match("SM");
		}
	}
	
	static double expr() throws Exception{
		double res = term();
		while(true){
			if(lookAhead.startsWith("MO")){
				match("MO");
				res-=term();
			}else if(lookAhead.startsWith("PO")){
				match("PO");
				res+=term();
			}else break;
		}
		return res;
	}
	
	static double term() throws Exception{
		double res = factor();
		while(true){
			if(lookAhead.startsWith("MB")){
				match("MB");
				res*=factor();
			}else if(lookAhead.startsWith("DB")){
				match("DB");
				res/=factor();
			}else if(lookAhead.startsWith("MD")){
				match("MD");
				res%=factor();
			}else break;
		}
		return res;
	}
	
	static double factor() throws Exception{
		if(lookAhead.startsWith("NM")){
			double res = Double.parseDouble(lookAhead.split("\t")[1]);
			match(lookAhead);
			return res;
		}
		else
		{
			match("LB");
			double res = expr();
			match("RB");
			return res;
		}
	}
	
	static double roundTwoDecimals(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}
}

class ParsingError extends Exception{
	
}