import java.util.Iterator;
import java.util.List;

public class GraphNode {

	private String name;
	private static int NOT_NEIGHBOR;
	List<Neighbor> neighbors;
	
	public GraphNode(String newName) {
		// TODO Auto-generated constructor stub
		name = newName;
	}
	
	public void addNeighbor(GraphNode neighbor, int cost){
		// TODO
		Neighbor n = new Neighbor(cost, neighbor);
		neighbors.add(n);
	}
	
	public int compareTo(GraphNode otherNode){
		// TODO
		//if (this.getNodeName() > otherNode.getNodeName());
		return 0;
	}
	
	public void displayCostToEachNeighbor(){
		// TODO
		for (int i=0; i<neighbors.size(); i++){
			System.out.println(neighbors.get(i).getCost());
		}
	}
	
	public int getCostTo(String neighborName){
		// TODO
		for (int i=0; i<neighbors.size(); i++){
			if (neighbors.get(i).getNeighborNode().equals(neighborName)){
				return neighbors.get(i).getCost();
			}
		}
		return 0;
	}
	
	public GraphNode getNeighbor(String name){
		// TODO
		return this.getNeighbor(name);
	}
	
	public Iterator<String> getNeighborNames() {
		// TODO Auto-generated method stub
		
		//return new Iterator<String>(this.getNeighbors());
		return null;
	}
	
	public List<Neighbor> getNeighbors() {
		// TODO Auto-generated method stub
		return neighbors;
	}
	
	public String getNodeName(){
		return name;
	}
	
	public boolean getSpycam() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isNeighbor(String neighborName){
		return false;
	}
	
	public void printNeighborNames(){
		// TODO
	}
	
	public void setSpycam(boolean cam){
		// TODO
	}
	
	public String toString(){
		// TODO
		return "";
	}
}
