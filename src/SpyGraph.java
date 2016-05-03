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
		// TODO implement this method

		// Create a list for the visited nodes and a queue the nodes nodes
		List<Neighbor> visited = new ArrayList<Neighbor>();
		Queue<GraphNode> queue = new LinkedList<GraphNode>();

		// Add the start node to the queue
		queue.add(getNodeFromName(start));

		// While the queue isn't empty
		while (!queue.isEmpty()) {

			// Remove the first node from the queue
			GraphNode curr = queue.remove();

			// For of curr's neighbors
			for (Neighbor succ : curr.getNeighbors()) {

				boolean contains = false;

				// For each neighbor in visited
				for (Neighbor v : visited) {

					// If any of the nodes in visited equal the curr node,
					// set contains to true
					if (v.getNeighborNode().getNodeName().equals(succ.getNeighborNode().getNodeName())) {
						contains = true;
					}
				}
				// If we didn't find a match in visited, keep going
				if (contains) continue;

				// Add the succ node to the visited list
				visited.add(succ);

				// If succ equals the end node, return the visited list
				if (succ.getNeighborNode().getNodeName().equals(end)) return visited;

				// Add succ to the queue
				queue.add(succ.getNeighborNode());
			}
		}

		// never got to end... no path exists
		return new ArrayList<Neighbor>();
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
	public List<Neighbor> DFS2(String start, String end) {

		List<Neighbor> visited = new ArrayList<Neighbor>();

		DFS2(end, getNodeFromName(start), getNodeFromName(start).getNeighbors().get(0), visited);

		return visited;
	}


	private void DFS2(String end, GraphNode currNode, Neighbor currNeighbor, List<Neighbor> visited){

		visited.add(currNeighbor);
		if (currNeighbor.getNeighborNode().getNodeName().equals(end)) return;
		//if (currNode.getNodeName().equals(end)) return;

		for (Neighbor n : currNeighbor.getNeighborNode().getNeighbors()){
			boolean contains = false;
			for (Neighbor v : visited){
				if (v.getNeighborNode().getNodeName().equals(n.getNeighborNode().getNodeName()))
					contains = true;
			}

			if (!contains && !currNode.getNodeName().equals(end))
				DFS2(end, currNeighbor.getNeighborNode(), n, visited);
		}
	}





	public List<Neighbor> DFS(String start, String end) {

		List<Neighbor> visited = new ArrayList<Neighbor>();
		Stack<GraphNode> stack = new Stack<GraphNode>();


		stack.push(getNodeFromName(start));

		while (!stack.isEmpty()){

			GraphNode gn = stack.peek();

			for (Neighbor n : gn.getNeighbors()){

				

			}

		}


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
