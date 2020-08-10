package edu.cofc.csci230;

/**
 * Utilities class that will sort in ascending and descending order
 * the elements of a list.
 *
 * The sorting algorithms supported in this class are:
 *	1. selection sort
 *	2. bubble sort
 *	3. insertion sort
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 */
public class Utils {
	
	
	public static boolean ascending = true; 
	
	/**
	 * 
	 */
	private Utils() {
		
	} // end private constructor
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void selectionSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * TODO:
		 * 
		 * Implement selection sort algorithm as
		 * described in class. The pseudo-code for 
		 * this algorithm can also be found in the
		 * content section on OAKS and at the end
		 * of the homework assignment.
		 * 
		 * Must sort in:
		 * -----------------------------------------
		 * 1. ascending order (first element 
		 * in list is smallest value, last element in 
		 * list is largest value).
		 * 
		 * 2. descending order (first element 
		 * in list is largest value, last element in 
		 * list is smallest value).
		 * 
		 */
		if(ascending) {
			for(int i = 0; i<list.size()-1; i++) {
				int min = i;
				for(int j = i + 1; j<list.size(); j++) {
					
					if(list.get(j).compareTo(list.get(min))<0) {
						min = j;
					}
				}
				list.swap(i, min);
			}
		}
		else {
			for(int i = 0; i<list.size()-1; i++) {
				int min = i;
				for(int j = i + 1; j<list.size(); j++) {
					
					if(list.get(j).compareTo(list.get(min))>0) {
						min = j;
					}
				}
				list.swap(i, min);
			}
		}
		System.out.printf( "Ascending order [%b]\n", ascending );
		
		
		
		
		
		
		
	} // end selectionSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void bubbleSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * TODO:
		 * 
		 * Implement bubble sort algorithm as
		 * described in class. The pseudo-code for 
		 * this algorithm can also be found in the
		 * content section on OAKS and at the end
		 * of the homework assignment.
		 * 
		 * 
		 * Must sort in:
		 * -----------------------------------------
		 * 1. ascending order (first element 
		 * in list is smallest value, last element in 
		 * list is largest value).
		 * 
		 * 2. descending order (first element 
		 * in list is largest value, last element in 
		 * list is smallest value).
		 * 
		 */
		if(ascending) {
			for(int i = 0; i<list.size()-1; i++) {
				for(int j = 0; j<list.size()-1-i; j++) {
					
					if(list.get(j+1).compareTo(list.get(j))<0) {
						list.swap(j, j+1);
					}
				}
				
			}
		}
		else {
			for(int i = 0; i<list.size()-1; i++) {
				for(int j = 0; j<list.size()-1-i; j++) {
					
					if(list.get(j+1).compareTo(list.get(j))>0) {
						list.swap(j, j+1);
					}
				}
			}
		}
		System.out.printf( "Ascending order [%b]\n", ascending );
		
	} // end bubbleSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void insertionSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * TODO:
		 * 
		 * Implement insertion sort algorithm as
		 * described in class. The pseudo-code for 
		 * this algorithm can also be found in the
		 * content section on OAKS and at the end
		 * of the homework assignment.
		 * 
		 * 
		 * Must sort in:
		 * -----------------------------------------
		 * 1. ascending order (first element 
		 * in list is smallest value, last element in 
		 * list is largest value).
		 * 
		 * 2. descending order (first element 
		 * in list is largest value, last element in 
		 * list is smallest value).
		 * 
		 */
		if(ascending) {
			for(int i = 1; i<list.size(); i++) {
				AnyType v = list.get(i);
				int j = i-1;
				while(j>=0&&list.get(j).compareTo(v)>0) {
					list.set(j+1, list.get(j));
					j--;
				}
				list.set(j+1, v);
			}
		}
		else {
			for(int i = 1; i<list.size(); i++) {
				AnyType v = list.get(i);
				int j = i-1;
				while(j>=0&&list.get(j).compareTo(v)<0) {
					list.set(j+1, list.get(j));
					j--;
				}
				list.set(j+1, v);
			}
		}
		System.out.printf( "Ascending order [%b]\n", ascending );
		
		
		
		
		
	} // end insertionSort() method
	
} // end Utils class definition
