
public class Neighbor {

	int cost;
	GraphNode neighborNode;
	
	public Neighbor(int cost, GraphNode neighbor){
		this.cost = cost;
		neighborNode = neighbor;
	}
	
	public int compareTo(Neighbor otherNode){
		// TODO
		return 0;
	}
	
	public int getCost() {
		// TODO
		return cost;
	}
	
	public GraphNode getNeighborNode() {
		// TODO
		return neighborNode;
	}

	public String toString(){
		// TODO
		return "";
	}
}
