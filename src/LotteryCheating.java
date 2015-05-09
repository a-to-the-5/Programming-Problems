import java.util.Arrays;


public class LotteryCheating {
	public static int minimalChange(String ID){
		int min = Integer.MAX_VALUE;
		for(long i = 0; i*i<10000000000l; i++){
			if((""+(i*i)).length()>ID.length()) break;
			int dist = dist(ID,""+(i*i));
			if(dist<min) min = dist;
			if(dist==0) break;
		}
		return min;
	}
	
	static int dist(String a, String b){
		char[] x = new char[Math.max(b.length()-a.length(), 0)];
		char[] y = new char[Math.max(a.length()-b.length(), 0)];
		Arrays.fill(x, '0');
		Arrays.fill(y, '0');
		a = new String(x)+a;
		b = new String(y)+b;
		int count = 0;
		for(int i = 0; i<a.length(); i++){
			if(a.charAt(i)!=b.charAt(i))
				count++;
		}
		return count;
	}
}
