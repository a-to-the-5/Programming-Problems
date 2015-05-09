import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class UVA762 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
		 new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		boolean first = true;
		while(true){
			if(!first && br.readLine()==null){
				return;
			}
			if(!first) System.out.println();
			int links = Integer.parseInt(br.readLine().trim());
			int cc = -1;
			HashMap<String, Integer> code = new HashMap<String, Integer>();
			HashMap<Integer, String> revcode = new HashMap<Integer, String>();
			HashMap<Integer, HashSet<Integer>> adj = new HashMap<Integer, HashSet<Integer>>();
			
			for(int i = 0; i<links; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				String src = st.nextToken();
				String dst = st.nextToken();
				Integer srci = code.get(src);
				if(srci==null) {
					code.put(src, srci = ++cc);
					revcode.put(srci, src);
				}
				Integer dsti = code.get(dst);
				if(dsti==null){
					code.put(dst, dsti = ++cc);
					revcode.put(dsti, dst);
				}
				HashSet<Integer> neighbors = adj.get(srci);
				if(neighbors==null) adj.put(srci, neighbors = new HashSet<Integer>());
				neighbors.add(dsti);
				
				neighbors = adj.get(dsti);
				if(neighbors==null) adj.put(dsti, neighbors = new HashSet<Integer>());
				neighbors.add(srci);
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			String src = st.nextToken();
			String dst = st.nextToken();
			Integer srci = code.get(src);
			Integer dsti = code.get(dst);
			if(srci==null || dsti == null){
				System.out.println("No route");
				
			} else{
				boolean[] visited = new boolean[code.size()];
				int[] parent = new int[code.size()];
				Arrays.fill(parent, -1);
				LinkedList<Integer> q = new LinkedList<Integer>();
				q.add(srci);
				out: while(!q.isEmpty()){
					int current = q.removeFirst();
					HashSet<Integer> n = adj.get(current);
					for(int s:n){
						if(!visited[s]){
							q.add(s);
							parent[s] = current;
							visited[s] = true;
							if(s == dsti)
								break out;
						}
					}
				}
				int test = parent[dsti];
				if(test==-1) System.out.println("No route");
				else{
					LinkedList<Integer> path = new LinkedList<Integer>();
					int temp = dsti;
					while(temp!=srci){
						path.addFirst(temp);
						temp = parent[temp];
					}
					path.addFirst(srci);
					for(int i = 0; i<path.size()-1; i++){
						System.out.println(revcode.get(path.get(i))+" "+revcode.get(path.get(i+1)));
					}
				}
			}
			first = false;
		}
	}
}
