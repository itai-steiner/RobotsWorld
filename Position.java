//Name: Itai Steiner
public class Position {
	private int _x, _y; //0,0 is bottom right corner.	
	public Position(){
		_x = 0;
		_y = 0;
	}
	
	public Position (int x, int y){
		_x = x;
		_y = y;
	}
	
	public void setX(int num){
		_x = num;
	}

	public void setY(int num){
		_y = num;
	}
	
	public int getX(){
		return _x;
	}
	
	public int getY(){
		return _y;
	}
}