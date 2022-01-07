package activities;

public class Activity12 {

	public static void main(String[] args) {
		
		Addable ad1 = (num1,num2)->(num1+num2); // without body
		System.out.println("The sum of num1 and num2 is "+ ad1.add(10, 100));
		
		//with body
		Addable ad2 = (int num1, int num2) ->{ 
			return num1+ num2;			
					};
		System.out.println("The sum of num1 and num2 is "+ ad2.add(10, 100));

	}

}
