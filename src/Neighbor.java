
public class Neighbor implements Comparable<Neighbor>{

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
		
		int compare = neighborNode.getNodeName().compareTo(otherNode.getNeighborNode().getNodeName());
		if (compare == 0){
			if (cost > otherNode.getCost()) return 1;
			if (cost < otherNode.getCost()) return -1;
			return 0;
		}
		if (compare > 0) return 1;
		return -1;
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
