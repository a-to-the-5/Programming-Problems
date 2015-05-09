import java.util.Vector;


public class DNAMatching {
  /*  public static int getMaxSize(String[] dna){
        Vector<String> res = new Vector<String>();
        for(String s:dna)
            res.add(s);
        for(int i = 0; i<res.size();i++){
        	String r = revComp(res.get(i));
        	if(!r.equals(res.get(i)))
        		res.remove(res.get(i));
        }
        return res.size();
    }
   
    static String revComp(String s){
        String ss = new StringBuilder(s).reverse().toString();
        ss = ss.replace('A', '#');
        ss = ss.replace('T', 'A');
        ss = ss.replace('#', 'T');
       
        ss = ss.replace('C', '#');
        ss = ss.replace('G', 'C');
        ss = ss.replace('#', 'G');
        return ss;
    }*/
	 static double m[]= {7709179928849219.0, 771};
	 public static void main(String[] a)
	 {
		 if(m[1]--!=0){
			 m[0]*=2;main(a);}
		 else
			 System.out.println(m);
	 }
}

