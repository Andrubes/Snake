import java.util.ArrayList;

public class Snake{
	
	private int length;
	private ArrayList<Coords> positions = new ArrayList<>();
	private Model model;
	
	public Snake(Model m) {
		model = m;
		length = model.getLength();
	}
	
	public void setLength() {
		length = model.getLength();
	}

	public int getLength() {
		return length;
	}
	
	//adds the new Coords of the snake head to the positions list
	//removes the Coords for the back of the snake if the size of the list is larger than the length of the snake
	public Coords updatePositions() {
		setLength();
		positions.add(new Coords(model.getSnakeX(), model.getSnakeY()));
		if(positions.size() > length) {
			return positions.remove(0);
		}
		return new Coords(-99,-99);
	}
	
	public ArrayList<Coords> getPositions(){
		return positions;
	}
	
}