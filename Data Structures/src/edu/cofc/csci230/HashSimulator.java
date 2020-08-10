package edu.cofc.csci230;

/**
 * 
 * Hash Simulator (main method)
 * 
 * @author CSCI 230: Data Structures and Algorithms 
 * 
 * Fall 2018 - Homework 7
 *
 */
public class HashSimulator { 
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
        
		HashTable hashDS = new ClosedHashing( HashTable.HASH_FUNC1 );
		System.out.printf("\n%s ----------------------------------\n", "Closed Hashing: FUNC1" );
		
		if ( hashDS.loadWords() ) {
			
			((ClosedHashing)hashDS).initialize();
			
			System.out.printf( "Number of non-unique words in file = %d\n", hashDS.getWords().size() );
			//1
			int s = 0;
			for(int i = 0; i<hashDS.words.size(); i++) {
				
				try {
					((ClosedHashing)hashDS).insert(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println("Exception: Duplicate words");
				}
			}
			//2
			System.out.println("Load Factor(n/M): " + ((ClosedHashing)hashDS).loadFactor());
			//3
			System.out.println("Successful Searches: " + ((ClosedHashing)hashDS).successfulSearches());
			//4
			System.out.println("Unsuccessful Searches: " + ((ClosedHashing)hashDS).unsuccessfulSearches());
			//5
			double probes = 0;
			s=0;
			for(int i = 0; i<hashDS.words.size();i++) {
				try {
					probes += ((ClosedHashing)hashDS).search(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println("Exception: Word does not exist in the hash data structure");
				}
			}
			System.out.println("Mean probes(total probes/total number of searches): " + probes/(hashDS.words.size()));
			//6
			try {
				System.out.println(((ClosedHashing)hashDS).search("Globetrotters"));
			} catch (HashTableKeyException e) {
				System.out.println("Exception: Word does not exist in the hash data structure");
			}
			//7
			probes = 0;
			for(int i = 0; i<hashDS.words.size();i++) {
				try {
					probes += ((ClosedHashing)hashDS).delete(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println(" Exception: Word does not exist in the hash data structure");
				}
			}
			System.out.println("Mean probes for delete(total probes/total number of searches): " + probes/(hashDS.words.size()));
			//8
			try {
				System.out.println(((ClosedHashing)hashDS).delete("globetrotters"));
			} catch (HashTableKeyException e) {
				System.out.println("Exception: Word does not exist in the hash data structure");
			}
			/* ------------------------------------------------
			 * TODO:
			 * ------------------------------------------------
			 * 1) Insert each word into hash data structure
			 * 2) Calculate load factor value and print to 
			 *    console (using System.printf or System.println)
			 * 3) Calculate successful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 4) Calculate unsuccessful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 5) For each word in words list, search in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 6) For a word (you choose) that does not exist in hashDS, 
			 *    try to search for it in the hashDS and then print the probe 
			 *    value to console (using System.printf or System.println)
			 * 7) For each word in words list, delete word in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 8) For a word (you choose) that does not exist in hashDS, 
			 *    try to delete in the hashDS and then print the probe value to 
			 *    console (using System.printf or System.println)
			 * 
			 */
			
		} else {
			
			System.out.println("Failed to load words from text file" );
		}
		
		// ------------------------------------------------
		// Repeat for second hash function
		
		System.out.printf("\n%s ----------------------------------\n", "Closed Hashing: FUNC2" );
		hashDS = new ClosedHashing( HashTable.HASH_FUNC2 );
		
		if ( hashDS.loadWords() ) {
			
			((ClosedHashing)hashDS).initialize();
			
			System.out.printf( "Number of non-unique words in file = %d\n", hashDS.getWords().size() );
			//1
			int s = 0;
			for(int i = 0; i<hashDS.words.size(); i++) {
				
				try {
					((ClosedHashing)hashDS).insert(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println("Exception: Duplicate words");
				}
			}
			//2
			System.out.println("Load Factor(n/M): " + ((ClosedHashing)hashDS).loadFactor());
			//3
			System.out.println("Successful Searches: " + ((ClosedHashing)hashDS).successfulSearches());
			//4
			System.out.println("Unsuccessful Searches: " + ((ClosedHashing)hashDS).unsuccessfulSearches());
			//5
			double probes = 0;
			s=0;
			for(int i = 0; i<hashDS.words.size();i++) {
				try {
					probes += ((ClosedHashing)hashDS).search(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println("Exception: Word does not exist in the hash data structure");
				}
			}
			System.out.println("Mean probes(total probes/total number of searches): " + probes/(hashDS.words.size()));
			//6
			try {
				System.out.println(((ClosedHashing)hashDS).search("Globetrotters"));
			} catch (HashTableKeyException e) {
				System.out.println("Exception: Word does not exist in the hash data structure");
			}
			//7
			probes = 0;
			for(int i = 0; i<hashDS.words.size();i++) {
				try {
					probes += ((ClosedHashing)hashDS).delete(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println(" Exception: Word does not exist in the hash data structure");
				}
			}
			System.out.println("Mean probes for delete(total probes/total number of searches): " + probes/(hashDS.words.size()));
			//8
			try {
				System.out.println(((ClosedHashing)hashDS).delete("globetrotters"));
			} catch (HashTableKeyException e) {
				System.out.println("Exception: Word does not exist in the hash data structure");
			}
			/* ------------------------------------------------
			 * TODO:
			 * ------------------------------------------------
			 * 1) Insert each word into hash data structure
			 * 2) Calculate load factor value and print to 
			 *    console (using System.printf or System.println)
			 * 3) Calculate successful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 4) Calculate unsuccessful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 5) For each word in words list, search in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 6) For a word (you choose) that does not exist in hashDS, 
			 *    try to search for it in the hashDS and then print the probe 
			 *    value to console (using System.printf or System.println)
			 * 7) For each word in words list, delete word in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 8) For a word (you choose) that does not exist in hashDS, 
			 *    try to delete in the hashDS and then print the probe value to 
			 *    console (using System.printf or System.println)
			 * 
			 */
			
			
			
			
		} else {
			
			System.out.println("Failed to load words from text file" );
		}

		hashDS = new OpenHashing( HashTable.HASH_FUNC1 );
		System.out.printf("\n%s ----------------------------------\n", "Open Hashing: FUNC1" );
		
		if ( hashDS.loadWords() ) {
			
			((OpenHashing)hashDS).initialize();
			
			System.out.printf( "Number of non-unique words in file = %d\n", hashDS.getWords().size() );
			//1
			for(int i = 0; i<hashDS.words.size(); i++) {
				
				try {
					((OpenHashing)hashDS).insert(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println("Exception: Duplicate words");
				}
			}
			//2
			
			System.out.println("Load Factor(n/M): " + ((OpenHashing)hashDS).loadFactor());
			//3
			
			System.out.println("Successful Searches: " + ((OpenHashing)hashDS).successfulSearches());
			//4
			
			System.out.println("Unsuccessful Searches: " + ((OpenHashing)hashDS).unsuccessfulSearches());
			//5
			
			double probes = 0;
			for(int i = 0; i<hashDS.words.size();i++) {
				try {
					probes += ((OpenHashing)hashDS).search(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println("Exception: Word does not exist in the hash data structure");
				}
			}
			System.out.println("Mean probes(total probes/total number of searches): " + probes/(hashDS.words.size()));
			//6
			try {
				System.out.println(((OpenHashing)hashDS).search("Globetrotters"));
			} catch (HashTableKeyException e) {
				System.out.println("Exception: Word does not exist in the hash data structure");
			}
			
			//7
			probes = 0;
			for(int i = 0; i<hashDS.words.size();i++) {
				try {
					probes += ((OpenHashing)hashDS).delete(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println(" Exception: Word does not exist in the hash data structure");
				}
			}
			System.out.println("Mean probes for delete(total probes/total number of searches): " + probes/(hashDS.words.size()));
			//8
			try {
				System.out.println(((OpenHashing)hashDS).delete("globetrotters"));
			} catch (HashTableKeyException e) {
				System.out.println("Exception: Word does not exist in the hash data structure");
			}
			/* ------------------------------------------------
			 * TODO:
			 * ------------------------------------------------
			 * 1) Insert each word into hash data structure
			 * 2) Calculate load factor value and print to 
			 *    console (using System.printf or System.println)
			 * 3) Calculate successful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 4) Calculate unsuccessful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 5) For each word in words list, search in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 6) For a word (you choose) that does not exist in hashDS, 
			 *    try to search for it in the hashDS and then print the probe 
			 *    value to console (using System.printf or System.println)
			 * 7) For each word in words list, delete word in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 8) For a word (you choose) that does not exist in hashDS, 
			 *    try to delete in the hashDS and then print the probe value to 
			 *    console (using System.printf or System.println)
			 * 
			 */
			
			
			
			
			
			
		} else {
			
			System.out.println("Failed to load words from text file" );
			
		}
		
		// ------------------------------------------------
		// Repeat for second hash function
		
		hashDS = new OpenHashing( HashTable.HASH_FUNC2 );
		System.out.printf("\n%s ----------------------------------\n", "Open Hashing: FUNC2" );
		
		if ( hashDS.loadWords() ) {
			
			((OpenHashing)hashDS).initialize();
			
			System.out.printf( "Number of non-unique words in file = %d\n", hashDS.getWords().size() );
			
			//1
			
			for(int i = 0; i<hashDS.getWords().size(); i++) {
				
				try {
					((OpenHashing)hashDS).insert(hashDS.getWords().get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println("Exception: Duplicate words");
				}
			}
			//2
			
			System.out.println("Load Factor(n/M): " + ((OpenHashing)hashDS).loadFactor());
			//3
			
			System.out.println("Successful Searches: " + ((OpenHashing)hashDS).successfulSearches());
			//4
			
			System.out.println("Unsuccessful Searches: " + ((OpenHashing)hashDS).unsuccessfulSearches());
			//5
			
			double probes = 0;
			for(int i = 0; i<hashDS.words.size();i++) {
				try {
					probes += ((OpenHashing)hashDS).search(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println("Exception: Word does not exist in the hash data structure");
				}
			}
			System.out.println("Mean probes(total probes/total number of searches): " + probes/(hashDS.words.size()));
			//6
			try {
				System.out.println(((OpenHashing)hashDS).search("Globetrotters"));
			} catch (HashTableKeyException e) {
				System.out.println("Exception: Word does not exist in the hash data structure");
			}
			
			//7
			probes = 0;
			for(int i = 0; i<hashDS.words.size();i++) {
				try {
					probes += ((OpenHashing)hashDS).delete(hashDS.words.get(i));
				}
				catch (HashTableKeyException e) {
					System.out.println("Exception: Word does not exist in the hash data structure");
				}
			}
			System.out.println("Mean probes for delete(total probes/total number of searches): " + probes/(hashDS.words.size()));
			//8
			try {
				System.out.println(((OpenHashing)hashDS).delete("globetrotters"));
			} catch (HashTableKeyException e) {
				System.out.println("Exception: Word does not exist in the hash data structure");
			}
			/* ------------------------------------------------
			 * TODO:
			 * ------------------------------------------------
			 * 1) Insert each word into hash data structure
			 * 2) Calculate load factor value and print to 
			 *    console (using System.printf or System.println)
			 * 3) Calculate successful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 4) Calculate unsuccessful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 5) For each word in words list, search in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 6) For a word (you choose) that does not exist in hashDS, 
			 *    try to search for it in the hashDS and then print the probe 
			 *    value to console (using System.printf or System.println)
			 * 7) For each word in words list, delete word in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 8) For a word (you choose) that does not exist in hashDS, 
			 *    try to delete in the hashDS and then print the probe value to 
			 *    console (using System.printf or System.println)
			 * 
			 */
			
			
			
			
			
			
		} else {
			
			System.out.println("Failed to load words from text file" );
		}
		
    } // end main() method
	
} // end Hash Simulator class definition