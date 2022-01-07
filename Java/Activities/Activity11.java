package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		Map<Integer,String> colors= new HashMap<>();
		colors.put(1, "Red");
		colors.put(5, "Yellow");
		colors.put(2, "Red");
		colors.put(4, "Blue");
		colors.put(3, "Purple");
		System.out.println(colors);
		colors.remove(4);
		System.out.println("After removing one of the color : " + colors);
		System.out.println("Checking whether green colour exist as value or not..: "+ colors.containsValue("Green"));
		
	}	

}
