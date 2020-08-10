package edu.cofc.csci230;

/**
 * 
 * Open hashing data structure
 * 
 * @author CSCI 230: Data Structures and Algorithms 
 * 
 * Fall 2018 - Homework 7
 *
 */
public class OpenHashing extends HashTable { 
	
	/* private instance variables */
	private ArrayList<String>[] hash_table;
	
	/**
	 * Constructor
	 */
    public OpenHashing( int hash_function ) {
    	
    	this.hash_function = hash_function;
    	
    } // end constructor
    
    /**
     * Initialize the hash table
     * 
     * The number of elements in the hash table (m) is equal M.
     * 
     */
    @SuppressWarnings("unchecked")
	public void initialize() {
    	
    	hash_table = (ArrayList<String>[]) new ArrayList[ HashTable.M ];
    	
    	for ( int i=0; i<hash_table.length; i++ ) {
    		
    		hash_table[i] = new ArrayList<String>();
    		
    	}
    	
    } // end initialize() method
    
    
    /**
     * Search for word in the hash table
     * 
     * Exceptions: If the key does not exist in the hash table, the throw
     * 		       a HashTableKeyException
     * 
     * return: The number of list probes needed to find the word in a list at 
     *         at the computed key location in the hash table, e.g. One if the 
     *         word is the first element in the list, n if the word is the very 
     *         last element in the list (where n is the number of elements in the 
     *         list at a the computed key location in the hash_table).
     * 
     * @param word
     * @return
     */
	public int search( String word ) throws HashTableKeyException {
		
		int probes = 0;
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		int h_k = calcHash(word);
		if(h_k>=hash_table.length) {
			throw new HashTableKeyException(word);
		}
		else {
			if(hash_table[h_k].isEmpty()) {
				throw new HashTableKeyException(word);
			}
			else {
				while(hash_table[h_k].size()>probes && !(hash_table[h_k].get(probes).equals(word)) ) {
					probes++;
				}
			}
		}
		if(probes>=hash_table[h_k].size()) {
			throw new HashTableKeyException(word);
		}
		return probes + 1;
	    
		
	} // end search() method
	
	/**
	 * Insert word into hash table
	 * 
	 * Exceptions: Duplicate words are not allowed, e.g., if "dog" already exists
	 * 			   in the hash table, then another "dog" word cannot be inserted.
	 * 	           For a duplicate word insert operation throw a HashTableKeyException.
	 * 
	 * @param word
	 */
	public void insert( String word ) throws HashTableKeyException {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		int h_k = calcHash(word);
		int count = 0;
		while(count<hash_table[h_k].size() && !hash_table[h_k].get(count).equals(word)) {
			count ++;
		}
		if(count<hash_table[h_k].size()) {
			throw new HashTableKeyException(word);
		}
		hash_table[h_k].add(word);
		
		
		
	} // end insert() method
	
	/**
	 * Delete a word from the hash table
	 * 
	 * Exceptions: if they word does not exist in the hash table, then throw
	 * 			   a HashTableKeyException
	 * 
	 * return: The number of list probes needed to delete the word in the list 
	 * 		   located at the key location in the hash table, e.g. One if the 
     *         word is the first element in the list, n if the word is the very 
     *         last element in the list (where n is the number of elements in the 
     *         list at a the computed key location in the hash_table).
	 * 
	 * @param key
	 * @return
	 */
	public int delete ( String word ) throws HashTableKeyException {
		
		int probes = 0;
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		int h_k = calcHash(word);
		probes = search(word);
		hash_table[h_k].remove(probes-1);
		return probes;
		
	} // end delete() method
	
	/**
	 * See page 271 in supplemental course textbook (chapter is provided as PDF 
	 * on OAKS in content section).
	 * 
	 * Also, refer to your lecture notes.
	 * 
	 * @return
	 */
	public double loadFactor() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		double n = 0;
		for(int i =0 ; i<hash_table.length; i++) {
			for(int j = 0; j<hash_table[i].size();j++) {
				n++;
			}
		}
		if(n!=M) {
			return n/M;
		}
		
		return 1.0;
				
	} // end loadFactor() method
	
	
	/**
	 * See equation (7.4) on page 271 in supplemental course textbook (chapter 
	 * is provided as PDF on OAKS in content section).
	 * 
	 * @return
	 */
	public double successfulSearches() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		return 1 + loadFactor()/2;
				
	} // end successfulSearches() method
	
	/**
	 * See equation (7.4) on page 271 in supplemental course textbook (chapter 
	 * is provided as PDF on OAKS in content section).
	 * 
	 * @return
	 */
	public double unsuccessfulSearches() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		
		return loadFactor();
				
	} // end unsuccessfulSearches() method
		
} // end OpenHashing class definition
