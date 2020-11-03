/**
 * This class is used to test the printAlphabetical() method of the BST class
 * @author James Brock
 */

public class AlphaMain {
    public static void main(String[] args){
        //A new BST is created out of the profiles stored in the profiles file
        BST newTree = FileReader.readProfiles("./src/data/Profiles.txt");
        //The tree is traversed and the name are printed in an alphabetical order
        newTree.printAlphabetical();
    }
}