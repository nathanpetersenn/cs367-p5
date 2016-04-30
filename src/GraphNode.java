import java.util.*;

public class GraphNode implements Comparable<GraphNode> {

	private String name;
	// TODO - Use NOT_NEIGHBOR for Dijkstra's
	//private static int NOT_NEIGHBOR;
	private List<Neighbor> neighbors;
	private boolean hasSpycam;
	
	/**
	 * 
	 * @param newName
	 */
	public GraphNode(String newName) {
		if (newName == null) throw new IllegalArgumentException();
		name = newName;
		neighbors = new ArrayList<Neighbor>();
		//NOT_NEIGHBOR = 0;
		hasSpycam = false;
	}

	/**
	 * 
	 * @param neighbor
	 * @param cost
	 */
	public void addNeighbor(GraphNode neighbor, int cost){
		if (neighbor == null || cost < 0) throw new IllegalArgumentException();
		Neighbor n = new Neighbor(cost, neighbor);
		neighbors.add(n);
		Collections.sort(neighbors);
	}

	/**
	 * 
	 * @param otherNode
	 * @return
	 */
	public int compareTo(GraphNode otherNode){
		if (otherNode == null) throw new IllegalArgumentException();
		int compare = this.getNodeName().compareTo(otherNode.getNodeName());
		if (compare > 0) return 1;
		if (compare < 0) return -1;
		return 0;
	}

	/**
	 * 
	 */
	public void displayCostToEachNeighbor(){
		for (Neighbor n : neighbors){
			System.out.println(n.getCost() + " " + n.getNeighborNode().getNodeName());
		}
	}

	/**
	 * 
	 * @param neighborName
	 * @return
	 */
	public int getCostTo(String neighborName) throws NotNeighborException {
		if (neighborName == null) throw new IllegalArgumentException();
		for (Neighbor n : neighbors){
			if (n.getNeighborNode().equals(neighborName)){
				return n.getCost();
			}
		}
		throw new NotNeighborException();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public GraphNode getNeighbor(String name) throws NotNeighborException {
		if (name == null) throw new IllegalArgumentException();
		
		Iterator<Neighbor> itr = neighbors.iterator();
		while (itr.hasNext()){
			Neighbor n = itr.next();
			if (n.getNeighborNode().getNodeName().equals(name)){
				return n.getNeighborNode();
			}
		}
		throw new NotNeighborException();
	}

	/**
	 * 
	 * @return
	 */
	public Iterator<String> getNeighborNames() {
		List<String> list = new ArrayList<String>();
		System.out.println("neighbors size is " + neighbors.size());
		// TODO
		for (Neighbor n : neighbors){
			list.add(n.getNeighborNode().getNodeName());
		}
		return list.iterator(); 
	}

	/**
	 * 
	 * @return
	 */
	public List<Neighbor> getNeighbors() {
		return neighbors;
	}

	/**
	 * 
	 * @return
	 */
	public String getNodeName(){
		return name;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getSpycam() {
		return hasSpycam;
	}

	/**
	 * 
	 * @param neighborName
	 * @return
	 */
	public boolean isNeighbor(String neighborName){
		Iterator<String> itr = getNeighborNames();
		while (itr.hasNext()){
			if (itr.next().equals(neighborName)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 */
	public void printNeighborNames(){
		displayCostToEachNeighbor();
	}

	/**
	 * 
	 * @param cam
	 */
	public void setSpycam(boolean cam){
		hasSpycam = cam;
		
	}

	/**
	 * 
	 */
	public String toString(){
		return name;
	}
}
