/* *****************************************************************************
 /* *****************************************************************************
 *              ALL STUDENTS COMPLETE THESE SECTIONS
 * Title:            Array Utils
 * Files:            array-utils.java
 * Semester:         Spring 2021
 * 
 * Author:           Grace Geer, grge5733@colorado.edu
 * 
 * Description:		 This code includes various methods used to manipulate arrays
 * 
 * Written:       	 01/09/2021
 * 
 * Credits:          I received help from Hooman
 **************************************************************************** */

import java.lang.reflect.Array;
import java.util.Random;


/**
 * This class contains methods that manipulate arrays
 *
 * <p>Bugs: (a list of bugs and other problems)
 *
 * @author Grace Geer
 */
public class ArrayUtils {

	/**         
     * This class includes various methods for changing, viewing, or iterating through arrays
     *
     * @param args No command-line arguments expected
     */
	
    public static void main(String[] args) {
    	Random randGenerator = new Random();
    	//Random randGenerator = new Random(4); // switch this line with the line above if you want to
												// ensure you generate an array with duplicates

    	int[] intArray = new int[10];

    	//Generate 10 random numbers in the range [1, 100] and store them in the intArray
    	for (int i = 0; i < 10; ++i) {
    		intArray[i] = randGenerator.nextInt(100) + 1;
    	} 

    	System.out.println("The array is:");
    	printArrayContents(intArray);
    	System.out.println();


    	//See if the value 42 is in the array, if not, set index 7 to be 42
    	System.out.println("Checking if 42 was in the array.");
    	int index = arrayIndexOf(42, intArray);
    	if (index == -1) {
    		System.out.println("42 wasn't in the array!");
    		System.out.println("Setting index 7 to be 42");
    		arraySet(42, 7, intArray);
    		System.out.println("Now the array is:");
    		printArrayContents(intArray);
    	}
    	else {
    		System.out.println("Found 42 at index " + index);
    	}
    	System.out.println();




    	//Append an eleventh value (also randomly generated) to the array
    	int newValue = randGenerator.nextInt(100)+1;
    	System.out.println("Appending " + newValue + " to the end of the array.");
    	intArray = arrayAppend(newValue, intArray);
    	System.out.println("Now the array is:");
		printArrayContents(intArray);
		System.out.println();



    	//Insert another new value at the second position
		newValue = randGenerator.nextInt(100)+1;
		System.out.println("Inserting " + newValue + " in index 2.");
    	intArray = arrayInsert(newValue, 2, intArray);
    	System.out.println("Now the array is:");
		printArrayContents(intArray);
		System.out.println();



		//Remove the value at the fifth position (i.e., in index 4)
		int indexToRemove = 4;
		System.out.println("Removing value " + intArray[indexToRemove] + " from index " + indexToRemove);
		intArray = removeIndex(indexToRemove, intArray);
		System.out.println("Now the array is:");
		printArrayContents(intArray);
		System.out.println();



		//Check if the array had any duplicate values
		System.out.println("Checking if the array had any duplicate values.");
		if (arrayContainsDuplicates(intArray)) {
			System.out.println("The array contained duplicates!");
		}
		else {
			System.out.println("The array did not contain any duplicates!");
		}
		System.out.println();



		//Swap the first and last values in the array
		int index1 = 0;
		int index2 = intArray.length - 1;
		System.out.println("Swapping the values in index " + index1 + " and index " + index2);
		arraySwap(index1, index2, intArray);
		System.out.println("Now the array is:");
		printArrayContents(intArray);
		System.out.println();


    
		//Sort the array using BubbleSort
		System.out.println("Sorting array");
		bubbleSort(intArray);
		System.out.println("Now the array is:");
		printArrayContents(intArray);
	
    }


	/**
     * Returns array contents
     * 
     * @param intArray enter what array you want printed
     */
    public static void printArrayContents(int[] intArray) {
		System.out.print("[");
		for(int i = 0; i < intArray.length-1; i++) {
			System.out.print(intArray[i] + ",");
		}
		System.out.println(intArray[intArray.length-1] + "]");
	}

