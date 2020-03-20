/**
 * HW 5: Hashing
 * Written for CSCI 333, Prof. Adam Whitley
 * Contains ChainedHashTable class that implements a chained hash table of Integer objects.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		3/01/2020
 * Modified:	3/01/2020
 */

package hashing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ChainedHashTable {
	
	private LinkedList<Integer>[] listArray;
	private float A;
	private static final Random rand = new Random();
	
	/**
	 * Constructor for ChainedHashTable object.
	 * @param n approximate number of entries in table.
	 */
	ChainedHashTable(int n){
		int k = 1;
		while (k <= n) {
			k*=2;
		}
		listArray = new LinkedList[k];
		for (int i=0; i < k; i++) {
			listArray[i] = new LinkedList<Integer>();
		}
		A = rand.nextFloat();
	}
	
	/**
	 * Inserts an Integer object into the linked list at the correct (hash) index of the table and returns its location.
	 * @param x the object to be inserted
	 * @return the object's location
	 */
	public Integer insert(Integer x) {
		listArray[hash(x)].addFirst(x);
		return listArray[hash(x)].getFirst();
	}
	
	/**
	 * Deletes an Integer object from the table.
	 * @param x the object to be deleted
	 */
	public void delete(Integer x) {
		listArray[hash(x)].remove(x);
	}
	
	/**
	 * Searches the table for an Integer object and returns its location.
	 * @param x the object to be located
	 * @return the location of the object
	 */
	public Integer search(Integer x) {
		Iterator iterator = listArray[hash(x)].iterator();
		while (iterator.hasNext()) {
			Integer y = (Integer) iterator.next();
			if (y.equals(x)) {
				return x;
			}
		}//while
		return null;
	}
	
	/**
	 * Returns a string displaying the contents of the table, one linked list per line.
	 */
	public String toString() {
		String str = "";

		for (int i=0; i < listArray.length; i++) {
			str += listArray[i].toString()+"\n";
			}//for
		return str;
	}
	
	/**
	 * Computes the hash value of a key.
	 * @param key the key to be hashed
	 * @return the hash value
	 */
	private int hash(int key) {
		int hashval;
		hashval = (int)(listArray.length*((key * A)%1));
		return hashval;
	}
}
