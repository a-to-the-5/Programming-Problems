import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Twitter {
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter("egypt.data"));
		GregorianCalendar gc = new GregorianCalendar(2011, GregorianCalendar.JANUARY,25);
		GregorianCalendar comp = new GregorianCalendar();
		comp.roll(Calendar.DAY_OF_MONTH, true);
		String s = "http://search.twitter.com/search.json";
		String p1 = "q=&ands=&phrase=&ors=egypt+jan25+mubarak&nots=&tag=&" +
				"lang=all&from=&to=&ref=&near=&within=15&units=mi&" +
				"since=";
		String sdate = "2011-01-24";
		String p2 = "&until=";
		String udate = "2011-02-18";
		String p3 = "&rpp=100&page=";
		int next = 1;
		for(int i = 1; gc.before(comp) ; i++){
			Thread.sleep(2000);
			int mon = (gc.get(GregorianCalendar.MONTH)+1);
			String fuck = ""+mon;
			if(mon<10) fuck = "0"+mon;
			int day = gc.get(GregorianCalendar.DAY_OF_MONTH);
			sdate = gc.get(GregorianCalendar.YEAR)+"-"
					+fuck+"-"+
					(day<10? "0"+day: ""+day);
			String stuff = p1+sdate+p2+sdate+p3+i;
			System.out.println(stuff);
			String res = HTTPRequestPoster.sendGetRequest(s, stuff);
			Pattern pp = Pattern.compile("next_page\":\"\\?page=(\\d+)");
			Matcher m = pp.matcher(res);
			bw.write(res+"\r\n");
			System.out.println(res);
			if(!m.find()){
				gc.roll(Calendar.DAY_OF_MONTH, true);
				System.out.println("###############################");
				System.out.println(sdate);
				System.out.println("###############################");
				i = 0;
			}else{
				next = Integer.parseInt(m.group(1)); 
				System.out.println(next+" "+i);
			}
		}
		bw.close();
		
	}
}
