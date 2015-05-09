import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class FunctionDependency {
	public static String[] scriptingOrder(String[] funcs, String[] depends){
		boolean[] done = new boolean[funcs.length];
		Arrays.fill(done, false);
		HashMap<String, HashSet<String>> deps = new HashMap<String, HashSet<String>>();
		for(int i =0; i<funcs.length; i++){
			HashSet<String> s = new HashSet<String>();
			String[] d = depends[i].split(" ");
			for(int j = 0; j<d.length; j++){
				if(d[j].length()>0)
				s.add(funcs[Integer.parseInt(d[j])]);
			}
			deps.put(funcs[i], s);
		}
		String [] keys = deps.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		int k = 0;
		String[] ret = new String[funcs.length];
		out: while(k<ret.length){
			for(int i = 0; i<keys.length; i++){
				if(!done[i] && deps.get(keys[i]).size()==0){
					done[i]= true;
					ret[k++]=keys[i];
					for(String s: keys)
						deps.get(s).remove(keys[i]);
					continue out;
				}
			}
		}
		return ret;
	}
}
