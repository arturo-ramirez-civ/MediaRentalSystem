/*File: MusicCD.java
* Author: Arturo Ramirez
* Updated: March 8, 2021
* Purpose:  Music class
*/

import java.util.Calendar;

public class MusicCD extends Media {
	
	//Attributes
	private int length;
	
	//Constructor
	public MusicCD(int id, String title, int year, boolean isAvailable, int length) {
		super(id, title, year, isAvailable);
		this.length = length;
	}
	
    public MusicCD(String line) {
        super(line);
        length = Integer.parseInt(line.substring(line.indexOf("<length>") + 4, line.indexOf("</length>")));
    }
	
	//Get method
	public int getLength() {
		return length;
	}
	
	//Set method
	public void setLength(int length) {
		this.length = length;
	}
	
	//Override parent's calculations
	@Override
	public double calculateRentalFee() {
		
		double fee = length* 0.02;
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if(this.getYear()==currYear)
			fee += 1;
		
		return fee;	
	}
	
	//Display
	@Override
	public String toString() {
		
        return "<MusicCD>"
        + "<id>" + this.getId() + "</id>"
        + "<title>" + this.getTitle() + "</title>"
        + "<year>" + this.getYear() + "</year>"
        + "<length>" + length + "</length>"
        + "</MusicCD>";
	}

}// End of Class
