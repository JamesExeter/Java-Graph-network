/**
 * This class is used to test the methods and functionality of the FileReader class
 * It reads in a list of profiles from a text file and inserts them into a new BST
 * @author James Brock
 */

public class FileReaderMain {
    public static void main(String[] args){
        //Creates a new BST and populates it with the profiles in the text file
        final String FILE_PATH = "./src/data/Profiles.txt";
        BST newTree = FileReader.readProfiles(FILE_PATH);

        //Manually test the inputted data and making sure it is correctly placed in the BST
        System.out.println("Printing the BST alphabetically");
        newTree.printAlphabetical();
    }
}
