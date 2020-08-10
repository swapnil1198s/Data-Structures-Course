package edu.cofc.csci230;

import java.util.NoSuchElementException;

/**
 * A FIFO stack that has constant time complexity O(1) for
 * all three queue interface methods (i.e., add, remove, and 
 * peek).
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 * @param <AnyType>
 */
public class ConstantTimeQueue<AnyType extends Comparable<AnyType>> implements Queue<AnyType> {
	
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
	 * Inserts the specified element at the end of the queue in 
	 * constant time O(1)
	 * 
	 * @param t element to add
	 * @throws NullPointerException- if the specified element is null 
	 *                               (queue does not permit null elements)
	 */
	public void add(AnyType t) throws NullPointerException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation.
         * 
         */
		if(t==null) {
			throw new NullPointerException();
		}
		else {
			list.add(t);
		}
		
		
	} // end add() method

	/**
	 * Retrieves and removes the head of the queue in
	 * constant time O(1).
	 * 
	 * @return the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public AnyType remove() throws NoSuchElementException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a constant 
         * time O(1) operation. 
         * 
         *
         */
		if(list.size()==0) {
			throw new NoSuchElementException();
		}
		else {
			return list.remove(0);
		}
		
		
	} // end remove() method

	/**
	 * Retrieves, but does not remove, the head of the queue, 
	 * or returns null if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public AnyType peek() {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation 
         * 
         */
		if(list.size()==0) {
			return null;
		}
		else {
			return list.get(0);
		}
		
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
		ConstantTimeQueue<Integer> queue = new ConstantTimeQueue<Integer>();
		queue.add(3);
		queue.add(2);
		queue.add(13);
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		try {
			queue.remove();
		}
		catch(NoSuchElementException n) {
			System.out.println("NoSuchElementException: This queue is empty");
		}
		try {
			queue.add(null);
		}
		catch(NullPointerException n) {
			System.out.println("NullPointerException: item value is null");
		}
	} // end main() method

} // end ConstantTimeQueue class definition

