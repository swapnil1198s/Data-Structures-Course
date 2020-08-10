package edu.cofc.csci230;

/**
 * 
 * Binary search that does not allow two (or more) binary nodes 
 * in the search tree to have the same element value.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 * @param <AnyType>
 */
public class BinarySearchTree <AnyType extends Comparable<AnyType>> {
	
	// --------------------------------------
	// instance variable
	private BinaryNode<AnyType> root;
	
	/**
	 *
	 * Constructor with one parameter that
	 * sets the root node of the BST.
	 * 
	 * @param rootElement
	 * @throws NullBinaryNodeException
	 */
	public BinarySearchTree( AnyType rootElement ) throws NullBinaryNodeException {
		
		if ( rootElement == null ) {
			throw new NullBinaryNodeException();
		}
		
		this.root = new BinaryNode<AnyType>( rootElement ) ;
		
	} // end constructor
	
	/**
	 * If the BST does not have a root node, then it is empty. 
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		
		return ( root == null );
		
	} // end isEmpty() method
	
	/**
	 * Make the BST empty, i.e. a BST that has 
	 * no nodes (including a root node).
	 * 
	 */
	public void clear() {
		
		root = null;
		
	} // end clear() method
	
	/**
	 * Method that inserts a new node with the specified element 
	 * value in the BST.
	 * 
	 * This method has one parameter:
	 *  1) The element value to be added
	 * 
	 * If the BST has an existing node with the same element 
	 * value, throw an duplicate element exception.
	 * 
	 * @param element
	 * @throws DuplicateElementException
	 * @throws NullBinaryNodeException
	 */
	public void insert( AnyType element ) throws NullBinaryNodeException, DuplicateElementException {
		
		if ( element == null )
			throw new NullBinaryNodeException();
		
		if ( root == null )
			this.root = new BinaryNode<AnyType>( element );
		else
			insert( root, element );

	} // end insert() method
	
	/**
	 * Private recursive method that inserts a new node (with the 
	 * specified element value) in the BST.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value to be added
	 * 
	 * If the BST has an existing node with the same element 
	 * value, throw an duplicate element exception.
	 * 
	 * @param node
	 * @param element
	 * @throws DuplicateElementException
	 */
	private void insert( BinaryNode<AnyType> node, AnyType element )  throws DuplicateElementException {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution MUST USE recursion
		 * 
		 */
		if(node.getElement().compareTo(element)==0) {
			throw new DuplicateElementException();
		}
		if(node.getElement().compareTo(element)<0) {
			if(node.getRight()==null) {
				node.setRight(new BinaryNode<AnyType>( element ));
			}
			else {
				insert(node.getRight(), element);
			}
		}
		else if(node.getElement().compareTo(element)>0) {
			if(node.getLeft()==null) {
				node.setLeft(new BinaryNode<AnyType>( element ));
			}
			else {
				insert(node.getLeft(), element);
			}
		}
		







		
	} // end insert() overloaded method
	
	/**
	 * Method that determines if a node with the specified element value 
	 * exists in the BST. 
	 * 
	 * This method has one parameter:
	 *  1) The element value that is being searched.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @param element
	 * @throws EmptyBSTException
	 * @throws NullBinaryNodeException
	 * @return
	 */
	public boolean search( AnyType element ) throws NullBinaryNodeException, EmptyBSTException {
		
		if ( element == null )
			throw new NullBinaryNodeException();
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return search( root, element );
		
	} // end search() method
	
	/**
	 * Private recursive method that determines if the element is 
	 * currently stored in the BST.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value that is being searched.
	 *  
	 *  Hint: use the compareTo() method
	 * 
	 * @param element
	 * @param node
	 * @return
	 */
	private boolean search( BinaryNode<AnyType> node, AnyType element ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution MUST USE recursion
		 * 
		 */
		if(node.getElement().compareTo(element)==0) {
			return true;
		}
		if(node.getElement().compareTo(element)>0) {
			if(node.getLeft()!=null) {
				return search(node.getLeft(),element);}
		}
		else {
			if(node.getRight()!=null) {
				return search(node.getRight(), element);
			}
		}
		return false;





		
	} // end search() overloaded method
	
