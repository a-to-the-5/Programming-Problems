import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Anim {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setLayout(null);
		JPanel lbl = new JPanel();
		lbl.setBounds(10, 10, 40, 40);
		lbl.setBackground(Color.BLACK);
		T timer = new T(frame,6,2, lbl);
		Timer t = new Timer();
		frame.add(lbl);
		frame.setVisible(true);
		t.schedule(timer, 0, 20);
	}
}

class MyPanel extends JPanel{
	Shape circle = new Ellipse2D.Float(0f, 0f, 30f, 30f);
	public void paint(Graphics g) {
	    Graphics2D ga = (Graphics2D)g;
	    ga.draw(circle);
	    ga.setPaint(Color.green);
	    ga.fill(circle);
	}
}

class T extends TimerTask{
	JPanel lbl;
	int xdir, ydir;
	Container parent;
	
	public T(Container c, int x, int y, JPanel l) {
		parent = c;
		xdir = x; ydir = y;
		lbl = l;
	}
	
	@Override
	public void run() {
		int cx = lbl.getX(), cy = lbl.getY();
		if(cx > parent.getWidth()-lbl.getWidth()-15 || cx<0) xdir = -1*xdir;
		if(cy > parent.getHeight()-lbl.getHeight()-35 || cy<0) ydir = -1*ydir;
		lbl.setLocation(cx+xdir, cy+ydir);
		lbl.repaint();
		lbl.revalidate();
	}
	
}