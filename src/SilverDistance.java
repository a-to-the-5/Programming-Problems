
public class SilverDistance {
	public static int minSteps(int sx, int sy, int gx, int gy)
	{
		if(Math.abs(gy-sy)>=Math.abs(gx-sx) && gy-sy>=0)
		{
			return gy-sy;
		}
		int xd = Math.abs(gx-sx), yd = Math.abs(gy-sy);
		if(Math.abs(xd-yd)%2==0)
		{
			return Math.max(xd, yd);
		}
		if(xd>yd)
			return xd+1;
		return yd+2;
	}
}
