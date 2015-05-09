import java.util.Vector;


public class ColoringRectangle {
	public static int chooseDisks(int width, int height, int[] red, int[] blue){
		Vector<Double> b = new Vector<Double>();
		for(int i:blue)
			b.add(i/2.0);
		Vector<Double> r = new Vector<Double>();
		for(int i:red)
			r.add(i/2.0);
		return Math.min(cd(width, height, r, b, true),
				cd(width, height, r, b, false));
	}
	
	public static int cd(double width, int height, Vector<Double> red, Vector<Double> blue,
			boolean isBlue){
		double max = -1;
		if(isBlue){
			for(int i = 0; i<blue.size(); i++)
				if(blue.get(i)>max)
				{
					if(max>-1) blue.add(max);
					max = blue.get(i);
					blue.removeElementAt(i);
				}
		} else {
			for(int i = 0; i<red.size(); i++)
				if(red.get(i)>max)
				{
					if(max>-1) red.add(max);
					max = red.get(i);
					red.removeElementAt(i);
				}
		}
		if(max*max>=0.25*height*height+0.25*width*width)
			return 1;
		else if(max==0 || 2*max < height)
			return -1;
		else
			return cd(2*Math.sqrt(max*max-height*height/4.0), height, red, blue, !isBlue);
	}
}
