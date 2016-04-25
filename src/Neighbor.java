
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
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCost() {
		// TODO
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
		// TODO
		return "";
	}
}
