//Name: Itai Steiner

import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class RobotMain extends JFrame {
	public static final int WORLD_SIZE = 500;
	private RobotCell[][] _cells;
	private int worldSize;
	

	public RobotMain() {
		super("Robot world");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		do {
			String worldSizeS = JOptionPane
					.showInputDialog("Please enter the size of the Robot world.\nMax amount is up to 10, minimum amount is 3.");
			if (worldSizeS == null)
				return;
			try {
				worldSize = Integer.parseInt(worldSizeS);
			} catch (NumberFormatException exp) {
				JOptionPane.showMessageDialog(null, "Error: You enterd " + worldSizeS + ". That is not a number.",
						"Wrong input", JOptionPane.ERROR_MESSAGE);
			}
			if (worldSize < 1)
				JOptionPane.showMessageDialog(null,
						"Error: You enterd " + worldSize + ". Robot world shuld be grater than zero", "Wrong input",
						JOptionPane.ERROR_MESSAGE);
		} while (worldSize < 1);
		setSize(WORLD_SIZE, WORLD_SIZE);
		setVisible(true);
		_cells = new RobotCell[worldSize][worldSize];
		setLayout(new GridLayout(worldSize, worldSize, 0, 0));
		for (int i = 0; i < worldSize; i++)
			for (int j = 0; j < worldSize; j++) {
				_cells[i][j] = new RobotCell();
				_cells[i][j].setVisible(true);
				add(_cells[i][j]);
			}		
		validate();
		repaint();
	}

	public static void main(String[] args) {
		RobotMain RobotMain = new RobotMain();
	}
	
}

