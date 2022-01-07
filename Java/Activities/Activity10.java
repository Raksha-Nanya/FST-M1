package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		Set<Integer> hs = new HashSet<>();
		hs.add(2);
		hs.add(2);
		hs.add(34);
		hs.add(54);
		hs.add(30);
		hs.add(34);
		System.out.println(hs);
		System.out.println("The Size of the hashset is : "+ hs.size());
		System.out.println("Removing an element :"+ hs.remove(2));
		System.out.println("Removing an element which is not in hash set :"+ hs.remove(2));
		

	}

}
