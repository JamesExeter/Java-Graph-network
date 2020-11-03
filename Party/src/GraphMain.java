import java.util.ArrayList;

/**
 * This class is used to used to test the Graph class by ensuring that any
 * friendship between profiles in the created BST are created properly and
 * that the bigParty method works as intended with my provided data
 * @author James Brock
 */

public class GraphMain {
    public static void main(String[] args){
        //Creates a new tree to be used for the Graph class
        BST newTree = FileReader.readProfiles("./src/data/Profiles.txt");
        final String FRIENDS_FILE = "./src/data/Friends.txt";

        //Creates a new graph with the given BST and friendsFile
        //Create an invite list
        ArrayList<Profile> invites = new ArrayList<>();

        //Fill sll the friends list of all profiles
        Graph newGraph = new Graph(FRIENDS_FILE, newTree);

        ArrayList<Profile> testList = newTree.getProfiles();

        //Testing that a friendlist has friends
        System.out.println();
        Profile bob = testList.get(1);
        System.out.println(bob);
        System.out.println(bob.getFriend(0).getMyName());
        System.out.println(bob.getFriend(1).getMyName());
        System.out.println(bob.getFriend(2).getMyName());

        Profile alex = testList.get(0);
        invites.add(alex);
        Profile james = testList.get(3);
        invites.add(james);
        //Testing that initially added people don't appear twice
        invites.add(bob);
        invites.add(bob);

        System.out.println();
        for(Profile p : invites){
            System.out.println(p.getMyName());
        }

        //Although bob appears twice in the invites list, he does not
        //appear a second time in the list showing show that can come to the party

        //Test the party list
        System.out.println("\nThose that can come to the party: ");
        BST partyList = newGraph.bigParty(invites);
        partyList.printAlphabetical();
    }
}
