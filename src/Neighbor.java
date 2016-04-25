
public class Neighbor {

	int cost;
	GraphNode neighborNode;
	
	
	
	/**
	 * 
	 * @param cost
	 * @param neighbor
	 */
	public Neighbor(int cost, GraphNode neighbor){
		this.cost = cost;
		neighborNode = neighbor;
	}
	
	/**
	 * 
	 * @param otherNode
	 * @return
	 */
	public int compareTo(Neighbor otherNode){
		// TODO
		int compare = otherNode.toString().compareTo(this.toString());
		if (compare > 0) return 1;
		if (compare < 0) return -1;
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * 
	 * @return
	 */
	public GraphNode getNeighborNode() {
		// TODO
		return neighborNode;
	}

	/**
	 * @return 
	 * 
	 */
	public String toString(){
		return "--" + cost + "--> " + neighborNode.getNodeName();
	}
}
