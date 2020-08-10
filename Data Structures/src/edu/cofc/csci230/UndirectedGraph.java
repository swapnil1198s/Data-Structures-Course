package edu.cofc.csci230;

import java.util.EmptyStackException;
import java.util.Arrays;

import java.util.NoSuchElementException;

/**
 * Undirected and unweighted graph data structure.
 * 
 * 
 * CSCI 230: Data Structures and Algorithms 
 * 
 * Fall 2018
 *
 * @param <AnyType>
 */
public class UndirectedGraph<AnyType extends Comparable<AnyType>> {
	
	/**
	 * Adjacency list data structure. Used in conjunction with
	 * adjacent_vertices in each Vertex class.
	 * 
	 * Note: Each vertex in the adjacency list must be unique, 
	 * i.e. the list cannot contain two vertices that have the 
	 * same value.
	 */
	private List<Vertex<AnyType>> adjacency_list = null;
	
	/**
	 * 
	 * Constructor
	 * 
	 */
	public UndirectedGraph() {
		
		adjacency_list = new ArrayList<Vertex<AnyType>>();
		
	} // end constructor
	
	
	/**
	 * 
	 * See supplemental course textbook for definition
	 * of connected graph (page 31)
	 * 
	 * This method returns TRUE if the graph is connected, 
	 * or FALSE if it is not.
	 * 
	 * Furthermore, if the adjacency list does not have any 
	 * vertices, i.e. the graph is empty, the method will 
	 * return false.
	 * 
	 * -----------------
	 * Note:
	 * -----------------
	 *
	 * You may add additional methods or private instance 
	 * variables to this class to support your solution (i.e. if it 
	 * is recursive). However, you MUST use the provided adjacency list
	 * and the vertex class, and you MAY NOT create an additional class.
	 * If in doubt about these restrictions -> you must ask!
	 * 
	 * @return
	 */
	public Boolean isConnected() {
		
		// ----------------------------
		// Add your code here
		// ----------------------------
		if(adjacency_list.isEmpty())
			return false;
		else {
			String s = depthFirstSearch(adjacency_list.get(0).getValue());
			int i = s.indexOf("-1");
			
			if(i >= 0) {
				return false;
			}
			else {
				return true;
			}
		}
		
		
		
		
		
		
		 // this is only here for the code to compile, you must change!
		
		
	} // end isConnected() method
	

	/**
	 * Create a formated string that lists all the graph cycles 
	 * 
	 * For example, if the adjacency list is:
	 * 
	 * Vertex (1): [ 2, 3, 4 ]
	 * Vertex (2): [ 1, 4 ]
	 * Vertex (3): [ 1, 4 ]
	 * Vertex (4): [ 1, 2, 3 ]
	 * 
	 * then this method would return the string
	 * 
	 * cycle (1): [ 1, 2, 4 ]
	 * cycle (2): [ 1, 3, 4 ]
	 * cycle (3): [ 1, 2, 3, 4 ]
	 * 
	 * As shown above, the format of the string MUST be:
	 * 
	 * cycle( <cycle_number> ): [ <comma delimited sequence of vertex numbers> ]\n
	 * 
	 * 
	 * -----------------
	 * Notes:
	 * -----------------
	 * 1) Your cycle results must be formated in ascending
	 * vertex value order, e.g. below would NOT BE correct
	 * cycle (1): [ 2, 1, 4 ]
	 * 
	 * 2) No duplicate cycles are included, e.g. this result 
	 * is NOT correct
	 * cycle (1): [ 1, 2, 4 ]
	 * cycle (2): [ 1, 2, 4 ]
	 * 
	 * 3) The order of the cycles must be sorted (ascending 
	 * order) by the number of vertices that form the cycle. 
	 * i.e., cycles formed by three vertices first, then 
	 * cycles formed by four vertices second, etc. For example,
	 * the result below is NOT correct. 
	 * cycle (1): [ 1, 2, 4 ]
	 * cycle (2): [ 1, 2, 3, 4 ]
	 * cycle (3): [ 1, 3, 4 ]
	 * Lastly, cycles that have the same number of vertices 
	 * are ordered by the sum of the vertex values, with the 
	 * minimum vertex sum appearing first. For example, the
	 * result shown below is NOT correct because 1+3+4 > 1+2+4
	 * cycle (1): [ 1, 3, 4 ]
	 * cycle (2): [ 1, 2, 4 ]
	 * cycle (3): [ 1, 2, 3, 4 ]
	 *
	 * 4) You may add additional methods or private instance 
	 * variables to this class to support your solution (i.e. if it 
	 * is recursive). However, you MUST use the provided adjacency list
	 * and the vertex class, and you MAY NOT create an additional class.
	 * 
	 * 5) If there are no vertices in the adjacency list OR the graph
	 * is not connected the method would simply return the following 
	 * string values exactly (including case):
	 *  - no vertices in the adjacency list (i.e. graph is 
	 *    empty) then return the string "empty graph".
	 *  - the graph is not connected then return the string 
	 *    "not connected".
	 * 
	 * 
	 * @return
	 */
	public String findAllCycles() {
		
		// ----------------------------
		// Add your code here
		// ----------------------------
		String cycles = "";
		if(adjacency_list.isEmpty()) {
			return "empty graph";
		}
		else if(!isConnected()){
			return "not connected";
		}
		else {
			for(int i = 0; i<adjacency_list.size(); i++) {
				cycles += findAllCycles(adjacency_list.get(i));
			}
			cycles = convert(cycles);
		}
		
		 return cycles;// this is only here for the code to compile, you must change!
		
	} // end findAllCycles()
	private String findAllCycles(Vertex<AnyType> v) {
		
		String a = v.getValue() + ",";
		for(int i = 0; i<v.numberOfAdjacentVertices();i++) {
			Vertex<AnyType> u = v.getAdjacentVertex(i);
			a += u.getValue() + ",";
			int count = 0;
			for(int j = 0; j<u.numberOfAdjacentVertices();j++) {
				if(v.hasAdjacentVertex(u.getAdjacentVertex(j))) {
					a += u.getAdjacentVertex(j) + ",";
				}
			}
			a += "\n" + v.getValue() + ",";
		}
		return a;
		

	}


