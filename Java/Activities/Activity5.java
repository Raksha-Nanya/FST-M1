package activities;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String title = "ABCXYZ";
		
		Book newNovel = new MyBook();
		newNovel.setTitle(title);
		System.out.println("The title of the book is "+  newNovel.getTitle()+ ".");
		
	}
	
}

 abstract class Book {

	String title;
	public abstract void setTitle(String S);
	
	public String getTitle() {		
		return title;		
	}
}

class MyBook extends Book {

	@Override
	public void setTitle(String S) {
		title = S;
		
	}
	
}
