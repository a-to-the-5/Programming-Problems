
public class AppleWord {
	public static 
	int minRep(String word)
	{
		if(word.length()<5) return -1;
		int sum = 0;
		word = word.toLowerCase();
		if(word.charAt(0)!='a')
			sum++;
		if(word.charAt(word.length()-1)!='e')
			sum++;
		if(word.charAt(word.length()-2)!='l')
			sum++;
		for(int i = 1; i< word.length()-2; i++)
			if(word.charAt(i)!='p')
				sum++;
		return sum;
	}
}
