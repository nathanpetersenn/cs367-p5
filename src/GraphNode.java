import java.util.Iterator;
import java.util.List;

public class GraphNode {

	private String name;
	private static int NOT_NEIGHBOR;
	
	
	public GraphNode(String newName) {
		// TODO Auto-generated constructor stub
		name = newName;
	}
	
	public void addNeighbor(GraphNode neighbor, int cost){
		// TODO
	}
	
	public int compareTo(GraphNode otherNode){
		// TODO
		return 0;
	}
	
	public void displayCostToEachNeighbor(){
		// TODO
	}
	
	public int getCostTo(String neighborName){
		// TODO
		return 0;
	}
	
	public GraphNode getNeighbor(String name){
		// TODO
		return null;
	}
	
	public Iterator<String> getNeighborNames() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	public List<Neighbor> getNeighbors() {
		// TODO Auto-generated method stub
		return null;
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
