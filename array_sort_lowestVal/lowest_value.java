package array_sort_lowestVal;

import java.util.Random;

public class lowest_value {

	public static void main(String[] args) {

		int i; // Iterator
		int[] array = new int[10];// creates in array of size 10
		
		// random generator (btw i like this)
		final Random r = new Random(System.currentTimeMillis());

		// fills the array
		for (i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1000) - 500;
		}

		// prints array with descriptions
		System.out.print("your array is: {");
		for (i = 0; i < array.length; i++) {
			if (!(i == array.length - 1)) {
				System.out.print(array[i] + ",");
			} else {
				System.out.println(array[i] + "}");
			}
		}

		// prints out lowest value in array
		System.out.println("the lowest value in the array is:" + lowest(array));
	}

	
	
	//makes sure the array is sorted and returns the lowest value;
	private static int lowest(int[] array) {
		array = bubbleSort(array);
		return ((array[0] < array[array.length - 1]) ? array[0]
				: array[array.length - 1]);

	}

	//bubble sort for int[] lowest to highest
	private static int[] bubbleSort(int[] array) {
		int sorted = 1;
		int temp;
		while (!(sorted == 0)) {
			sorted = 0;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted++;
				}
			}

		}
		return array;
	}

}
