import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;


public class PhoneList {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine().trim());
		while(cases-->0)
		{
			TrieNode tr = new TrieNode();
			boolean ok = true;
			int its = Integer.parseInt(br.readLine().trim());
			while(its-->0)
			{
				String num = br.readLine().trim();
				if(true)
					ok &= tr.start(num);
			}
			System.out.println(ok? "YES":"NO");
		}
	}
}

class TrieNode{
	HashMap<Character, TrieNode> children;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}
	
	public boolean start(String s){
		TrieNode tr = children.get(s.charAt(0));
		if(tr==null){
			return insert(s, true);
		}
		else
			return insert(s, false);
	}
	
	public boolean insert(String num, boolean newPath){
		if(num.length()==0)
			return newPath;
		if(newPath){
			TrieNode tr = children.get(num.charAt(0));
			//System.out.println(tr);
			if(tr == null)
				tr = new TrieNode();
			tr.insert(num.substring(1, num.length()), newPath);
			children.put(num.charAt(0), tr);
			return true;
		} else {
			if(children.size()==0)
				return false;
			else{
				TrieNode tr = children.get(num.charAt(0));
				if(tr==null){
					tr = new TrieNode();
					children.put(num.charAt(0), tr);
					return tr.insert(num.substring(1, num.length()), true);
				} else {
					return tr.insert(num.substring(1, num.length()), false);
				}
			}
		}
	}
}