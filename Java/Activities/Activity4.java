package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		int[] Array = {7,3,5,6,1,3,5,7,4,2};
		sortArray(Array);
		//System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(Array));

	}

	public static void sortArray(int[] array) {
		int i;
		
		for (i=1; i<array.length; i++) {
			 int key = array[i]; //3
	            int j = i - 1; //0
	            
	            while (j >= 0 && key < array[j]) {
	                array[j + 1] = array[j];
	                --j;
	            }
	            array[j + 1] = key;			
		}
	}

}
