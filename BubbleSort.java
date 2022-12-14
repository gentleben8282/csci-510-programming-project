import java.util.ArrayList;
import java.util.Scanner;

/*
 * CSCI 510: Programming Project #2: Bubble Sort
 * References: https://www.geeksforgeeks.org/java-program-for-bubble-sort/
 * 			   https://www.geeksforgeeks.org/arraylist-in-java/
 *             https://www.tutorialspoint.com/java/java_documentation.htm
 * 			   https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 * 			   https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
 * 
 * @author: Ben Corriette
 * @version: 1.0
 * @since: 2022-12-13
 */
public class BubbleSort
{
	/**
     * Performs the bubble sort of the array.
     * 
	 * @param arr Represents an array of integers
     * @return Nothing
	 */
	void bubbleSort(Integer arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (arr[j] < arr[j+1])
				{
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
	}

	/**
     * Prints the array.
     * 
	 * @param arr Represents an array of integers
     * @return Nothing
	 */
	void printArray(Integer arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/**
	 * Processes the user input
	 * 
	 * @return Nothing
	 */
	private static void processUserInput(ArrayList<Integer> arList) {
		System.out.println("Please enter an array of integers delimited by a space; enter 9999 to signify the end of the array. Example: 1 2 3 9999");
		Scanner sc = new Scanner(System.in);
		String inputNumberText = "";
		while (!inputNumberText.equals("9999") && sc.hasNext()) { // REQ: Handles completely empty input set
			inputNumberText = sc.next();
			System.out.println("Input number: " + inputNumberText);
			if (inputNumberText.equals("9999")) {
				break; // REQ: Stops adding integers after 9999
			}
			else {
				arList.add(Integer.parseInt(inputNumberText));
			}
		}
		Integer[] arr = new Integer[arList.size()];
		arr = arList.toArray(arr);
		BubbleSort ob = new BubbleSort();
		ob.bubbleSort(arr);
		
		System.out.println("Would you like to enter more integers to sort? Type Y to enter more integers, or N to print out the sorted integers.");
		sc.nextLine().trim();
		String userContinueConfirmation = sc.nextLine().trim();

		if (userContinueConfirmation.equals("Y")) {
			processUserInput(arList);
		} else if (userContinueConfirmation.equals("N")) {
			System.out.println("Sorted array");
			ob.printArray(arr);
		}
		sc.close(); 
	}

	/**
     * Entry point of the program.
     * 
	 * @param args Represents an array of string arguments
     * @return Nothing
	 * @throws ArrayStoreException if the runtime type of the specified array is not a supertype of the runtime type of every element in this list
	 * @throws NumberFormatException if the string does not contain a parsable integer
	 * @throws NullPointerException if the specified array is null
	 * @throws Exception if there is an error that is not caught by more specific exception handlers
	 */
	public static void main(String args[])
	{
		try {
			ArrayList<Integer> aList = new ArrayList<Integer>();
			processUserInput(aList);	
		} catch (ArrayStoreException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

