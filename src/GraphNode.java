import java.util.*;

public class GraphNode {

	private String name;
	// TODO - is NOT_NEIGHBOR final?
	private static int NOT_NEIGHBOR;
	private List<Neighbor> neighbors;

	/**
	 * 
	 * @param newName
	 */
	public GraphNode(String newName) {
		// TODO Auto-generated constructor stub
		name = newName;
		neighbors = new ArrayList<Neighbor>();
		//NOT_NEIGHBOR = 0;
	}

	/**
	 * 
	 * @param neighbor
	 * @param cost
	 */
	public void addNeighbor(GraphNode neighbor, int cost){
		// TODO
		Neighbor n = new Neighbor(cost, neighbor);
		neighbors.add(n);
		neighbors.sort(null);
	}
	
	/**
	 * 
	 * @param otherNode
	 * @return
	 */
	public int compareTo(GraphNode otherNode){
		// TODO
		int compare = this.getNodeName().compareTo(otherNode.getNodeName());
		if (compare > 0) return 1;
		if (compare < 0) return -1;
		return 0;
	}
	
	/**
	 * 
	 */
	public void displayCostToEachNeighbor(){for (Neighbor n : neighbors) System.out.println(n.getNeighborNode().getNodeName() + "; " + n.getCost());}
	
	/**
	 * 
	 * @param neighborName
	 * @return
	 */
	public int getCostTo(String neighborName){
		// TODO
		for (int i=0; i<neighbors.size(); i++){
			if (neighbors.get(i).getNeighborNode().equals(neighborName)){
				return neighbors.get(i).getCost();
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public GraphNode getNeighbor(String name){
		// TODO - fix this
		return this.getNeighbor(name);
	}
	
	/**
	 * 
	 * @return
	 */
	public Iterator<String> getNeighborNames() {
		// TODO Auto-generated method stub
		
		//return new Iterator<String>(this.getNeighbors());
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Neighbor> getNeighbors() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 
	 * @param neighborName
	 * @return
	 */
	public boolean isNeighbor(String neighborName){
		return false;
	}
	
	/**
	 * 
	 */
	public void printNeighborNames(){
		// TODO
	}
	
	/**
	 * 
	 * @param cam
	 */
	public void setSpycam(boolean cam){
		// TODO
	}
	
	/**
	 * 
	 */
	public String toString(){
		// TODO
		return "";
	}
}
