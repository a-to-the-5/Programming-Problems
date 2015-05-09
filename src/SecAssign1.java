import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class SecAssign1 {
	public static String caesarCipher(String msg, int shift, boolean encrypt){
		if(!encrypt) shift*=-1;
		StringBuilder encrypted = new StringBuilder();
		for(int i = 0; i<msg.length(); i++){
			int val = msg.charAt(i);
			if(msg.charAt(i)<='z' && msg.charAt(i)>='a'){
				val = (val-'a'+shift)%('z'-'a'+1) + 'a';
			} else if(msg.charAt(i)<='Z' && msg.charAt(i)>='A'){
				val = (val-'A'+shift)%('Z'-'A'+1) + 'A';
			}
			encrypted.append((char)val);
		}
		return encrypted.toString();
	}
	
	public static String columnarTranspositionEncrypt(String msg, String key){
		StringBuilder encrypted = new StringBuilder();
		HashMap<Character, Integer> positionInKey = new HashMap<Character, Integer>();
		for(int i = 0; i<key.length(); i++){
			positionInKey.put(key.charAt(i), i);
		}
		Character[] cs = positionInKey.keySet().toArray(new Character[0]);
		Arrays.sort(cs);
		while(msg.length()%key.length()!=0)
			msg+="\0";
		for(char c:cs){
			int pos = positionInKey.get(c);
			for(int j = pos; j<msg.length(); j+=key.length()){
				encrypted.append(msg.charAt(j));
			}
		}
		return encrypted.toString();
	}
	
	public static String columnarTranspositionDecrypt(String text, String key){
		char[] decrypted = new char[text.length()];
		HashMap<Character, Integer> positionInKey = new HashMap<Character, Integer>();
		for(int i = 0; i<key.length(); i++){
			positionInKey.put(key.charAt(i), i);
		}
		Character[] cs = positionInKey.keySet().toArray(new Character[0]);
		Arrays.sort(cs);
		for(char c:cs){
			int pos = positionInKey.get(c);
			for(int j = pos*(text.length()/key.length()), k = 0; k<text.length()/key.length(); j++, k++){
				decrypted[k*key.length()+pos] = text.charAt(j);
			}
		}
		return new String(decrypted);
	}
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String msg = br.readLine();
		String s;
		System.out.println(s = caesarCipher("WEAREDISCOVEREDFLEEATONCE", 1, true));
		System.out.println(caesarCipher(s, 1, false));
		
		System.out.println(s = columnarTranspositionEncrypt("WEAREDISCOVEREDFLEEATONCE", "ZEBRAS"));
		System.out.println(columnarTranspositionDecrypt(s, "ZEBRAS"));
	}
}