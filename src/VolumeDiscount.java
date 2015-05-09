import java.util.Arrays;
import java.util.HashMap;


public class VolumeDiscount {
	public static int bestDeal(String[] priceList, int quantity){
		HashMap<Double, Integer[]> cpi = new HashMap<Double, Integer[]>();
		out: for(String s:priceList){
			String[] ss = s.split(" ");
			int units = Integer.parseInt(ss[0]);
			int cost = Integer.parseInt(ss[1]);
			if(units>quantity) continue out;
			cpi.put((cost*1.0)/units, new Integer[]{units, cost});
		}
		Double[] keys = cpi.keySet().toArray(new Double[0]);
		Arrays.sort(keys);
		int cost = 0;
		for(double k:keys){
			Integer[] i = cpi.get(k);
			while(quantity-i[0]>=0){
				quantity-=i[0];
				cost+=i[1];
			}
			if(quantity==0) break;
		}
		return cost;
	}
}