	private String convert(String a) {
		// TODO Auto-generated method stub
		String[] b = a.split(",\n");
		String cycles="";
		int count = 0;
		for(int i = 0; i<b.length; i++) {
			String[] c = b[i].split(",");
			if(c.length<3) {
				b[i] = null;
			}
			else {
				count++;
				cycles += "cycle(" + count + "): [" + b[i] + "]\n";
			}
		}
		
		return cycles;
	}


	/**
	 * Add an edge between two vertices
	 * 
	 * @param vertex_value_A
	 * @param vertex_value_B
	 * @return
	 * @throws VertexException
	 */
	public Boolean addEdge( AnyType vertex_value_A, AnyType vertex_value_B ) throws VertexException {
		
		// ------------------------------------
		// Basic steps:
		// ------------------------------------
		// 1) For Vertex A and B, check to see if the vertex exits in the 
		//    adjacency_list. If not, then add new vertex (with given value) 
		//    to the adjacency_list.
		// 2) In the Vertex class, if Vertex B is in Vertex A's 
		//    adjacent_vertices and vice versa (i.e. an edge exists). If an
		//    edge already exists, then return false, otherwise goto step 3.
		// 3) Add Vertex B to Vertex A's adjacent_vertices and vice versa.
		//    Lastly, return true indicating the edge was successfully added.
		
		
		Vertex<AnyType> vertexA = new Vertex<AnyType>( vertex_value_A );
		Vertex<AnyType> vertexB = new Vertex<AnyType>( vertex_value_B );
		
		int vertexA_exists = -1;
		int vertexB_exists = -1;
		
		// Step 1
		for ( int i=0; i<adjacency_list.size(); i++ ) {
			
			if ( adjacency_list.get(i).compareTo( vertexA ) == 0 ) {
				vertexA_exists = i;
			}
			
			if ( adjacency_list.get(i).compareTo( vertexB ) == 0 ) {
				vertexB_exists = i;
			}
			
		}
		
		if ( vertexA_exists == -1 )
			adjacency_list.add( vertexA );
		else 
			vertexA = adjacency_list.get( vertexA_exists );
		
		if ( vertexB_exists == -1 )
			adjacency_list.add( vertexB );
		else
			vertexB = adjacency_list.get( vertexB_exists );
			
		
		// Step 2
		
		if ( vertexA.hasAdjacentVertex(vertexB) && vertexB.hasAdjacentVertex(vertexA) ) 
			return false;
		else {
			
			vertexA.addAdjacentVertex( vertexB );
			vertexB.addAdjacentVertex( vertexA );
			
		}
			
		return true;
	
	} // end addEdge() method
	
	
	/**
	 * 
	 * Remove the edge that connects two vertices
	 * 
	 * 
	 * @param vertex_value_A
	 * @param vertex_value_B
	 * @return
	 * @throws VertexException
	 */
	public Boolean removeEdge( AnyType vertex_value_A, AnyType vertex_value_B ) throws VertexException {
		
		// ------------------------------------
		// Basic steps:
		// ------------------------------------
		// 1) For each vertex, see if the vertex exists in 
		//    the adjacency_list. If not, return false that indicates the 
		//    edge does not exist. Otherwise goto step 2.
		// 2) In Vertex class, see if Vertex B is in Vertex A's
		//    adjacent_vertices and vice versa (i.e. an edge exists). 
		//    If the edge does not exist return false, otherwise goto 
		//    step 3.
		// 3) In the Vertex class, remove Vertex B from Vertex A's 
		//    adjacent_vertices and vice versa, and then goto step 4. 
		//    Does not exist and return false, otherwise proceed to step 4.
		// 4) If number of adjacent vertices for Vertex A is zero, then 
		//    remove from the adjacency_list. Likewise, if the number of 
		//    adjacent vertices for Vertex B is zero, then remove from 
		//    adjacency_list. Lastly, return true indicating the edge was 
		//    successfully removed.
		
		Vertex<AnyType> vertexA = new Vertex<AnyType>( vertex_value_A );
		Vertex<AnyType> vertexB = new Vertex<AnyType>( vertex_value_B );
		
		int vertexA_exists = -1;
		int vertexB_exists = -1;
		
		// -----------------------------------------------------------------
		// Step 1
		for ( int i=0; i<adjacency_list.size(); i++ ) {
			
			if ( adjacency_list.get(i).compareTo( vertexA ) == 0 ) {
				vertexA_exists = i;
			}
			
			if ( adjacency_list.get(i).compareTo( vertexB ) == 0 ) {
				vertexB_exists = i;
			}
			
		}
		
		// -----------------------------------------------------------------
		// Step 2
		if ( vertexA_exists == 1 || vertexB_exists == -1 )
			return false;
	
		vertexA = adjacency_list.get( vertexA_exists );
		vertexB = adjacency_list.get( vertexB_exists );
			
		// -----------------------------------------------------------------
		// Step 3
		if ( !vertexA.hasAdjacentVertex(vertexB) || !vertexB.hasAdjacentVertex(vertexA) ) 
			return false;
		else {
			
			vertexA.removeAdjacentVertex( vertexB );
			vertexB.removeAdjacentVertex( vertexA );
			
		}
		
		// -----------------------------------------------------------------
		// Step 4
		if ( vertexA.numberOfAdjacentVertices() == 0 )
			adjacency_list.remove( vertexA_exists );
		
		if ( vertexB.numberOfAdjacentVertices() == 0 )
			adjacency_list.remove( vertexB_exists );
			
		return true;
		
	} // end removeEdge() method
	
