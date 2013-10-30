package array_sort_lowestVal;

public class lowest_value {

	public static void main(String[] args) {
		int i;
		int[] array = new int[10];

		System.out.print("your array is: {");
		for (i = 0; i < array.length; i++) {
			
			array[i] = (int) ((Math.random() * 1000) - 500);
			if (!(i == array.length - 1)) {
				System.out.print(array[i] + ",");
			} else {
				System.out.println(array[i]+"}");
			}
		}
		System.out.println("the lowest value in the array is:"+lowest(array));
	}

	private static int lowest(int[] array) {
		array = sort(array);
		return( (array[0] < array[array.length-1]) ? array[0] : array[array.length-1]);
		
	}

	// yeah i know its is slow but it is not what i am focused on
	private static int[] sort(int[] array) {
		int sorted = 1;
		int temp;
		while (!(sorted == 0)) {
			sorted = 0;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i+1]) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					sorted++;
				}
			}

		}
		return array;
	}

}
