/*File: MediaRentalSystem.java
* Author: Arturo Ramirez
* Updated: March 8, 2021
* Purpose: user facing class
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MediaRentalSystem {
	
	//class instances 
	Manager mgt = new Manager();
	
    // Method to display menu
    public void displayMenu() {
        
        System.out.println("\n Welcome to Media Rental System");
        System.out.println("1: Load Media objects...");
        System.out.println("2: Find Media Objects...");
        System.out.println("3: Rent Media objects...");
        System.out.println("9: Quit");
    }//End of method
    
    // Method to handle user's selection
    public void processChoice( int c){
        
        switch(c) {
            
            case 1: loadMedia();
                break;
            case 2: findMedia();
                break;
            case 3: rentMedia();
                break;
            case 9: System.out.println("\nThank you for using the program. Goodbye!");
                break;
            default: System.out.println("\nError. Please select from menu.");
         
        }//End of switch
        
    }//End of method
    
    
    private void loadMedia() {
    	//Reads input
    	Scanner sc = new Scanner(System.in);
    	
    	//enter directory path
    	System.out.println("Enter path(directory) where to load from: C");
    	String userInput;
    	userInput = sc.next();
    	try {
			mgt.createMediaFiles(userInput);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	
        try {
            // create media files in directory "C:/tmp-umuc"
            mgt.createMediaFiles("C:/tmp-umuc");
        } catch (IOException e) {
            e.printStackTrace();  // just print trace if there are issues
        }
        sc.close();
    }
    
    private void findMedia() {
    	
    	//Reads input
    	Scanner sc = new Scanner(System.in);
    	
    	//enter directory path
    	System.out.println("Enter the title");
    	String userInput;
    	userInput = sc.next();
    	
    	//Searches for file
        File directoryPath = new File(userInput);
    	for (File f : directoryPath.listFiles()) {
    		System.out.println(f.getName());
    	}	
    	sc.close();
    }	

    private void rentMedia() {
    	
    }

    
    // Main method
    public static void main(String[] args){
    	  
    	//new instance 
    	MediaRentalSystem run = new MediaRentalSystem();
    	
        Scanner sc = new Scanner(System.in);
        int selection = 0;
        
        do {
            run.displayMenu();
            
            System.out.println("\nEnter your selection : ");
            selection = sc.nextInt();
            
            run.processChoice(selection);
        } while (selection != 9);
        
        sc.close();
        
    }// End of Main method
    
}//End of MediaRentalSystem Class

