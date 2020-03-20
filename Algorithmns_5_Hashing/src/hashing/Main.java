/**
 * HW 5: Hashing
 * Written for CSCI 333, Prof. Adam Whitley
 * Tests ChainedHashTable and OpenAddressedHashTable classes.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		2/29/2020
 * Modified:	3/01/2020
 */

package hashing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;


public class Main {

//************************************************//
	//***** Global variables and objects *****//
	static final int TEST_TABLES_N = 20;
	static final int TEST_TABLES_RANGE = 50;
	static Random rand = new Random();
			
//***********************************************//
	
	public static void main(String[] args) {
		Integer[] insertionArray = new Integer[TEST_TABLES_N];
		System.out.printf("Welcome to Jesse Reeve's algorithm tester!\n");
		System.out.printf("The main method has static variables for number of Integers to add to each table and range of values for Integers.\n");
		System.out.printf("Happy grading!\n\n");
			System.out.printf("Now initializing ChainedHashTable.\n");
			ChainedHashTable chainedTable = new ChainedHashTable(TEST_TABLES_N);
			for (int j=0; j<TEST_TABLES_N; j++) {
				int x = (rand.nextInt(TEST_TABLES_RANGE))+TEST_TABLES_RANGE*j;
				insertionArray[j] = x;
				chainedTable.insert(x); 
			}//for
			System.out.printf("Inserted the following values: \n%s\n", Arrays.toString(insertionArray));
			System.out.printf("Displaying hash table contents:\n%s\n", chainedTable.toString());
			System.out.printf("Testing delete() method.\n");
			for (int j=0; j < 5; j++) {
				System.out.printf("Deleting %d.\n", insertionArray[j]);
				chainedTable.delete(insertionArray[j]);
			}
			System.out.printf("Displaying hash table contents:\n%s", chainedTable.toString());
			
			Integer[] validSearchArray = new Integer[5];
			validSearchArray = Arrays.copyOfRange(insertionArray, 5, 10);
			System.out.printf("Searching for valid keys %s\n", Arrays.toString(validSearchArray));
			for (int j = 0; j < validSearchArray.length; j++) {
				System.out.printf("Search returned %d!\n", chainedTable.search(validSearchArray[j]));
			}
			Integer[] invalidSearchArray = new Integer[5];
			for (int j=0; j < 5; j++) {
				invalidSearchArray = Arrays.copyOfRange(insertionArray, 0, 5);
			}
			
			System.out.printf("Searching for deleted keys %s\n", Arrays.toString(invalidSearchArray));
			for (int j = 0; j < invalidSearchArray.length; j++) {
				System.out.printf("Search returned %d!\n", chainedTable.search(invalidSearchArray[j]));
			}//for
			System.out.println();

		System.out.println("Now initializing OpenAddressedHashTable.\n");
		OpenAddressedHashTable openTable = new OpenAddressedHashTable(20);
		for (int j=0; j<TEST_TABLES_N; j++) {
			int x = (rand.nextInt(TEST_TABLES_RANGE))+TEST_TABLES_RANGE*j;
			insertionArray[j] = x;
			openTable.insert(x);
		}//for
		System.out.printf("Inserted values:\n%s\n",Arrays.toString(insertionArray));
		System.out.println("Table contents:");
		System.out.println(openTable.toString());
		Integer[] deletionArray = Arrays.copyOfRange(insertionArray, 0, 5);
		System.out.printf("Now deleting:\n%s\n",Arrays.toString(deletionArray));
		for (int j=0; j<deletionArray.length; j++) {
			openTable.delete(deletionArray[j]);
		}
		System.out.println("Table contents:\n");
		System.out.println(openTable.toString());
		validSearchArray = Arrays.copyOfRange(insertionArray, 5, 10);
		System.out.printf("Searching for valid keys ");
		System.out.println(Arrays.toString(validSearchArray));
		for (int j=0; j<validSearchArray.length; j++) {
			System.out.printf("Search returned %d!\n", openTable.search(validSearchArray[j]));
		}
		for (int i=0; i < 5; i++) {
			invalidSearchArray[i] = rand.nextInt(100) + TEST_TABLES_RANGE;
		}
		System.out.printf("Searching for deleted keys ");
		System.out.println(Arrays.toString(invalidSearchArray));
		for (int j=0; j<invalidSearchArray.length; j++) {
			System.out.printf("Search returned %d!\n", openTable.search(invalidSearchArray[j]));
		}
	}//main
	
}//main class
