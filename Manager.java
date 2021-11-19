/*File: Manager.java
* Author: Arturo Ramirez
* Updated: March 8, 2021
* Purpose: Functionality class
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    
    // attribute
    private ArrayList<Media> mediaList;
    
    // default constructor
    public Manager() {
       
        // initialize empty pets list
        mediaList = new ArrayList<Media>();
    }
    
    // load all media files from directory; assumes file name convention starts with media type Ebook, Movies, and Musics followed by id
    // If directory is not found, it will throw exception
    public Manager(String directory) throws FileNotFoundException {
       
        // initialize empty media list
        mediaList = new ArrayList<Media>();
       
        // Create a File object for directory
        File directoryPath = new File(directory);
       
        // Get list of all files and directories
        File fileslist[] = directoryPath.listFiles();
       
        if (fileslist == null)
            throw new FileNotFoundException("Could not load, no such directory");
       
        // declare local variables
        Media media = null;
        String line = null;
        Scanner scan = null;
       
        // Process each Media file
        for (File file : fileslist) {
           
            // parse files whose filename starts with "EBook", "MovieDVD" or "MusicCD"
            if (file.getName().contains("EBook") ||file.getName().contains("MovieDVD") || file.getName().contains("MusicCD") ) {

                // open and read line (assumes whole object is stored on single line)
                scan = new Scanner(file);
                // assumes the file is not empty
                line = scan.nextLine();   
               
                // if EBook object than call EBook constructor
                if (file.getName().contains("EBook")) 
                    media = new EBook(line);       
                
                // if MovieDVD object than call Dog constructor
                if (file.getName().contains("MovieDVD")) 
                    media = new MovieDVD(line);  
                
                // if MusicCD object than call MusicCD constructor
                if (file.getName().contains("MusicCD")) 
                    media = new MusicCD(line);  
               
                // add object to mediaList attribute
                mediaList.add(media);
            }
        }
    }
    
    // creates (or overwrites) a file for each Media object in media attribute in the given directory
    public void createMediaFiles(String directory) throws IOException {
       
        PrintWriter out = null;
       
        // for all media objects create files using media type and id value as filename
        for (int i=0; i < mediaList.size(); i++) {
            
        	String filename = directory + "/" + mediaList.get(i).getClass().getSimpleName() + "-" + mediaList.get(i).getId() + ".txt";
            // create/overwrite file
            out = new PrintWriter(new FileWriter(filename));  
            // write the media's data
            out.println(mediaList.get(i).toString());  
            // flush all the data to the file
            out.flush();     
            // close the stream
            out.close();    
        }
}
    
    // display all stored media on console
    public void displayAllMedia() {
       
        // for all media objects display the xml tag data
        for (int i=0; i < mediaList.size(); i++) {
            System.out.println(mediaList.get(i).toString());
        }
    }
    
    // add media object
    public void addMedia(Media media) {
        mediaList.add(media);
    }
}
