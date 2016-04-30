import java.util.*;

public class Player {

	private String name;
	private int budget;
	private int spycams;
	private GraphNode node;
	private List<String> spycamNames;

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
		spycamNames = new ArrayList<String>();
	}

	/**
	 * 
	 * @param dec
	 */
	public void decreaseBudget(int dec) {
		if (dec < 0 || budget - dec < 0) throw new IllegalArgumentException();
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
		if (!node.getSpycam()) {
			node.setSpycam(true);
			spycamNames.add(node.getNodeName());
			spycams--;
			return true;
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
		return name;
	}

	/**
	 * 
	 * @param pickupSpyCam
	 */
	public void getSpycamBack(boolean pickupSpyCam){
		if (pickupSpyCam){
			spycams++;
			node.setSpycam(false);
			spycamNames.remove(node.getNodeName());

		}
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
		System.out.println("entered move");
		try {
			GraphNode n = node.getNeighbor(name);
			int cost = node.getCostTo(n.getNodeName());
			if (cost > budget){
				System.out.println("Not enough money cost is " + cost +
						" budget is " + budget);

				return false;
			}
			if (cost > 1) {
				decreaseBudget(cost);
			}
			node = n;
			System.out.println("Moved to " + n.getNodeName());
			return true;
		}
		catch (NotNeighborException e){
			return false;
		}
	}

	/**
	 * 
	 * @param nodeFromName
	 * @return
	 */
	public boolean pickupSpycam(GraphNode nodeFromName) {
		// TODO
		if (nodeFromName.getSpycam()){
			// Has a spycam
			nodeFromName.setSpycam(false);
			spycamNames.remove(nodeFromName.getNodeName());
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	public void printSpyCamLocations() {
		// TODO
		for (String i : spycamNames){
			System.out.println(i);
		}
	}
}
