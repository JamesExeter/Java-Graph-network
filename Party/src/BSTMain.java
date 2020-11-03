import java.util.ArrayList;

/**
 * This class is used to manually test the BST class
 * Nodes are hard coded into the BST and are then inserted
 * The children nodes are then tested. The root node needs to be accessed
 * as that is what all the other BSTNodes are dependent on
 * @author James Brock
 */

public class BSTMain {
    public static void main(String[] args){
        BST newTree = new BST();
        Profile James = new Profile("James", "Swansea", "UK", "British", 23, 12, 1998, new String[]{"Guitar", "Reading", "Running"});
        Profile Bob = new Profile("Bob", "Bath", "UK", "French", 7, 1, 2001, new String[]{"Writing", "Dog walking", "Cycling"});
        Profile Kate = new Profile("Kate", "Melbourne", "Australia", "Australian", 21, 7, 1995, new String[]{"Yoga", "Raves", "Swimming"});
        Profile Saddam = new Profile("Saddam", "Dubai", "UAE", "Arab", 17, 11, 1972, new String[]{"Oil", "Aquariums"});
        Profile Jack = new Profile("Jack", "Paris", "France", "French", 4, 2, 1992, new String[]{"Drums", "Climbing", "Photography"});
        Profile Ethan = new Profile("Ethan", "Hanover", "America", "American", 27, 8, 1978,new String[]{"Annoyance", "Eating", "Shooting"});

        newTree.insertProfile(James);
        newTree.insertProfile(Bob);
        newTree.insertProfile(Kate);
        newTree.insertProfile(Saddam);
        newTree.insertProfile(Jack);
        newTree.insertProfile(Ethan);

        ArrayList<Profile> newProfilesList = newTree.getProfiles();
        System.out.println("Printing the BST");
        for(Profile p : newProfilesList){
            System.out.println(p.getMyName());
        }
    }
}