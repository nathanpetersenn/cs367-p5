

public class Player {
		
	private String name;
	private int budget;
	private int spycams;
	private GraphNode node;
	
	/**
	 * 
	 * @param name
	 * @param budget
	 * @param spycams
	 * @param startNode
	 */
	public Player(String name, int budget, int spycams, GraphNode startNode){
		this.name = name;
		this.budget = budget;
		this.spycams = spycams;
		node = startNode;
	}

	/**
	 * 
	 * @param check
	 */
	public void decreaseBudget(int check) {
		budget = budget - check;
	}

	/**
	 * 
	 * @return
	 */
	public boolean dropSpycam() {
		// TODO
		if (spycams == 0){
			System.out.println("Not enough spycams");
			return false;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getBudget() {
		return budget;
	}
	
	/**
	 * 
	 * @return
	 */
	public GraphNode getLocation() {
		// TODO
		return this.getLocation();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLocationName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @param pickupSpyCam
	 */
	public void getSpycamBack(boolean pickupSpyCam){
		if (pickupSpyCam){
			// TODO
			// Increment positive or negative?
			spycams++;
		}
	}

	/**
	 * 
	 * @return
	 */
	public int getSpycams() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 
	 * @param next
	 * @return
	 */
	public boolean move(String next) {
		// TODO
		return false;
	}
	
	/**
	 * 
	 * @param nodeFromName
	 * @return
	 */
	public boolean pickupSpycam(GraphNode nodeFromName) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	public void printSpyCamLocations() {
		// TODO Auto-generated method stub
		
	}
}
