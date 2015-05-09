import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashSet;

public class PlayingWithWheels {
	static StreamTokenizer st;
	private static int readInt()throws Exception
	{
	    st.nextToken();
	    return (int) st.nval;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//st=new StreamTokenizer(new BufferedInputStream(System.in));
		int cases = Integer.parseInt(br.readLine().trim());
		int a = cases;
		out: while(cases-->0){
			if(cases+1!=a)
				br.readLine();
			boolean[] visisted = new boolean[10000];
			Arrays.fill(visisted, false);
			String initial = br.readLine().trim().replaceAll("\\s+", "");
			if(initial.equals(""))
				initial = br.readLine().trim().replaceAll("\\s+", "");
			String target = br.readLine().trim().replaceAll("\\s+", "");
			if(target.equals(""))
				target = br.readLine().trim().replaceAll("\\s+", "");
			String q = br.readLine().trim();
			if(q.equals(""))
				q = br.readLine().trim();
			int f = Integer.parseInt(q);
			HashSet<String> forbidden = new HashSet<String>(f);
			for(int i = 0; i<f;i++){
				q = br.readLine().trim().replaceAll("\\s+", "");
				if(q.equals(""))
					q = br.readLine().trim().replaceAll("\\s+", "");
				forbidden.add(q.trim().replaceAll("\\s+", ""));
			}
			HashSet<String> current = new HashSet<String>();
			current.add(initial);
			HashSet<String> next = new HashSet<String>();
			for(int i = 0; !current.isEmpty() ;i++){
				for(String s:current){
					if(s.equals(target)){
						System.out.println(i);
						continue out;
					}
					if(visisted[Integer.parseInt(s)]) continue;
					visisted[Integer.parseInt(s)] = true;
					char[] c = s.toCharArray();
					for(int j = 0; j<c.length; j++){
						c = s.toCharArray();
						c[j] = (char)(c[j]+1);
						if(c[j]>'9') c[j] = '0';
						String temp = new String(c);
						if(!visisted[Integer.parseInt(temp)] && !forbidden.contains(temp)){
							next.add(temp);
						}
						
						c = s.toCharArray();
						c[j] = (char)(c[j]-1);
						if(c[j]<'0') c[j] = '9';
						temp = new String(c);
						if(!visisted[Integer.parseInt(temp)] && !forbidden.contains(temp)){
							next.add(temp);
						}
					}
				}
				current = next;
				next = new HashSet<String>();
			}
			System.out.println(-1);
		}
	}
}
