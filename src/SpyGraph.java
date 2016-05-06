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
		List<GraphNode> visitedNodes = new ArrayList<GraphNode>();
		
		HashMap<GraphNode, Neighbor> prevEdgeOfNode = new HashMap<GraphNode, Neighbor>();
		HashMap<Neighbor, GraphNode> prevNodeOfEdge = new HashMap<Neighbor, GraphNode>();

		
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		
		visitedNodes.add(getNodeFromName(start));
		queue.add(getNodeFromName(start));
		
		while (!queue.isEmpty()) {
			GraphNode curr = queue.remove();
			
			for (Neighbor succ : curr.getNeighbors()) {
				if (alreadyVisited(succ.getNeighborNode(), visitedNodes)) continue;
				
				visitedNodes.add(succ.getNeighborNode());
				queue.add(succ.getNeighborNode());
				
				prevEdgeOfNode.put(succ.getNeighborNode(), succ);
				prevNodeOfEdge.put(succ, curr);
			}
		}
		
		List<Neighbor> ret = new ArrayList<Neighbor>();
		
		GraphNode endNode = getNodeFromName(end);
		Neighbor edgeToEnd = prevEdgeOfNode.get(endNode);
		GraphNode prevNodeToEdgeToEnd = prevNodeOfEdge.get(edgeToEnd);
		
		ret.add(edgeToEnd);
		
		while (!prevNodeToEdgeToEnd.getNodeName().equals(start)) {
			endNode = prevNodeToEdgeToEnd;
			edgeToEnd = prevEdgeOfNode.get(endNode);
			prevNodeToEdgeToEnd = prevNodeOfEdge.get(edgeToEnd);
			ret.add(0, edgeToEnd);
		}

		return ret;
	}

	private boolean alreadyVisited(GraphNode n, List<GraphNode> visitedNodes){
		boolean contains = false;

		for (GraphNode v : visitedNodes) {
			if (v.getNodeName().equals(
					n.getNodeName())) {
				contains = true;
			}
		}
		
		return contains;
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
		List<Neighbor> visitedNeighbors = new ArrayList<Neighbor>();
		List<GraphNode> visitedNodes = new ArrayList<GraphNode>();
		
		DFS(end, getNodeFromName(start), visitedNeighbors, visitedNodes);
		return visitedNeighbors;
	}


	private void DFS(String end, GraphNode curr, List<Neighbor> visitedNeighbors, List<GraphNode> visitedNodes) {
		visitedNodes.add(curr);
		
		for (Neighbor n : curr.getNeighbors()){
			if (reachedEnd(end, visitedNodes)) return;
			
			if (!alreadyVisited(n.getNeighborNode(), visitedNodes)) {
				visitedNeighbors.add(n);				
				DFS(end, n.getNeighborNode(), visitedNeighbors, visitedNodes);
			}
		}
		
		if (allNeighborsVisited(curr, visitedNodes) && !reachedEnd(end, visitedNodes)) {
			visitedNeighbors.remove(visitedNeighbors.size() - 1); // pop()
		}
	}
	
	private boolean reachedEnd(String end, List<GraphNode> visitedNodes)  {
		for (GraphNode n: visitedNodes) {
			if (n.getNodeName().equals(end)) return true;
		}
		return false;
	}
	
	private boolean allNeighborsVisited(GraphNode c, List<GraphNode> visitedNodes) {			
		for (Neighbor n : c.getNeighbors()) {
			boolean foundIt = false;
			for (GraphNode gn : visitedNodes) {
				if (n.getNeighborNode().getNodeName().equals(gn.getNodeName())) {
					foundIt = true;
				}
			}
			if (!foundIt) {
				// unvisited
				return false;
			}
		}
		
		return true;
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