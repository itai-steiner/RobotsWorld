//Name: Itai Steiner
public class Robot {
	public static final int UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4, MAX_TURNS = 3;
	private Position _robotPosition;
	private int _robotID, _robotDiraction;

	public Robot(int id, Position position, int diraction){
		_robotID = id;
		_robotPosition = position;
		_robotDiraction = diraction;
	}

	public Position getPosition(){
		return _robotPosition;
	}

	public int getID(){
		return _robotID;
	}

	public int getDiraction(){
		return _robotDiraction;
	}
	
	public void move(){
		switch(_robotDiraction){
		case UP:
			_robotPosition.setY((_robotPosition.getY())+1);
			break;
		case RIGHT:
			_robotPosition.setX((_robotPosition.getX()+1));
			break;
		case DOWN:
			_robotPosition.setY((_robotPosition.getY()-1));
			break;
		case LEFT:
			_robotPosition.setX((_robotPosition.getX()-1));
			break;
		}

	}

	public void turnRight(){
		if (_robotDiraction > LEFT)
			_robotDiraction = UP;
		else _robotDiraction++;
	}

	public void turnLeft(){
		for (int i=0; i<=MAX_TURNS; i++)
			this.turnRight();
	}
}