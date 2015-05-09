import java.text.DecimalFormat;
import java.util.*;
public class BestApproximationDiv1 {
    public String findFraction(int maxDen, String number) {
        String res = "";
        DecimalFormat dc = new DecimalFormat("0.000000000");
        double n = Double.parseDouble(number);
        int numerator = -1, denominator = -1, diff = 0;
        for(int i = 1; i<=maxDen; i++){
        	int n1 = (int)Math.floor(i*n);
        	int n2 = (int)Math.ceil(i*n);
        	String d1 = (""+dc.format(n1/(1.0*i))).substring(0, 10);
        	String d2 = (""+dc.format(n2/(1.0*i))).substring(0, 10);
        	int diff1 = 8, diff2 = 8;
        	for(int j = 0; j<number.length(); j++){
        		if(diff1>j && d1.charAt(j)!=number.charAt(j)) diff1 = j;
        		if(diff2>j && d2.charAt(j)!=number.charAt(j)) diff2 = j;
        	}
//        	if(i==81){
//        		System.out.println(diff);
//        		System.out.println(n1);
//        		System.out.println(n2);
//        		System.out.println(diff1);
//        		System.out.println(diff2);
//        		System.out.println("&&&&&&&&&&&&");
//        	}
        	if(numerator==-1 || diff1>diff || diff2>diff){
        		if(diff1<diff2){
        			diff = diff2;
        			numerator = n2;
        			denominator = i;
        		}else{
        			diff = diff1;
        			numerator = n1;
        			denominator = i;
        		}
        	}
        }
        return numerator+"/"+denominator+" has "+(diff-1)+" exact digits";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
    	System.out.println(1.0/1000);
        try {
            eq(0,(new BestApproximationDiv1()).findFraction(42, "0.141592"),"1/7 has 3 exact digits");
            eq(1,(new BestApproximationDiv1()).findFraction(3, "0.133700"),"0/1 has 1 exact digits");
            eq(2,(new BestApproximationDiv1()).findFraction(1000, "0.123456"),"10/81 has 7 exact digits");
            eq(3,(new BestApproximationDiv1()).findFraction(1000, "0.420000"),"21/50 has 7 exact digits");
            eq(4,(new BestApproximationDiv1()).findFraction(100, "0.909999"),"10/11 has 4 exact digits");
            eq(5,(new BestApproximationDiv1()).findFraction(115, "0.141592"),"16/113 has 7 exact digits");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
    private static void eq( int n, int a, int b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
	private static void eq( int n, double a, double b ) {
        if ( Math.abs(a-b) < 1e-9)
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, char a, char b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
    }
    private static void eq( int n, long a, long b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, boolean a, boolean b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, String a, String b ) {
        if ( a != null && a.equals(b) )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
    }
    private static void eq( int n, int[] a, int[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++)
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, long[] a, long[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, String[] a, String[] b ) {
        if ( a.length != b.length) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if( !a[i].equals( b[i])) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void print( int a ) {
        System.err.print(a+" ");
    }
    private static void print( long a ) {
        System.err.print(a+"L ");
    }
    private static void print( String s ) {
        System.err.print("\""+s+"\" ");
    }
    private static void print( int[] rs ) {
        if ( rs == null) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( long[] rs) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( String[] rs ) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print( "\""+rs[i]+"\"" );
            if( i != rs.length-1)
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