	/**
	 * 
	 * Depth first search (DFS) using stack data structure.
	 * Specifically, the ConstantTimeStack class.
	 * 
	 * Return a String that shows when each vertex was 
	 * visited during the DFS. String format: 
	 * <Vertex Value>:<Visited Count>\n
	 * 
	 * Notes: 
	 *  (1) Mark each vertex as not visited before the
	 *      the search begins.
	 *  (2) If the start_vertex value does not exist in the 
	 *      undirected graph throw a new VertexException.
	 *  (3) Vertices are pushed onto the Stack in the same
	 *      order they were added to the adjacent_vertices 
	 * 
	 * @param start_vertex
	 * @return
	 * @throws VertexException
	 */
	public String depthFirstSearch( AnyType start_vertex ) throws VertexException {
		
		StringBuffer buffer = new StringBuffer();
		
		Vertex<AnyType> startVertex = new Vertex<AnyType>( start_vertex );
		
		int vertex_exists = -1;
		
		for ( int i=0; i<adjacency_list.size(); i++ ) {
			
			if ( adjacency_list.get(i).compareTo( startVertex ) == 0 ) {
				vertex_exists = i;
			}
			
		}
		
		if ( vertex_exists == -1 )
			throw new VertexException( String.format("Vertex %s does not exist!", startVertex ) );
		
		for ( int i=0; i<adjacency_list.size(); i++ ) {
			
			adjacency_list.get(i).setVisited( Vertex.NOT_VISITED );
			
		}
		
		int count = 0;
		
		startVertex = adjacency_list.get( vertex_exists );
		
		Stack<Vertex<AnyType>> stack = new ConstantTimeStack<Vertex<AnyType>>();
		
		stack.push( startVertex );
		
		try {
			
			while ( true ) {
				
				Vertex<AnyType> current_vertex = stack.peek();
				
				if ( !current_vertex.hasBeenVisited() ) {
					
					current_vertex.setVisited( ++count );
					
					for ( int i=0; i<current_vertex.numberOfAdjacentVertices(); i++ ) {
						
						stack.push( current_vertex.getAdjacentVertex( i ) );
						
					}
				
				} else
					stack.pop();
				
			}
			
		} catch( EmptyStackException emptyStack ) {
			
			for ( int i=0; i<adjacency_list.size(); i++ ) {
				
				buffer.append( String.format("%s:%d\n", adjacency_list.get(i),
						adjacency_list.get(i).getVisited() ) );
				
			}
			
		}
		
		return buffer.toString();
		
	} // end depthFirstSearch() method
	
