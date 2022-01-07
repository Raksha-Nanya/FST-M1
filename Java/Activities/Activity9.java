package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

	public static void main(String[] args) {
		List<String> myList= new ArrayList<String>();
		myList.add("Marvel");
		myList.add("Captain");
		myList.add("Spiderman");
		myList.add("Ant-man");
		myList.add("IronMan");
		
		for (String i: myList) {
		    System.out.println(i);
		}
		System.out.println("The 3rd name in the array List is :"+myList.get(2));
		System.out.println("Return true if Captain exist in the Array List else print false :"+myList.contains("Captain"));
		System.out.println("The Size of the Array is : "+myList.size());
		System.out.println("Removing the name from the array : "+myList.remove(1));
		System.out.println("The Size of the Array is : "+myList.size());
	}

}
