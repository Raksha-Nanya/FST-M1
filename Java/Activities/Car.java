package activities;

public class Car {
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	public Car() {
		tyres = 4; doors=4;
	}
	
	public void displayCharacteristics() 
	{
		
		System.out.println("The Color of the car is "+color );
		System.out.println("The mode of the transmission is  "+transmission );
		System.out.println("The year of the manufacturing is "+make );
		System.out.println("The total number of tyres are "+tyres );
		System.out.println("The number of doors in the car is  "+doors );
	}
	
	public void accelarate() 
	{
		System.out.println("Car is moving forward.");
		
	}
	
	public void brake() 
	{
		System.out.println("Car has stopped.");
	}

}



