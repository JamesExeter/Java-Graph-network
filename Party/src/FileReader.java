import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
import java.util.ArrayList;

/**
 * This class is used to read in profiles from a text file into a binary search tree
 * The profiles are all stored as nodes and are arranged alphabetically with respect to each other
 * @author James Brock
 */

public class FileReader {

    /**
     * From a scanner, this method creates a profile for every line in the scanner
     * Then every profile is added to an array list and every profile in the array
     * list is then inserted into the BST using the insert method form the BST class
     * @param in The scanner containing the data on the profiles
     * @return The BST that is filled with nodes containing the profiles
     * in the scanner
     */
    private static BST parseProfiles(Scanner in){
        //create an empty BST and profile list
        ArrayList<Profile> profileList = new ArrayList<>();
        BST newTree = new BST();
        //while there is another line in the scanner
        while(in.hasNextLine()){
            //create a new scanner variable that parses an individual line
            String line = in.nextLine();
            Scanner lineScan = new Scanner(line);
            //while there is another token on the line
            while(lineScan.hasNext()){
                //create a profile from the contents of the line
                Profile newProfile = createProfile(lineScan);
                //add to the profile list
                profileList.add(newProfile);
            }
            lineScan.close();
        }
        in.close();

        //for every profile in the profile list insert the profile into the BST
        for(Profile p : profileList){
            newTree.insertProfile(p);
        }
        //return the newly constructed BST
        return newTree;
    }

    /**
     * Takes in a filename to be opened and creates a scanner variable containing
     * the profiles to be created and added to a BST
     * @param filename the name of the file to be opened
     * @return A BST filled with nodes that contain the profiles within the text file
     */
    public static BST readProfiles(String filename){
        //initialise scanner and new file
        File fileIn = new File(filename);
        Scanner in = null;

        //try to set the scanner to the contents of the file
        //catch an error if the file cannot be found and exits the program gracefully
        try{
            in = new Scanner(fileIn);
        } catch(FileNotFoundException e){
            System.out.println("Could not open " + filename);
            System.exit(0);
        }
        //returns a reference to the parseProfiles method which in turn itself
        //returns a BST
        return FileReader.parseProfiles(in);
    }

    /**
     * Creates a new profile based off of the information from a line in the scanner
     * @param in A single line scanner that contains the information on a profile
     * @return A newly created profile from the given information
     */
    public static Profile createProfile(Scanner in){
        //initialise variables outside of the try catch statement
        int day = 0, month = 0, year = 0;
        String name = "", town = "", country = "", nationality = "";
        //create an array list interests are to be added to that are then converted
        //later back into a regular array
        ArrayList<String> interestsArrayList = new ArrayList<>();
        try{
            //set the delimiter to a comma to start with
            in.useDelimiter(",");
            name = in.next();
            day = in.nextInt();
            month = in.nextInt();
            year = in.nextInt();
            town = in.next();
            country = in.next();
            nationality = in.next();
            interestsArrayList.add(in.next());
            //change the delimiter to a semicolon for the interests
            in.useDelimiter(";");
            //while loop while there is still information on the line as there can
            //be an indefinite number of interests
            while(in.hasNext()){
                interestsArrayList.add(in.next());
            }
        } catch(InputMismatchException e){
            //If the wrong variable is used to store information, gracefully exit the program
            System.out.println("Input mismatch exception");
            System.exit(0);
        }

        //the array list in the scanner was only saved as a single element
        //e.g. the scanner produced: ["Diving;Climbing"] instead of ["Diving", "Climbing"]
        String element = interestsArrayList.get(0);
        //break the single element into n arguments and store in an array
        String[] interests = element.split(";");
        return new Profile(name, town, country, nationality, day, month, year, interests);
    }
}
