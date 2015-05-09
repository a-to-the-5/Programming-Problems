import java.util.HashMap;


public class RandomSort {
	static HashMap<Integer, Double> dp = new HashMap<Integer, Double>();
	public static double getExpected(int[] permutation)
	{
		return solve(permutation);
	}
	
	public static double solve(int[] permutations){
		//StringBuilder sb = new StringBuilder();
		int key = 0;
		int accum = 1;
		for (int i = 0; i < permutations.length; i++) {
			key+=permutations[i]*accum;
			accum*=10;
			//sb.append(permutations[i]);
		}
		Double res = dp.get(key);
		if(res!=null) return res;
		double steps = 0;
		int options = 0;
		for (int i = 0; i < permutations.length; i++) {
			for (int j = 0; j < permutations.length; j++) {
				if(i<j && permutations[i]>permutations[j])
				{
					int temp = permutations[i];
					permutations[i] = permutations[j];
					permutations[j] = temp;
					steps+=solve(permutations)+1;
					temp = permutations[i];
					permutations[i] = permutations[j];
					permutations[j] = temp;
					options++;
				}
			}
		}
		if(options==0)
		{
			dp.put(key, 0.0);
			return 0;
		}
		else
		{
			dp.put(key, steps/options);
			return steps/options;
		}
	}
}
