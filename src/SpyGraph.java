import java.util.*;
/**
 * Stores all vertexes as a list of GraphNodes.  Provides necessary graph operations as
 * need by the SpyGame class.
 * 
 * @author strominger
 *
 */
public class SpyGraph implements Iterable<GraphNode> {

	/** DO NOT EDIT -- USE THIS LIST TO STORE ALL GRAPHNODES */
	private List<GraphNode> vlist;


	/**
	 * Initializes an empty list of GraphNode objects
	 */
	public SpyGraph(){
		vlist = new ArrayList<GraphNode>();
	}

	/**
	 * Add a vertex with this label to the list of vertexes.
	 * No duplicate vertex names are allowed.
	 * @param name The name of the new GraphNode to create and add to the list.
	 */
	public void addGraphNode(String name){
		if (vlist.contains(name)) throw new IllegalArgumentException();
		vlist.add(new GraphNode(name));
		Collections.sort(vlist);
	}

	/**
	 * Adds v2 as a neighbor of v1 and adds v1 as a neighbor of v2.
	 * Also sets the cost for each neighbor pair.
	 *   
	 * @param v1name The name of the first vertex of this edge
	 * @param v2name The name of second vertex of this edge
	 * @param cost The cost of traveling to this edge
	 * @throws IllegalArgumentException if the names are the same
	 */
	public void addEdge(String v1name, String v2name, int cost) throws IllegalArgumentException{
		if (v1name.equals(v2name)) throw new IllegalArgumentException();    	
		getNodeFromName(v1name).addNeighbor(getNodeFromName(v2name), cost);
		getNodeFromName(v2name).addNeighbor(getNodeFromName(v1name), cost);
	}

	/**
	 * Return an iterator through all nodes in the SpyGraph
	 * @return iterator through all nodes in alphabetical order.
	 */
	public Iterator<GraphNode> iterator() {
		return vlist.iterator();
	}

	/**
	 * Return Breadth First Search list of nodes on path 
	 * from one Node to another.
	 * @param start First node in BFS traversal
	 * @param end Last node (match node) in BFS traversal
	 * @return The BFS traversal from start to end node.
	 */
	public List<Neighbor> BFS(String start, String end) {
		// Create a list for the visited nodes and a queue the nodes nodes
		List<Neighbor> visited = new ArrayList<Neighbor>();
		Queue<GraphNode> queue = new LinkedList<GraphNode>();

		// Add the start node to the queue
		queue.add(getNodeFromName(start));

		visited.add(new Neighbor(0, getNodeFromName(start)));
		
		// While the queue isn't empty
		while (!queue.isEmpty()) {

			// Remove the first node from the queue
			GraphNode curr = queue.remove();

			List<Neighbor> nList = new ArrayList<Neighbor>(curr.getNeighbors());


			//sortByCost(nList);
			//Collections.sort(nList, new CostComparator());

			// For of curr's neighbors
			for (Neighbor succ : nList) {

				
				// If we didn't find a match in alreadyVisited, keep going
				if (alreadyVisited(succ, visited)) continue;

				// Add the succ node to the visited list
				visited.add(succ);

				// If succ equals the end node, return the visited list
				if (succ.getNeighborNode().getNodeName().equals(end)){
					visited.remove(0);
					return visited;
				}

				// Add succ to the queue
				queue.add(succ.getNeighborNode());
			}
		}

		// never got to end... no path exists
		visited.remove(0);
		return visited;
		//return new ArrayList<Neighbor>();
	}

	private boolean alreadyVisited(Neighbor n, List<Neighbor> visited){
		boolean contains = false;

		// For each neighbor in visited
		for (Neighbor v : visited) {

			// If any of the nodes in visited equal the curr node,
			// set contains to true
			if (v.getNeighborNode().getNodeName().equals(n.getNeighborNode().getNodeName())) {
				contains = true;
			}
		}
		return contains;
	}
	
	private void sortByCost(List<Neighbor> nList) {
		for (int i = 1; i < nList.size(); i++){
			Neighbor temp = nList.get(i);

			int j;
			for (j = i-1; j >= 0 && nList.get(j).getCost() > temp.getCost(); j--){
				Neighbor jayPlusOne = nList.get(j+1);
				Neighbor jay = nList.get(j);
				nList.remove(j);
				nList.add(j, jayPlusOne);
				nList.remove(j+1);
				nList.add(j+1, jay);
			}
			nList.remove(j+1);
			nList.add(j+1, temp);
		}
	}

	/**
	 * @param name Name corresponding to node to be returned
	 * @return GraphNode associated with name, null if no such node exists
	 */
	public GraphNode getNodeFromName(String name){
		for (GraphNode n : vlist) {
			if (n.getNodeName().equals(name)) return n;
		}
		return null;
	}

