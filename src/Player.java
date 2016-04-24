

public class Player {
		
	private String name;
	private int budget;
	private int spycams;
	private GraphNode node;
	
	
	public Player(String name, int budget, int spycams, GraphNode startNode){
		this.name = name;
		this.budget = budget;
		this.spycams = spycams;
		node = startNode;
	}

	public void decreaseBudget(int check) {
		budget = budget - check;
	}

	public boolean dropSpycam() {
		// TODO
		if (spycams == 0){
			System.out.println("Not enough spycams");
			return false;
		}
		
		return false;
	}
	
	public int getBudget() {
		return budget;
	}
	
	public GraphNode getLocation() {
		// TODO
		return this.getLocation();
	}
	
	public String getLocationName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return this.name;
	}
	
	public void getSpycamBack(boolean pickupSpyCam){
		if (pickupSpyCam){
			// TODO
			// Increment positive or negative?
			spycams++;
		}
	}

	public int getSpycams() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean move(String next) {
		// TODO
		return false;
	}
	
	public boolean pickupSpycam(GraphNode nodeFromName) {
		// TODO Auto-generated method stub
		return false;
	}

	public void printSpyCamLocations() {
		// TODO Auto-generated method stub
		
	}
}
