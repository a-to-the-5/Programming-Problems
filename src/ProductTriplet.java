
public class ProductTriplet {
	public static long countTriplets(int minx, int maxx, int miny, int maxy, int minz, int maxz)
	{
		long res = 0;
		int limit = (int)Math.sqrt(maxz);
		int limit2 = (int)Math.sqrt(minz);
		for(int i = limit2; i<=limit; i++){
			if(i<=maxx && i>=minx){
				res+=Math.min(maxz/i, maxy)-Math.max(minz/i, miny)+1;
				if(i<=maxy && i>=miny)
					res+=Math.min(maxz/i, maxx)-Math.max(minz/i, minx);
			} else if(i<=maxy && i>=miny)
				res+=Math.min(maxz/i, maxx)-Math.max(minz/i, minx)+1;
		}
		return res;
	}
}
