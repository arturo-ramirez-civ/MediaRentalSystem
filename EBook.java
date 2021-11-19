/*File: EBook.java
* Author: Arturo Ramirez
* Updated: March 8, 2021
* Purpose:  
*/


import java.util.Calendar;

public class EBook extends Media {
	
	//Attributes
	private int numChapters;
	
	//constructor
	public EBook(int id, String title, int year, boolean isAvailable, int chapters) {
		super(id, title, year, isAvailable);
		numChapters = chapters;
	}
	
    public EBook(String line) {
        super(line);
        numChapters = Integer.parseInt(line.substring(line.indexOf("<numChapters>") + 4, line.indexOf("</numChapters>")));
    }
	
	//Get Methods
	public int numChapters() {
		return numChapters;
	}
	
	//Set Methods
	public void getNumChapters(int numChapters) {
		this.numChapters = numChapters;
	}
	
	//overrides parent's calculation
	@Override
	public double calculateRentalFee() {
		double fee = numChapters * 0.10;
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if (this.getYear()==currYear)
			fee +=1;
		return fee;
	}
	
	public String toString() {
		
        return "<EBook>"
        + "<id>" + this.getId() + "</id>"
        + "<title>" + this.getTitle() + "</title>"
        + "<year>" + this.getYear() + "</year>"
        + "<numChapters>" + numChapters + "</numChapters>"
        + "</EBook>";
	}

}//End of Class
