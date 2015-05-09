import java.util.Arrays;

public class LotteryTicket {
	public static void main(String[] args) {
		System.out.println(Math.sqrt(4294967296l));
		/*System.out.println(buy(2,
				1,
				5,
				10,
				50));*/
	}
	public static String buy(int price, int b1, int b2, int b3, int b4){
		for(int i = 0; i<(1<<4);i++){
			System.out.println(i);
			String r = Integer.toBinaryString(i);
			System.out.println(r);
			char[] rest = new char[4-r.length()];
			Arrays.fill(rest, '0');
			r = new String(rest)+r;
			int sum = 0;
			if(r.charAt(0)!='0') sum+=b1;
			if(r.charAt(1)!='0') sum+=b2;
			if(r.charAt(2)!='0') sum+=b3;
			if(r.charAt(3)!='0') sum+=b4;
			if(sum==price)
				return "POSSIBLE";
		}
		return "IMPOSSIBLE";
	}
}
