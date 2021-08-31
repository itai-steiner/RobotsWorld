//Name: Itai Steiner
import java.util.Random;

public class RobotsWorld  {
	private static final int MAX_WORLD_SIZE = 100, MAX_CELLS = 10, UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4; 
	private static int count = 1;
	private Robot[][] _robots;
	private int _numOfCellsInLine;

	public RobotsWorld(int numOfCells){
		if (numOfCells > MAX_WORLD_SIZE){
			_robots = new Robot[MAX_CELLS][MAX_CELLS];
			_numOfCellsInLine = MAX_CELLS;
		}
		else {
			_numOfCellsInLine = (int)Math.sqrt(numOfCells);
			_robots = new Robot[_numOfCellsInLine][_numOfCellsInLine];		
		}
	}
	public int getNumOfCellsInLine(){
		return _numOfCellsInLine;
	}
	
	public int getNumOfCells(){
		return (getNumOfCellsInLine() * getNumOfCellsInLine());
	}

	//checking if position inside the robots world and if it's free.
	private boolean emptyAndInside(Position p){
		if ((_robots[p.getX()][p.getY()] != null) || 
				(p.getX() <= _robots.length || p.getX() >= 0) || 
				(p.getY() <= _robots[0].length || p.getY() >= 0)) {
			return true;
		}
		else return false;
	}

	//checking if the next position that robot move to is free.
	private boolean isNextEmpty(Position p){
		Robot tempR;
		if ((tempR = this.getRobot(p)) != null){
			switch(tempR.getDiraction()){
			case UP:
				if (_robots[(p.getX()+1)][p.getY()] == null)
					return true;
			case RIGHT:
				if (_robots[(p.getX())][p.getY()+1] == null)
					return true;
			case DOWN:
				if (_robots[(p.getX()-1)][p.getY()] == null)
					return true;
			case LEFT:
				if (_robots[(p.getX())][p.getY()-1] == null)
					return true;
			}
		}
		return false;

	}

	public void addRobot (Position p) throws IllegalPosition{
		Random rand = new Random();

		try{ 
			if (emptyAndInside(p)) {
				_robots[p.getX()][p.getY()] = new Robot (count, p, rand.nextInt(LEFT)+1);
				RobotsWorld.count++;		
			}
			else throw(new IllegalPosition());
		}
		catch (IllegalPosition e) {
			System.out.println(e.getMessage());
		}
	}

	public Robot removeRobot(Position p){
		Robot tempRobot;
		if (emptyAndInside(p)) {
			tempRobot = getRobot(p);
			_robots[p.getX()][p.getY()] = null;
			return tempRobot;
		}
		else return null;

	}

	public Robot getRobot(Position p) {
		if (emptyAndInside(p)) {
			return _robots[p.getX()][p.getY()];
		}
		else return null;
	}

	public void moveRobot(Position p) throws IllegalPosition {

		try{ 
			if (emptyAndInside(p) && isNextEmpty(p)) {
				removeRobot(getRobot(p).getPosition());
				getRobot(p).move();
				addRobot(getRobot(p).getPosition()); //adding again robot to matrix
			}
			else throw(new IllegalPosition());
		}
		catch (IllegalPosition e) {
			System.out.println(e.getMessage());
		}		
	}
}

