import java.util.Vector;


public class RunningMedian {
	public static void main(String[] args) {
		
	}
}

class TTTree{
	
}

class TTTNode<T extends Comparable<T>>{
	T guide;
	T val;
	
	TTTNode<T> parent;
	Vector<TTTNode<T>> children;
	
	public TTTNode(T v) {
		children = new Vector<TTTNode<T>>();
		val = v;
	}
	
	void insert(T e){
		
	}
	
	boolean isLeaf(){
		return children.size()==0;
	}
}