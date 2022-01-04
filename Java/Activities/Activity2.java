package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initializing an Array		
		int[] Array1 =  {10,77,10,54,-11,10};
		
		Calculate(Array1);
		
		System.out.println(Calculate(Array1));
	}
	
	
	public static boolean Calculate(int[] array1) {
		
		// TODO Auto-generated method stub
		int i=0; int temp=0;
		for (i=0;i<6;i++) {
			
			if(array1[i]==10) {
				 temp = array1[i]+ temp;
			}			
			
		}
		
		if (temp ==30) {
			return true;
		}
		
		
return false;

	}
}


	
