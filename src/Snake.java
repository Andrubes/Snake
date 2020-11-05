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