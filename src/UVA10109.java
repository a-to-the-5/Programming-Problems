import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class UVA10109 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(System.in)));
		boolean first = true;
		out: while(true){
			if(!first) br.readLine();
			first = false;
			int num = Integer.parseInt(br.readLine().trim());
			if(num==0) return;
			System.out.println("Solution for Matrix System # "+num);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int columns = Integer.parseInt(st.nextToken())+1;
			int rows = Integer.parseInt(st.nextToken());
			Frac[][] matrix = new Frac[rows][columns];
			for (int i = 0; i < rows; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < columns; j++) {
					matrix[i][j] = Frac.parseFrac(st.nextToken());
				}
			}
			
			for(Frac[] fa:matrix)
			System.out.println(Arrays.toString(fa));
			
			for(int i = 0; i<rows; i++){
				int f = Integer.MAX_VALUE;
				
				for(int j = 0; j<columns-1; j++){
					if(matrix[i][j].num!=0){ 
						f = j;
						break;
					}
				}
				if(f==Integer.MAX_VALUE){
					//System.out.println("No Solution.");
					continue ;//out;
				}
				
				for(int j = columns-1; j>=f; j--){
					matrix[i][j] = matrix[i][j].divide(matrix[i][f]);
				}
				
				for(int j = 0; j<rows; j++){
					if(i!=j && matrix[j][f].num!=0){
						for(int k = i; k<columns; k++){
							matrix[j][k] = matrix[j][k].sub(matrix[j][f].multiply(matrix[i][k]));
						}
					}
				}
			}

			for(Frac[] fa:matrix)
			System.out.println(Arrays.toString(fa));
			
			Frac[] sols = new Frac[rows];
			
			for(int i = 0; i<rows; i++){
				int ind = -1;
				for(int j = 0; j<columns-1; j++){
					if(matrix[i][j].num!=0) ind = j;
				}
				//System.out.println(i+" "+ind);
				if (ind ==-1) continue;
				sols[ind] = matrix[i][columns-1];
			}
			
			for(int i = 0; i<rows; i++){
				System.out.println("x["+(i+1)+"] = "+sols[i]);
			}
		}
	}
}

class Frac{
	int num;
	int den;
	
	public Frac(int n, int d) {
		 num = n; den = d;
	}
	
	Frac multiply(Frac other){
		return new Frac(num*other.num, den* other.den);
	}
	
	Frac divide(Frac other){
		return  new Frac(num*other.den, den*other.num);
	}
	
	Frac add(Frac other){
		return new Frac(num*other.den+other.num*den, den*other.den);
	}
	
	Frac sub(Frac other){
		return new Frac(num*other.den-other.num*den, den*other.den);
	}
	
	static Frac parseFrac(String s){
		int i = s.indexOf('/');
		if(i==-1) return new Frac(Integer.parseInt(s), 1);
		return new Frac(Integer.parseInt(s.substring(0, i)), 
				Integer.parseInt(s.substring(i+1, s.length())));
	}
	
	@Override
	public String toString() {
		if(den==1) return ""+num;
		if(num*den<0)
			return "-"+Math.abs(num)+"/"+Math.abs(den);
		return num+"/"+den;
	}
}