//Name: Itai Steiner
import javax.swing.*;
import java.awt.*;

public class RobotCell extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(0,0,getWidth()-1,getHeight()-1);
		}
	
	public void creatRobot(Graphics g, Color c){
		g.setColor(c);
		g.fillOval(0, 0, getWidth()-1,getHeight()-1);

	}
	
}