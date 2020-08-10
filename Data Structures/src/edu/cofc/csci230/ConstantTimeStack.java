package edu.cofc.csci230;

import java.util.EmptyStackException;

/**
 * A LIFO stack that has constant time complexity O(1) for
 * all three stack interface methods (i.e., push, pop, and 
 * peek).
 * 
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 * @param <AnyType>
 */
public class ConstantTimeStack<AnyType extends Comparable<AnyType>> implements Stack<AnyType> {
	
	/**
	 * ------------------------------
	 * TODO:
	 * ------------------------------
	 * 
	 * Select and instantiate a new ArrayList or DoublyLinkedList
	 * that will achieve constant time performance
	 */
	
	private List<AnyType> list = new DoublyLinkedList<AnyType>(); // modify this line of code
	/**
	 * Pushes an item onto the top of this stack in constant 
	 * time O(1)
	 * 
	 * @param t the item to be pushed onto this stack.
	 */
	public void push(AnyType t) {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a constant 
         * time O(1) operation
         * 
         */
		try {
			list.add(t);
		}
		catch(NullPointerException n) {
			System.out.println("NullPointerException: The value entered is null");
		}
		
		
		
	} // end push() method

	/**
	 * Removes the object at the top of this stack and return the 
	 * item in constant time O(1)
	 * .
	 * @return The item at the top of this stack
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public AnyType pop() throws EmptyStackException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your pop solution must be a constant 
         * time O(1) operation
         * 
         */
		if(list.size()==0) {
			throw new EmptyStackException();
		}
		else {
			return list.remove(list.size()-1);
		}
		
	} // end pop() method

	/**
	 * Looks at the item at the top of this stack without removing it 
	 * from the stack in constant time O(1)
	 * 
	 * @return the item at the top of this stack
	 * @throws EmptyStackException  - if this stack is empty.
	 */
	public AnyType peek() throws EmptyStackException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your peek solution must be a constant 
         * time O(1) operation
         * 
         */
		if(list.size()==0) {
			throw new EmptyStackException();
		}
		else {
			return list.get(list.size()-1);
		}
		
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
		ConstantTimeStack<Integer> stack = new ConstantTimeStack<Integer>();
		try {
			stack.pop();
		}
		catch(EmptyStackException e) {
			System.out.println("EmptyStackException: The stack is empty");
		}
		try {
			stack.peek();
		}
		catch(EmptyStackException e) {
			System.out.println("EmptyStackException: The stack is empty");
		}
		stack.push(null);//this should give an exception
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
		
		
	} // end main method

} // end ConstantTimeStack class definition