	/**
	 * Find the node with the minimum element value in the BST.
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType min() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return min( root ).getElement();
		
	} // end findMin() method
	
	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the minimum element value.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 * 
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> min( BinaryNode<AnyType> node ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution MUST USE recursion
		 * 
		 */
		if(node.getLeft()!=null) {
			return min(node.getLeft());
		}
		else {
			return node;
		}







		
	} // end min() method
	
	/**
	 * Find the node with the maximum element value in the BST.
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType max() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return max( root ).getElement();
		
	} // end max() method
	
	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the maximum element value.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 * 
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> max( BinaryNode<AnyType> node ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		if(node.getRight()!= null) {
			return max(node.getRight());
		}
		else {
			return node;
		}





		
		
	} // end max() method

	/**
	 * Delete the node with the specified element value in the BST.
	 * 
	 * This method has one parameter:
	 * 	1) the element value to be deleted
	 * 
	 * This method performs the following delete operations
	 * 	1) delete node with no children (case 1)
	 * 	2) delete node with one child (case 2)
	 * 	3) delete node with two children (case 3)
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * If the element is null, throw a null binary node 
	 * exception
	 *  
	 * @param element
	 * @throws EmptyBSTException
	 * @throws NullBinaryNodeException
	 */
	public AnyType delete( AnyType element ) throws EmptyBSTException, NullBinaryNodeException {
		
		if ( element == null )
			throw new NullBinaryNodeException();
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return delete( root, element ).getElement();
		
	} // end delete() method


	/**
	 * Private recursive method that walk the BST looking for 
	 * the specified element value to be removed.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value that is being removed.
	 *  
	 * @param node
	 * @param element
	 */
	private BinaryNode<AnyType> delete( BinaryNode<AnyType> node, AnyType element ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution MUST USE recursion
		 * 
		 */
		if(node.getElement().compareTo(element)>0) {
			node.setLeft(delete(node.getLeft(), element));
		}
		else if(node.getElement().compareTo(element)<0) {
			node.setRight(delete(node.getRight(), element));
		}
		else{
			if(node.getLeft()==null&&node.getRight()==null) {
				return null;
			}
			else if(node.getLeft() == null && node.getRight()!=null) {
				return node.getRight();
			}
			else if(node.getLeft() != null && node.getRight()==null) {
				return node.getLeft();
			}
			else {
				BinaryNode<AnyType> temp = max(node.getLeft());
				node.setElement(temp.getElement());
				node.setLeft(delete(node.getLeft(), temp.getElement()));
				return node;
			}
		}
		
		
		








		return node;
		
		
	} // end delete() method


	/**
	 * Recursive method that traverses the BST 
	 * dynamically creating a string with the
	 * element values stored in an pre-order 
	 * tree traversal format.
	 * 
	 * The return string MUST be formated as follows:
	 * <element>,<element>,<element>,<element>, .... <element>
	 * where <element> is the element value
	 * For example,
	 * 	2,1,3
	 * Hint: you may want to use regular expressions
	 * 
	 * Discussed in class, please review 
	 * your notes
	 * 
	 * If the BST is empty, throw an empty binary search 
	 * tree exception
	 * 
	 * @throws EmptyBSTException 
	 * @return 
	 * 
	 */
	public String preOrder() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return preOrder( root );
		
	} // end preOrder() method
	
	/**
	 * Private recursive method that traverses the BST 
	 * dynamically creating a string with the
	 * element values stored in an pre-order 
	 * tree traversal format. 
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 *  
	 * @param node
	 * @return
	 * 
	 */
	private String preOrder( BinaryNode<AnyType> node ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution MUST USE recursion
		 * 
		 */
		String s = "" +  node.getElement();
		if(node.getLeft()!=null) {
			s += "," + preOrder(node.getLeft());
		}
		if(node.getRight()!=null) {
			s += "," + preOrder(node.getRight());
		}	
		return s;
		
	} // end preOrder() method

	
	/**
	 * 
	 * You may modify this (no restrictions) to help debug your code.
	 * 
	 */
	public String toString() {
		
		
		
		
		
		return null;


	} // end toString() method
	
	
	/**
	 * 
	 * You may modify this (no restrictions) to help debug your code.
	 * 
	 */
	public void printBST() {
		System.out.println(preOrder(root));
		
		
		
		
		
		
		
		
	} // end printBST() method

	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		/**
		 * ------------------------------------
		 * TODO: You put your test cases here
		 * 
		 * 
		 */
		
		// this will get you started :)
		
		BinarySearchTree<Integer> bst;
		
		try {
			
			bst = new BinarySearchTree<Integer>( 10 );
			try {
				bst.insert(8);
				bst.insert(8);
			}
			catch(DuplicateElementException e) {
				System.out.println("This element already exists in the tree");
			}
			try {
				bst.insert(7);
				bst.insert(4);
				bst.insert(6);
				bst.insert(1);
				bst.insert(12);
				bst.insert(17);
				bst.insert(11);
				bst.printBST();
				
				
			}
			catch(DuplicateElementException e) {
				System.out.println("This element already exists in the tree");
			}
			try {
				System.out.println(bst.search(8));//exists
				System.out.println(bst.search(18));//does not exist
				bst.printBST();
				System.out.println("Max: " + bst.max());
				System.out.println("Max: " + bst.min());
				System.out.println("Pre-Order: " + bst.preOrder());
				bst.delete(12);
				bst.printBST();
				bst.delete(10);
				bst.printBST();
				bst.delete(1);
				try {
					bst.delete(80);
				}
				catch(NullPointerException e) {
					System.out.println("The value does not exist");
				}
				bst.printBST();
				bst.clear();
				bst.search(8);
			}
			catch(EmptyBSTException e) {
				System.out.println("The BST is empty");
			}
			
		} catch( NullBinaryNodeException error ) {
			
			System.out.println( error );
			
		}

		
		
	} // end main method
	

} // end BinarySearchTree class
