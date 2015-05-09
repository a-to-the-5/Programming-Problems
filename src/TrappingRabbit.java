
public class TrappingRabbit {
	public static int findMinimumTime(int[] trapX, int[] trapY)
	{
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<trapX.length; i++)
			if(trapX[i]+trapY[i]<min) min = trapX[i]+trapY[i];
		return min;
	}
}
