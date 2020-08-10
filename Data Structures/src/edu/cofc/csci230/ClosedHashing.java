package edu.cofc.csci230;

/**
 * 
 * Closed hashing data structure using linear probing.
 * 
 * @author CSCI 230: Data Structures and Algorithms 
 * 
 * Fall 2018 - Homework 7
 *
 */
public class ClosedHashing extends HashTable { 
	
	/* private instance variables */
	private String[] hash_table;
	private int[] collision_table;
	
	/**
	 * Constructor
	 */
    public ClosedHashing( int hash_function ) {
    	
    	this.hash_function = hash_function;
    	
    } // end constructor
    
    /**
     * Initialize the hash table
     * 
     * The number of elements in the hash table is equal
     * to 2 x the number of words (may or may not be unique) 
     * in the word list.
     * 
     */
    public void initialize() {
    	
    	hash_table = new String[ 2*words.size() ];
    	collision_table = new int[ 2*words.size() ];
    	
    	for ( int i=0; i<hash_table.length; i++ ) {
    		
    		hash_table[i] = null;
    		
    	}
    	
    } // end initialize() method
    
    
    
    /**
     * Search for word in the hash table.
     * 
     * The collision_table is used to indicate a word/key collision key has 
     * occurred. In the collision_table the number at the computed key index 
     * position stores the total number of collisions. For example, 
     * collision_table[16] = 3 means three collisions have occurred at key 
     * index position 16 in the hash_table.
     * 
     * Exceptions: If the word does not exist in the hash table, then throw 
     *             a HashTableKeyException
     * 
     * return: The number of linear probes needed to find the word in the 
     * 		   hash table, e.g. Zero if no probing, n if probed n times to
     *         find the word location.
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
		if(hash_table[h_k].isEmpty()) {
			
			throw new HashTableKeyException(word);
		}
		else {
			while(hash_table[h_k+probes]!=null && !(hash_table[h_k+probes].equals(word))) {
				probes++;
			}
		}
		if(hash_table[h_k+probes]==null) {
			throw new HashTableKeyException(word);
		}
		return probes;
	    
		
	} // end search() method
	
	/**
	 * Insert word into hash table
	 * 
     * return: The number of list probes needed to find the word in a list at 
     *         at the computed key location in the hash table, e.g. One if the 
     *         word is the first element in the list, n if the word is the very 
     *         last element in the list (where n is the number of elements in 
     *         the list at a the computed key location in the hash_table).
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
		int probes =0 ;
		
		int h_k = calcHash(word);
		while(hash_table[h_k + probes]!=(null)){
			if(hash_table[h_k+probes].equals(word)) {
				throw new HashTableKeyException(word);
			}
			probes++;
		}
		hash_table[h_k+probes] = word;
		collision_table[h_k] += 1;
		
		
		
	} // end insert() method
	
	/**
	 * Delete a word from the hash table. 
	 * 
	 * The collision_table is used to indicate a word/key collision key has 
     * occurred. In the collision_table the number at the computed key index 
     * position stores the total number of collisions. For example, 
     * collision_table[16] = 3 means three collisions have occurred at key 
     * index position 16 in the hash_table. 
     * 
     * Every successful word deletion should decrement the corresponding 
     * collision_table value by one. For example, if the key index position 
     * is 3 and the word has been successfully deleted then 
     * collision_table[16] = collision_table[16] - 1; Note: the number of 
     * collisions will never be less than zero. If it is, you have a bug
     * in your code :)
	 * 
	 * Exceptions: if they word does not exist in the hash table then throw
	 * 			   a HashTableKeyException
	 * 
	 * return: The number of linear probes needed to delete the word in the 
     * 		   hash table, e.g. Zero if no probing, n if probed n times to
     *         find the word location.
	 * 
	 * @param word
	 * @return
	 */
	public int delete ( String word ) throws HashTableKeyException {
		
		int probes = 0;
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		int h_k = calcHash(word);
	    if(hash_table[h_k].isEmpty()&&collision_table[h_k]==0) {
	    	throw new HashTableKeyException(word);
	    }
	    else {
	    	while((hash_table[h_k+probes]!=null)&& !(hash_table[h_k + probes].equals(word))) {
	    		probes++;
	    	}
	    }
	    if(hash_table[h_k+probes]==null) {
	    	throw new HashTableKeyException(word);
	    	
	    }
	    else {
	    	hash_table[h_k + probes] = "*";
	    }
		return probes;
		
	} // end delete() method
	
	/**
	 * See page 271 in supplemental course textbook (chapter is provided as PDF 
	 * on OAKS in content section).
	 * 
	 * Also, refer to your lecture notes. Note, for closed hashing, m is 
	 * the number of locations in the hash table.
	 * 
	 * @return
	 */
	public double loadFactor() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		double n = 0;
		for(int i = 0; i<hash_table.length; i++) {
			if(hash_table[i]!=null) {
				n++;
			}
		}
		if(n!=hash_table.length)
			return n/hash_table.length;
		
		return 1.0;
				
	} // end loadFactor() method
	
	
	/**
	 * See equation (7.5) on page 273 in supplemental course textbook (chapter 
	 * is provided as PDF on OAKS in content section).
	 * 
	 * @return
	 */
	public double successfulSearches() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		
		return 0.5*(1+(1/(1-loadFactor())));
				
	} // end successfulSearches() method
	
	/**
	 * See equation (7.5) on page 273 in supplemental course textbook (chapter 
	 * is provided as PDF on OAKS in content section).
	 * 
	 * @return
	 */
	public double unsuccessfulSearches() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		
		return 0.5*(1+(1/Math.sqrt(1-loadFactor())));
				
	} // end unsuccessfulSearches() method
	
} // end ClosedHashing class definition