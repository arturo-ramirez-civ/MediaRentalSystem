/*File: Media.java
* Author: Arturo Ramirez
* Updated: March 8, 2021
* Purpose: Parent class
*/


public class Media {
	
	//Attributes
	private int id;
	private String title;
	private int year;
	private boolean isAvailable;
	
	//constructor
	public Media (int id, String title, int year, boolean isAvailable) {
		
		this.id = id;
		this.title = title;
		this.year = year;
		this.isAvailable = true;
	}
	
    // constructor to parse string with xml tags for its values
    public Media(String line) {
        id = Integer.parseInt(line.substring(line.indexOf("<id>") + 4, line.indexOf("</id>")));
        title = line.substring(line.indexOf("<title>") + 6, line.indexOf("</title>"));
        year = Integer.parseInt(line.substring(line.indexOf("<year>") + 4, line.indexOf("</year>")));
        isAvailable = Boolean.parseBoolean(line.substring(line.indexOf("<true>")) + 2);
    }
	
	//Get methods
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}
	
	//Set Methods
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	//calculate rental fee
	public double calculateRentalFee() {
		return 3.50;
	}
	
	public String toString() {
		
        return "<Media>"
        + "<id>" + this.getId() + "</id>"
        + "<title>" + this.getTitle() + "</title>"
        + "<year>" + this.getYear() + "</year>"
        + "</Media>";
	}
	
}//End of Class
