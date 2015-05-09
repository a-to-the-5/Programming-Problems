import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;


public class CompLab2 {
	
	static BufferedReader br;
	static BufferedWriter bw;
	static HashSet<String> reservedWords = new HashSet<String>();
	static{
		reservedWords.add("abstract");
		reservedWords.add("assert");
		reservedWords.add("boolean");
		reservedWords.add("break");
		reservedWords.add("byte");
		reservedWords.add("case");
		reservedWords.add("catch");
		reservedWords.add("char");
		reservedWords.add("class");
		reservedWords.add("const");
		reservedWords.add("continue");
		reservedWords.add("default");
		reservedWords.add("do");
		reservedWords.add("double");
		reservedWords.add("else");
		reservedWords.add("enum");
		reservedWords.add("extends");
		reservedWords.add("false");
		reservedWords.add("final");
		reservedWords.add("finally");
		reservedWords.add("float");
		reservedWords.add("for");
		reservedWords.add("goto");
		reservedWords.add("if");
		reservedWords.add("implements");
		reservedWords.add("import");
		reservedWords.add("instanceof");
		reservedWords.add("int");
		reservedWords.add("interface");
		reservedWords.add("long");
		reservedWords.add("native");
		reservedWords.add("new");
		reservedWords.add("null");
		reservedWords.add("package");
		reservedWords.add("private");
		reservedWords.add("protected");
		reservedWords.add("public");
		reservedWords.add("return");
		reservedWords.add("short");
		reservedWords.add("static");
		reservedWords.add("strictfp");
		reservedWords.add("super");
		reservedWords.add("switch");
		reservedWords.add("synchronized");
		reservedWords.add("this");
		reservedWords.add("throw");
		reservedWords.add("throws");
		reservedWords.add("transient"); 
		reservedWords.add("true");
		reservedWords.add("try");
		reservedWords.add("void");
		reservedWords.add("volatile");
		reservedWords.add("while");
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader
		(new InputStreamReader(new FileInputStream("JMPalindrome.in")));
		
		bw = new BufferedWriter
		(new OutputStreamWriter(new FileOutputStream("my_JMPalindrome.out")));
		
		int state = 1;
		char c;
		StringBuilder sb = new StringBuilder();
		int temp = 0;
		
		//int k = 10000;
		out: while(true)
		{
			switch(state)
			{
			case 1: c = (char)br.read();
			if(c == (char)(-1))
				break out;
			if(c==' ' || c=='\t' || c=='\n' || c=='\f' || c == '\r');
			else if(c == '/'){
				state = 2;
			} else if(c == '('){
				state = 4;
			} else if(c == '['){
				state = 5;
			} else if(c == '='){
				state = 6;
			} else if(c == '<'){
				state = 7;
			} else if(c == '>'){
				state = 8;
			} else if(c == '!'){
				state = 9;
			} else if(c == '.'){
				print(".", "DO");
			} else if(c == '*'){
				print("*", "MB");
			} else if(c == ','){
				print(",", "FA");
			} else if(c == ';'){
				print(";", "SM");
			} else if(c == '{'){
				print("{", "LC");
			} else if(c == '}'){
				print("}", "RC");
			} else if(c == ')'){
				print(")", "RB");
			} else if(c == ']'){
				print("]", "RS");
			} else if(c == '+'){
				print("+", "PO");
			}  else if(c == '-'){
				print("-", "MO");
			}  else if(c == '|'){
				print("|", "LO");
			}  else if(c == '&'){
				print("&", "LA");
			} else if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == '_'){
				//br.mark(52);
				sb = new StringBuilder(""+c);
				state = 10;
			} else if(c >= '0' && c <= '9'){
				//br.mark(52);
				temp = c-'0';
				state = 11;
			}
			break;
			
			case 2: br.mark(52); 
			c = (char)br.read();
			if(c == '/'){
				state = 3;
			} else {
				state = 1;
				br.reset();
				print("/", "DB");
			}
			break;
			
			case 3: while((c = (char)br.read())!= '\n' && c != (char)(-1));
			state = 1;
			break;
			
			case 4: br.mark(52); 
			c = (char)br.read();
			if(c == ')'){
				print("()", "MC");
				state = 1;
			} else {
				state = 1;
				br.reset();
				print("(", "LB");
			}
			break;
			
			case 5: br.mark(52); 
			c = (char)br.read();
			if(c == ']'){
				print("[]", "AA");
				state = 1;
			} else {
				state = 1;
				br.reset();
				print("[", "LS");
			}
			break;
			
			case 6: br.mark(52); 
			c = (char)br.read();
			if(c == '='){
				print("==", "EQ");
				state = 1;
			} else {
				state = 1;
				br.reset();
				print("=", "AO");
			}
			break;
			
			case 7: br.mark(52); 
			c = (char)br.read();
			if(c == '='){
				print("<=", "LE");
				state = 1;
			} else {
				state = 1;
				br.reset();
				print("<", "LT");
			}
			break;
			
			case 8: br.mark(52); 
			c = (char)br.read();
			if(c == '='){
				print(">=", "GE");
				state = 1;
			} else {
				state = 1;
				br.reset();
				print(">", "GT");
			}
			break;
			
			case 9: br.mark(52); 
			c = (char)br.read();
			if(c == '='){
				print("!=", "NE");
				state = 1;
			} else {
				state = 1;
				br.reset();
				print("!", "LN");
			}
			break;
			
			case 10:
			do{
				br.mark(52); 
				c = (char)br.read();
				if(!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') ||
						(c >= 'a' && c <= 'z') || c == '_')){
					br.reset();
					print(sb.toString(), 
							reservedWords.contains(sb.toString())?"KW":"ID");
					state = 1;
					break;
				} else {
					sb.append(c);
				}
			}while(true);
			break;
			
			case 11:
			do{
				br.mark(52); 
				c = (char)br.read();
				if(c >= '0' && c <= '9'){
					temp = temp*10 + (c-'0');
				} else {
					br.reset();
					print(""+temp, "NM");
					state = 1;
					break;
				}
			}while(true);
			break;
			}
		}
		bw.close();
	}
		
	static void print(String lexeme, String token) throws IOException
	{
		bw.write(""+token+"\t"+lexeme+"\t"+palin(lexeme)+"\n");
		System.out.println(token+"\t"+lexeme+"\t"+palin(lexeme));
	}
	
	static String palin(String s)
	{
		for(int i = 0; i< s.length()/2; i++)
			if(s.charAt(i)!= s.charAt(s.length()-1-i)) return "No";
		return "Yes";
	}
}
