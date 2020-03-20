/**
 * HW 5: Hashing
 * Written for CSCI 333, Prof. Adam Whitley
 * Contains OpenAddressedHashTable class that implements an open-addressed hash table of Integer objects.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		3/01/2020
 * Modified:	3/01/2020
 */

package hashing;

import java.util.Arrays;
import java.util.Random;

public class OpenAddressedHashTable {

	Integer[] table;
	private float A;
	private static final int DELETED = Integer.MIN_VALUE;
	private static final Random rand = new Random();
	

	/**
	 * Constructor for OpenAddressedHashTable object.
	 * @param n approximate number of entries.
	 */
	OpenAddressedHashTable(int n){
		int k = 1;
		while (k <= n) {
			k*=2;
		}
		table = new Integer[k];
		A = rand.nextFloat();
	}
	
	/**
	 * Inserts Integer x into the table.
	 * @param x the Integer to be inserted
	 * @return handle to x (null if insertion fails)
	 */
	public Integer insert(Integer x) {
		for (int i=0; i < table.length; i++) {
			int j = hash(x,i);
			if (table[j] == null || table[j] == DELETED) {
				table[j]=x;
				return x;
			}
		}
		System.out.println("Error: hash table overflow.\n");
		return null;
	}//insert
	
	/**
	 * Deletes Integer x from the table.
	 * @param x the Integer to be deleted.
	 * @return value of x (null if not found)
	 */
	public Integer delete(Integer x) {
		for (int i = 0; i < table.length; i++) {
			int j=hash(x,i);
			if (table[j].equals(x)) {
				table[j] = DELETED;
				return j;
			}
		}//for
		System.out.printf("Error: element %d not found.\n",x);
		return null;
	}//delete
	
	/**
	 * Searches for an Integer in the table, and returns its handle (null if not found).
	 * @param x Integer to search for
	 * @return handle to x (null if not found)
	 */
	public Integer search(Integer x) {
		for (int i = 0; i < table.length; i++) {
			int j = hash(x,i);
			if (table[j]==null) {
				return null;
			}//if
			if (table[j].equals(x)) {
				return x;
			}
		}//for
		return null;
	}//search
	
	/**
	 * Computes auxiliary hashed value of a key.
	 * @param key the key to be hashed
	 * @return hash value of key
	 */
	private int hash(Integer key) {
			int hashval;
			hashval = (int)(table.length*((key * A)%1));
			return hashval;
	}
	
	/**
	 * Primary hash function
	 * @param key the key to be hashed
	 * @param probeIndex the index into the probe sequence (number of previous calls to this function)
	 * @return index into hash table main array
	 */
	private int hash(Integer key, int probeIndex) {
		int x = (hash(key)+probeIndex)%table.length;
		return x;
	}
	
	/**
	 * Returns the hash table main array in string form.
	 */
	public String toString() {
		String str = "[";
		for (int i=0; i < table.length-1; i++) {
			if (table[i] == null) {
				str+="null, ";
			}
			else if (table[i] == DELETED) {
				str+="DELETED, ";
			}
			else str+=table[i] + ", ";
		}//for
		str+=table[table.length-1] + "]";
		return str;
	}
	

}