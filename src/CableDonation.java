import java.util.*;
public class CableDonation {
	public static int cable(String[] lengths){
		int nodes = lengths.length;
		int[] distance = new int[nodes];
		for(int i = 0;i < nodes;i++)
			for(int j = 0;j < nodes;j++){
				char c = lengths [i].charAt(j);
				int v = c=='0'?0:(c >= 'a' && c <= 'z'?c-'a'+1:c-'A'+27);
				//System.out.println((i+1)+" "+(j+1)+" "+v);
			}
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] intree = new boolean[nodes];
		int v = 0;
		distance[v] = 0;
		int sum = 0;
		int tree = 0;
		for(int i = 0; i<lengths.length; i++){
			if(intree[v])return -1;
			intree[v] = true;
			tree+=distance[v];
			for(int n = 0; n<lengths.length; n++){
				int link = Integer.MAX_VALUE;
				char a = lengths[v].charAt(n);
				char b = lengths[n].charAt(v);
				int x = (a=='0')?0:(a>='a' && a<='z')? a-'a'+1:a-'A'+27;
				int y = (b=='0')?0:(b>='a' && b<='z')? b-'a'+1:b-'A'+27;
				sum+= x+y;
				if(x!=0) link = x;
				if(y!=0) link = Math.min(link, y);
				if(!intree[n] && link!=Integer.MAX_VALUE)
					distance[n] = Math.min(distance[n], link);
			}
			int min = Integer.MAX_VALUE;
			for(int n = 0; n<lengths.length; n++){
				if(!intree[n] && distance[n]<min){
					min = distance[n];
					v = n;
				}
			}
			System.out.println(Arrays.toString(distance));
			System.out.println(v+" "+min+" "+distance[v]);
		}
		sum = sum/2;
		//System.out.println(sum+" "+tree);
		return sum-tree;
	}

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new CableDonation()).cable(new String[] { "abc",
                 "def",
                 "ghi" }),40);
            eq(1,(new CableDonation()).cable(new String[] { "a0",
                 "0b" }),-1);
            eq(2,(new CableDonation()).cable(new String[] { "0X00",
                 "00Y0",
                 "0000",
                 "00Z0" }),0);
            eq(3,(new CableDonation()).cable(new String[] { "Az",
                 "aZ" }),105);
            eq(4,(new CableDonation()).cable(new String[] { "0top",
                 "c0od",
                 "er0o",
                 "pen0" }),134);
            eq(5,(new CableDonation()).cable(new String[] {
            		"PnujO", "Jjrxt", "oAra0", "LlpTj", "IYaTY"}),579);
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
