import java.util.Iterator;
import java.util.List;

public class GraphNode {

	private String name;
	private static int NOT_NEIGHBOR;
	List<Neighbor> neighbors;
	
	/**
	 * 
	 * @param newName
	 */
	public GraphNode(String newName) {
		// TODO Auto-generated constructor stub
		name = newName;
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
	}
	
	/**
	 * 
	 * @param otherNode
	 * @return
	 */
	public int compareTo(GraphNode otherNode){
		// TODO
		//if (this.getNodeName() > otherNode.getNodeName());
		return 0;
	}
	
	/**
	 * 
	 */
	public void displayCostToEachNeighbor(){
		// TODO
		for (int i=0; i<neighbors.size(); i++){
			System.out.println(neighbors.get(i).getCost());
		}
	}
	
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
		// TODO
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
