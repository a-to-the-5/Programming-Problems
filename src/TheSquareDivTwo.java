
public class TheSquareDivTwo {
	public static String[] solve(String[] board)
	{
		char[][] res = new char[board.length][board.length];
		
		int[] R  = new int[board.length];
		
		for(int i = 0; i<board.length; i++)
		{
			int sum = 0;
			for(char c:board[i].toCharArray())
				if(c=='C')
					sum++;
			R[i] = sum;
		}
		
		for(int i = 0; i< R.length; i++)
		{
			int j;
			for(j = 0; j<R[i]; j++)
				res[board.length-1-j][i]='C';
			while(board.length-1-j>=0)
			{
				res[board.length-1-j][i]='.'; j++;
			}
		}
		
		String[] ret = new String[board.length];
		
		for(int i = 0; i<board.length; i++)
			ret[i] = new String(res[i]);
		
		return ret;
	}
}