	/**
	 * 
	 * Breadth first search (BFS) using queue data structure.
	 * Specifically, the ConstantTimeQueue class
	 * 
	 * Return a String that shows when each vertex was 
	 * visited during the BFS. String format: 
	 * <Vertex Value>:<Visited Count>\n 
	 * 
	 * Notes: 
	 *  (1) Mark each vertex as not visited before the
	 *      search begins.
	 *  (2) If the start_vertex value does not exist throw a
	 *      new VertexException.
	 *  (4) Vertices are added to the Queue in the same
	 *      order they were added to the adjacent_vertices 
	 * 
	 * @param start_vertex
	 * @return
	 * @throws VertexException
	 */
	public String breadthFirstSearch( AnyType start_vertex )  throws VertexException {
		
		StringBuffer buffer = new StringBuffer();
		
		Vertex<AnyType> startVertex = new Vertex<AnyType>( start_vertex );
		
		int vertex_exists = -1;
		
		for ( int i=0; i<adjacency_list.size(); i++ ) {
			
			if ( adjacency_list.get(i).compareTo( startVertex ) == 0 ) {
				vertex_exists = i;
			}
			
		}
		
		if ( vertex_exists == -1 )
			throw new VertexException( String.format("Vertex %s does not exist!", startVertex ) );
		
		for ( int i=0; i<adjacency_list.size(); i++ ) {
			
			adjacency_list.get(i).setVisited( Vertex.NOT_VISITED );
			
		}
		
		int count = 0;
		
		startVertex = adjacency_list.get( vertex_exists );
		
		Queue<Vertex<AnyType>> queue = new ConstantTimeQueue<Vertex<AnyType>>();
		
		queue.add( startVertex );
		
		try {
			
			while ( true ) {
				
				Vertex<AnyType> current_vertex = queue.remove();
				
				if ( !current_vertex.hasBeenVisited() ) {
					
					current_vertex.setVisited( ++count );
					
					for ( int i=0; i<current_vertex.numberOfAdjacentVertices(); i++ ) {
						
						queue.add( current_vertex.getAdjacentVertex( i ) );
						
					}
				
				}
				
			}
			
		} catch( NoSuchElementException emptyQueue ) {
			
			for ( int i=0; i<adjacency_list.size(); i++ ) {
				
				buffer.append( String.format("%s:%d\n", adjacency_list.get(i),
						adjacency_list.get(i).getVisited() ) );
				
			}
			
		}
		
		return buffer.toString();
		
	} // end breadthFirstSearch() method
	
	/**
	 * 
	 */
	public void clear() {
		
		adjacency_list.clear();
		
	} // end clear()
	
	
	/**
	 * 
	 * convert adjacency list to string
	 * 
	 * @return
	 */
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		for ( int i=0; i<adjacency_list.size(); i++ ) {
			
			buffer.append( adjacency_list.get( i ).printVertex() );
			
		}
		
		return buffer.toString();
		
	} // end toString() method
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		UndirectedGraph<Integer> graph = new UndirectedGraph<Integer>();
		System.out.println("For an connected graph:");
		graph.addEdge( 1, 2 );
		graph.addEdge( 1, 3 );
		graph.addEdge( 1, 4 );
		graph.addEdge( 2, 3 );
		graph.addEdge( 2, 5 );
		graph.addEdge( 2, 6 );
		graph.addEdge( 2, 4 );
		System.out.println( graph );
		if(graph.isConnected())
			System.out.println("This graph is connected");
		else {
			System.out.println("This graph is not connected");
		}
		System.out.println(graph.findAllCycles());
		System.out.println("\nFor an disconnected graph:");
		
		graph.addEdge( 12, 14 );//disconnected
		
		System.out.println( graph );
		if(graph.isConnected())
			System.out.println("This graph is connected");
		else {
			System.out.println("This graph is not connected");
		}
		System.out.println(graph.findAllCycles());
		System.out.printf( "DFS\n%s\n", graph.depthFirstSearch( 1 ) );
		System.out.printf( "BFS\n%s\n", graph.breadthFirstSearch( 1 ) );
		System.out.println(graph.findAllCycles());
		
		graph.clear();//empty
		
		System.out.println("This graph empty");
		System.out.println( graph );
		System.out.println(graph.findAllCycles());
		
		
		
	} // end main() method

} // end UndirectedGraph class definition