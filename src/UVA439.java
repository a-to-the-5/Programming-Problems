import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class UVA439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
		 new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		String s;
		out:while((s = br.readLine())!=null){
			StringTokenizer st = new StringTokenizer(s);
			String src = st.nextToken();
			String dst = st.nextToken();
			int xs = src.charAt(0)-'a';
			int ys = src.charAt(1)-'1';
			Point srcp = new Point(xs, ys);
			int xd = dst.charAt(0)-'a';
			int yd = dst.charAt(1)-'1';
			Point dstp = new Point(xd, yd);
			LinkedList<State> q = new LinkedList<State>();
			HashSet<Point> visited = new HashSet<Point>();
			q.add(new State(srcp, 0));
			while(!q.isEmpty()){
				State current = q.removeFirst();
				if(current.p.equals(dstp)){
					System.out.printf("To get from %s to %s takes %d knight moves.\n",
							src, dst, current.dist);
					continue out; 
				}
				LinkedList<State> r = current.getNeighbors();
				for(int i = 0; i<r.size(); i++){
					State ss = r.get(i);
					if(!visited.contains(ss.p)){
						q.add(ss);
						visited.add(ss.p);
					}
				}
				//q.addAll(r);
			}
		}
	}
}

class State{
	Point p;
	int dist;
	public State(Point p, int dist) {
		super();
		this.p = p;
		this.dist = dist;
	}
	LinkedList<State> getNeighbors(){
		LinkedList<State> res = new LinkedList<State>();
		for(int i = 1; i<=2; i++){
			res.add(new State(new Point(p.x-i, p.y-(3-i)), dist+1));
			res.add(new State(new Point(p.x-i, p.y+(3-i)), dist+1));
			res.add(new State(new Point(p.x+i, p.y-(3-i)), dist+1));
			res.add(new State(new Point(p.x+i, p.y+(3-i)), dist+1));
		}
		for(int i = 0; i<res.size(); i++){
			Point c = res.get(i).p; 
			if(c.x>7 || c.x<0 || c.y>7 || c.y<0){
				res.remove(i);
				i--;
			}
		}
		return res;
	}
	
	public String toString() {
		return "{("+p.x+","+p.y+")- "+dist+"}";
	}
}