	/**
	 * Return Depth First Search list of nodes on path 
	 * from one Node to another.
	 * @param start First node in DFS traversal
	 * @param end Last node (match node) in DFS traversal
	 * @return The DFS traversal from start to end node.
	 */
	public List<Neighbor> DFS(String start, String end) {

		List<Neighbor> visited = new ArrayList<Neighbor>();

		DFS(end, getNodeFromName(start), getNodeFromName(start).getNeighbors().get(0), visited);

		List<Neighbor> ret = new ArrayList<Neighbor>();
		int endIndex = 0;
		for (Neighbor n : visited){
			if (n.getNeighborNode().getNodeName().equals(end)){
				break;
			}
			endIndex++;
		}
		while (endIndex >= 0){
			Neighbor v = visited.get(endIndex--);
			if (v.getNeighborNode().getNodeName().equals(start)) break;
			ret.add(0, v);
		}
		return ret;
	}


	private void DFS(String end, GraphNode currNode, Neighbor currNeighbor, List<Neighbor> visited){

		visited.add(currNeighbor);
		if (currNeighbor.getNeighborNode().getNodeName().equals(end)) return;
		//if (currNode.getNodeName().equals(end)) return;

		for (Neighbor n : currNeighbor.getNeighborNode().getNeighbors()){
			boolean contains = false;
			for (Neighbor v : visited){
				if (v.getNeighborNode().getNodeName().equals(n.getNeighborNode().getNodeName()))
					contains = true;
			}

			if (!contains)// && !currNode.getNodeName().equals(end))
				DFS(end, currNeighbor.getNeighborNode(), n, visited);
		}
	}

	//	public List<Neighbor> DFS(String start, String end) {
	//		// TODO - fix this
	//		
	//		// Creates a list to hold all visited neighbors and
	//		// a stack to put GraphNodes in to be taken off
	//		List<Neighbor> visited = new ArrayList<Neighbor>();
	//		Stack<GraphNode> stack = new Stack<GraphNode>();
	//		
	//		//List<Neighbor> ret = new ArrayList<Neighbor>();
	//		
	//		// Add the start node to the stack
	//		stack.push(getNodeFromName(start));
	//		//visited.add(new Neighbor(0, getNodeFromName(start)));
	//		
	//		// While there's still stuff in the stack
	//		while (!stack.isEmpty()){
	//
	//			// node is the GraphNode on the top of the stack
	//			GraphNode node = stack.peek();
	//			
	//			// nextNeighbor is the next unvisited neighbor of node
	//			Neighbor nextNeighbor = nextNeighbor(node, visited, start);
	//			
	//			// If there was a nextNeighbor
	//			if (nextNeighbor != null) {
	//				// Add nextNeighbor to the visited list
	//				visited.add(nextNeighbor);
	//				
	//				// Stop if we get to end
	//				if (nextNeighbor.getNeighborNode().getNodeName().equals(end)) {
	//					return visited;
	//				}
	//				// Push the nextNeighbor onto the stack
	//				stack.push(nextNeighbor.getNeighborNode());
	//				
	//			// If there wasn't a nextNeighbor, pop node off the stack
	//			} else {
	//				stack.pop();
	//			}
	//			
	//		}
	//		
	//		return new ArrayList<Neighbor>();
	//	}


	private Neighbor nextNeighbor(GraphNode node, List<Neighbor> visited, String start) {
		//		List<Neighbor> neighborsCopy = new ArrayList<Neighbor>(node.getNeighbors());
		//		Collections.sort(neighborsCopy, c);

		for (Neighbor adj : node.getNeighbors()) {
			boolean alreadyVisited = false;

			for (Neighbor v: visited) {
				if (v.getNeighborNode().getNodeName().equals(adj.getNeighborNode().getNodeName())) {
					alreadyVisited = true;
					break;
				}
			}
			// Shouldn't this be:
			// if (contains) return adj;
			// because if it DOES contain it, we want to return it
			if (!alreadyVisited && !adj.getNeighborNode().getNodeName().equals(start)){
				return adj;
			}
		}
		// If NO NODE was found, don't we then return null -- nothing was found
		return null;
	}




	/**
	 * OPTIONAL: Students are not required to implement Dijkstra's ALGORITHM
	 *
	 * Return Dijkstra's shortest path list of nodes on path 
	 * from one Node to another.
	 * @param start First node in path
	 * @param end Last node (match node) in path
	 * @return The shortest cost path from start to end node.
	 */
	public List<Neighbor> Dijkstra(String start, String end){

		// TODO: implement Dijkstra's shortest path algorithm
		// may need and create a companion method

		return new ArrayList<Neighbor>();
	}


	/**
	 * DO NOT EDIT THIS METHOD 
	 * @return a random node from this graph
	 */
	public GraphNode getRandomNode() {
		if (vlist.size() <= 0 ) {
			System.out.println("Must have nodes in the graph before randomly choosing one.");
			return null;
		}
		int randomNodeIndex = Game.RNG.nextInt(vlist.size());
		return vlist.get(randomNodeIndex);
	}
}
class CostComparator implements Comparator<Neighbor> {
    @Override
    public int compare(Neighbor a, Neighbor b) {
        return a.getCost() - b.getCost();
    }
}