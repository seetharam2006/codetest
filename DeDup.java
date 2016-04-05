
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/*
 * Submitted by:  Seetharam Reddy Kothi
 * Consulting Firm: 
 * Contact Info:  732-781-6645 
 */

/*
 * This class has three different functions to eliminate duplicates for a given integer array and return integer array which has unique integers.
 */
public class DeDup implements Cloneable {

	public static int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16,
			19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16,
			3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/**
	 * This method removes the duplicate integers and maintain insertion order.
	 * It uses Java Collection Framework class called LinkedHashSet
	 * 
	 * @param integers
	 *            - This is the input integer array
	 * @return int[] returns integer array which has unique elements.
	 */
	public int[] removeDuplicates(int[] integers) {
		Set<Integer> uniqueInts = new LinkedHashSet<Integer>();

		for (int integer : integers) {

			uniqueInts.add(integer);
		}
		int[] uniqueIntegerArray = new int[uniqueInts.size()];

		int i = 0;
		for (int integer : uniqueInts) {
			uniqueIntegerArray[i] = integer;
			i++;

		}
		return uniqueIntegerArray;
	}

	/**
	 * This method to used to add unique integers to LinkedHashMap object.
	 * LinkedHashMap helps to maintain insertion order.
	 * 
	 * @param integers
	 *            - This is the input integer array
	 * @return int[] returns integer array which has unique elements.
	 */
	public int[] deleteDuplicates(int[] integers) {

		Map<Integer, Integer> myMap = new LinkedHashMap<Integer, Integer>();

		for (int integer : integers) {
			if (myMap.get(integer) == null)
				myMap.put(integer, integer);
		}

		int[] uniqueIntegerArray = new int[myMap.size()];

		int i = 0;
		for (int integer : myMap.keySet()) {
			uniqueIntegerArray[i] = integer;
			i++;

		}
		return uniqueIntegerArray;

	}

	/**
	 * This method sort the elements in natural order and starts to find out
	 * duplicates and removes it. New array will be created with unique elements. 
	 * 
	 * @param integers
	 *            - This is the input integer array
	 * @return int[] returns integer array which has unique elements.
	 */
	public int[] eliminateDuplicates(int[] integers) {
		Arrays.sort(integers);
		int j = 0;
		int i = 1;
		// return if the array length is less than 2
		if (integers.length < 2) {
			return integers;
		}
		while (i < integers.length) {
			if (integers[i] == integers[j]) {
				i++;
			} else {
				integers[++j] = integers[i++];
			}
		}
		int[] uniqueIntegerArray = new int[j + 1];
		for (int k = 0; k < uniqueIntegerArray.length; k++) {
			uniqueIntegerArray[k] = integers[k];
		}

		return uniqueIntegerArray;
	}

	/**
	 * This is method prints all elements for a given array
	 * 
	 * @param uniqueIntegers
	 *            It holds set of integers
	 */
	public void uniqueIntegerArray(int[] uniqueIntegers) {

		for (int integer : uniqueIntegers) {
			System.out.println(integer);
		}

	}

	public static void main(String[] args) {

		int[] uniqueIntegerArray;

		DeDup delDup = new DeDup();

		/*
		 * Solution 1 : This most optimized approach to remove duplicates and
		 * maintains Original Order using Java Collection Framework class
		 * LinkedHashSet
		 */

		uniqueIntegerArray = delDup.removeDuplicates(randomIntegers);
		delDup.uniqueIntegerArray(uniqueIntegerArray);

		System.out.println("##################################################");
		/*
		 * Solution 2 : This approach uses Map implementation and maintains
		 * Original Order. LinkedHashMap used to maintain Original Order
		 */
		uniqueIntegerArray = delDup.deleteDuplicates(randomIntegers);
		delDup.uniqueIntegerArray(uniqueIntegerArray);

		System.out.println("##################################################");
		/*
		 * Solution 3 : This approach do not use Collection frame work and will
		 * not maintain Original Order
		 */
		uniqueIntegerArray = delDup.eliminateDuplicates(randomIntegers);
		delDup.uniqueIntegerArray(uniqueIntegerArray);

	}
}