	/**
	 * Write a succinct description of this method here.
	 * 
	 * @param targe Explain this parameter here
	 * @param intArray Explain what this parameter means here
	 * @return Explain what this method returns here (it should return the index
	 * 		   of target if target is in the array or -1 if target is not)
	 */
	public static int arrayIndexOf(int target, int[] intArray) {
		// Loop through the given array, return -1 if any index = 42
		for (int i = 0; i < intArray.length-1; i++) { //loops through whole array
			if (intArray[i] == target) {			  //if there's no 42, return i
				return i;
			}

	}

		return -1;	
	}
    /**
     * Write a succinct description of this method here.
     * 
     * @param value
     * @param index
     * @param intArray
     */
    public static void arraySet(int value, int index, int[] intArray) {
		if(index < intArray.length && index >= 0) {
			intArray[index] = value;
		}
	}

	/**
	 * Adds integer to end of array
	 * 
	 * @param value
	 * @param intArray
	 * @return new array
	 */
	public static int[] arrayAppend(int value, int[] intArray) {
		int[] newArray = new int[intArray.length + 1];
		for(int i = 0; i<intArray.length; i++){					//loops through original array
			newArray[i] = intArray[i];						//assigns original array value to new array with value at end
		}
		newArray[newArray.length-1] = value;
		return newArray;
	}

	/**
	 * Inserts a new value at an index in the array
	 * 
	 * @param newValue
	 * @param index
	 * @param intArray
	 * @return
	 */
	public static int[] arrayInsert(int newValue, int index, int[] intArray) {
		int[] newArray = new int[intArray.length + 1];
		
		for (int i = 0; i < index; i++) {
		newArray[i] = intArray[i];
		}
		newArray[index] = newValue;
		
		for(int i = index + 1; i < intArray.length + 1; i++) {
			newArray[i] = intArray[i-1];
		}
		return newArray;
	}

	/**
	 * Removes an index from an array
	 * 
	 * @param indexToRemove
	 * @param intArray
	 * @return 
	 */
	public static int[] removeIndex(int indexToRemove, int[] intArray) {

		int[] newArray = new int[intArray.length - 1];
		for(int i = 0; i < intArray.length-1; i++) {
			if(indexToRemove <= i) {
				newArray[i] = intArray[i + 1];
			}
			else {
				newArray[i] = intArray[i];
			}
		}
		return newArray;
	}

	/**
	 * Checks array for duplicates
	 * 
	 * @param intArray
	 * @return
	 */
	//fix this one -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static boolean arrayContainsDuplicates(int[] intArray) {
		//Have: [2, 64, 2, 768, 342, 2, 43]
		boolean dup = false;
		for(int i = 0; i < intArray.length; i++) {
			for(int j = 0; j < intArray.length; j++) {
				if (intArray[i] == intArray[j]) {
					dup = true;
				}
				else{
					dup = false;
				}
			}
		}
		return dup;
	}

	/**
	 * Swaps two indexes in array
	 * 
	 * @param index1
	 * @param index2
	 * @param intArray
	 */
	public static void arraySwap(int index1, int index2, int[] intArray) {
		int num = intArray[index1];
		int num2 = intArray[index2];
		intArray[index2] = num;
		intArray[index1] = num2;
	}

	/**
	 * Write a succinct description of this method here.
	 * 
		BubbleSort works as follows:
		Iterate through array checking each element with the previous
		element – if the current element is less than the previous
		element, swap them. Repeat until no new swaps were done.
		The psuedocode is:
		1. define a swapOccured variable = false
		2. Do
			1. set swapOccured = false
			2. iterate through array
				3. if currElement < prevElement, swap elements and set
				   swapOccured to true
		   while (swapOccured)
		Be careful not to go out of bounds of the array. Assume the array
		is completely full.
		
		Can you describe how this works and why it sorts the array?
		Do you think this is an efficient or inefficient way to sort the array? Can you
		think of a better method?
			This is not very efficient. The computer has to iterate through the array and compare 
			indexes to each other many times. It would be more efficient if your code recognized 
			the smallest number and put it at index 0, then found the next smallest number and 
			shifted it to index 1, and so on. You'd want the numbers to jump to their spots rather
			than being compared to their neighbors and swapping. 
	 * 
	 * @param data
	 */
	public static void bubbleSort(int[] data) {
//  Have [6, 3, 8, 6, 0, 3]
//  Want [0, 3, 3, 6, 6, 8]
		
		boolean swapOccured = false;
		
		for (int i = 0; i < data.length - 1; i++) {
			if(data[i] > data[i + 1]){
				arraySwap(i, i+1, data);
				swapOccured = true;
			}
			

		//	}
		}
	}
	}
	


