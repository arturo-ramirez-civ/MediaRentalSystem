/*File: MovieDVD.java
* Author: Arturo Ramirez
* Updated: March 8, 2021
* Purpose: Movie class
*/


public class MovieDVD extends Media {
	
	//Attributes
	private double size;
	
	//Constructor
	public MovieDVD (int id, String title, int year, boolean isAvailable, double size) {
		super(id, title, year, isAvailable);
		this.size = size;
	}
	
    public MovieDVD(String line) {
        super(line);
        size = Double.parseDouble(line.substring(line.indexOf("<size>") + 4, line.indexOf("</size>")));
    }
	
	//Get Methods
	public double getSize() {
		return size;
	}
	
	//Set Methods
	public void setSize(double size) {
		this.size = size;
	}
	
	//inherits parent's Calculations
	
	//Display
	@Override
	public String toString() {
		
        return "<MovieDVD>"
        + "<id>" + this.getId() + "</id>"
        + "<title>" + this.getTitle() + "</title>"
        + "<year>" + this.getYear() + "</year>"
        + "<size>" + size + "</size>"
        + "</MovieDVD>";
	}
	
}//End of Class
