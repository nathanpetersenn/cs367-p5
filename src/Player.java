import java.util.Iterator;

public class Player {
	
	private String name;
	private int budget;
	private int spycams;
	private GraphNode node;
	private static SpyGraph spyGraph;
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
		spyGraph = new SpyGraph();
	}

	/**
	 * 
	 * @param dec
	 */
	public void decreaseBudget(int dec) {
		if (dec < 0 || budget - dec < 0){
			throw new IllegalArgumentException();
		}
		budget = budget - dec;
	}

	/**
	 * 
	 * @return
	 */
	public boolean dropSpycam() {
		// TODO
		if (spycams <= 0){
			System.out.println("Not enough spycams");
			return false;
		}
		// TODO - actually do this
		spycams--;
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
		return node;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLocationName() {
		return node.getNodeName();
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
			spycams++;
		}
		// TODO
	}

	/**
	 * 
	 * @return
	 */
	public int getSpycams() {
		return spycams;
	}
	
	/**
	 * 
	 * @param next
	 * @return
	 */
	public boolean move(String name) {
		// TODO

//		Iterator<GraphNode> itr = vlist.iterator();

		
		
//		while (itr.hasNext()){
//			GraphNode gn = itr.next();
//			if (gn.isNeighbor(name)){
//				budget -= node.getCostTo(gn);
//				node = gn;
//				return true;
//			}
//		}
		
		
		return false;
	}
	
	/**
	 * 
	 * @param nodeFromName
	 * @return
	 */
	public boolean pickupSpycam(GraphNode nodeFromName) {
		// TODO 
		if (node.getSpycam()){
			// Has a spycam
			
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	public void printSpyCamLocations() {
		// TODO
		System.out.println("");
	}
}
