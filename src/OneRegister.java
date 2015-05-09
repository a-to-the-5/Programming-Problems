import java.util.*;
public class OneRegister {
    public String getProgram(int s, int t) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        LinkedList<String>paths = new LinkedList<String>();
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(s);
        visited.add(0);
        visited.add(1);
        
        q.add(s);
        paths.add("");
        boolean first = true;
        while(!q.isEmpty()){
        	int current = q.removeFirst();
        	String path = paths.removeFirst();
        	if(current==t) return path;
        	if(current<=46340){
        		int mul = current*current;
        		if(!visited.contains(mul)){
        			q.add(mul);
        			paths.add(path+"*");
        		}
        	}
        	if(current<=Integer.MAX_VALUE/2){
        		int pl = current+current;
        		if(!visited.contains(pl)){
        			q.add(pl);
        			paths.add(path+"+");
        		}
        	}
        	if(first){
        		q.add(0);
                q.add(1);
        		paths.add("-");
                paths.add("/");
                first = false;
        	}
        }
        return ":-(";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
    	char[] t = new char[]{'+','-','/','*'};
    	Arrays.sort(t);
    	System.out.println(t);
        try {
            eq(0,(new OneRegister()).getProgram(7, 392),"+*+");
            eq(1,(new OneRegister()).getProgram(7, 256),"/+***");
            eq(2,(new OneRegister()).getProgram(4, 256),"**");
            eq(3,(new OneRegister()).getProgram(7, 7),"");
            eq(4,(new OneRegister()).getProgram(7, 9),":-(");
            eq(5,(new OneRegister()).getProgram(10, 1),"/");
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
