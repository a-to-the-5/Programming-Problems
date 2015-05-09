import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class HanoiTower {
	public static int moves(String pegA, String pegB, String pegC)
	{
		boolean[] visited = new boolean[6000000];
		Arrays.fill(visited, false);
		LinkedList<StringBuilder> As = new LinkedList<StringBuilder>();
		LinkedList<StringBuilder> Bs = new LinkedList<StringBuilder>();
		LinkedList<StringBuilder> Cs = new LinkedList<StringBuilder>();
		int moves = 0;
		
		StringBuilder stateA = new StringBuilder(pegA);
		StringBuilder stateB = new StringBuilder(pegB);
		StringBuilder stateC = new StringBuilder(pegC);
		As.push(stateA);
		Bs.push(stateB);
		Cs.push(stateC);
		
		while(!As.isEmpty()){
			stateA = As.pop();
			stateB = Bs.pop();
			stateC = Cs.pop();
			
			
			
			moves++;
		}
		
		
		return moves;
	}
}
