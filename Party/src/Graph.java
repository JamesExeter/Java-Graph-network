import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

/**
 * This method is used to populate the friends list of every profile that is
 * provided within a text file and also creates a BST of people that are invited
 * to a party. This BST is constructed from a list of profiles and also adds all
 * of the friends of those in the original invitation list
 * @author James Brock
 */

public class Graph {
    //BST of the party list
    private BST partyBST;

    /**
     * The constructor of graph creates a scanner variable from the readFriends method
     * and then uses this scanner to call the readFriendLine method with the BST
     * @param filename The filename of the friendslist file for each profile
     * @param tree An existing BST that contains all of the people that exist in the
     *             friends file, if a person is highlighted in the friends list that
     *             does not exists in the BST then then construction of the graph ends
     */
    public Graph(String filename, BST tree){
        Scanner in = readFriends(filename);
        readFriendLine(in, tree);
    }

    /**
     * This method is used to create a scanner variable that contains the contents
     * of all the friend relations between each profile in the BST
     * @param filename The name of the friends file
     * @return A scanner that contains all of the data in the "filename" file
     */
    private Scanner readFriends(String filename){
        //create new file variable
        File fileIn = new File(filename);
        Scanner in = null;
        //try catch statement to open the file, raises a FileNotFoundException
        //if the file does not exist and informs the user
        try{
            in = new Scanner(fileIn);
        } catch(FileNotFoundException e){
            System.out.println("Could not open " + filename);
            System.exit(0);
        }
        return in;
    }

    /**
     * This method reads in the friend relations of each profile, checks that each person
     * queried exists in the provided BST, if they do, the method fillFriends is called
     * @param in The scanner variable that contains the friendship relations of each user
     * @param tree The BST that holds all of the profiles that need friend lists updated
     */
    private void readFriendLine(Scanner in, BST tree){
        //Names of the two related profiles
        String name1, name2;
        String[] friends = new String[2];
        //Parse each line of the scanner
        while(in.hasNextLine()){
            //create a new scanner variable for each line
            String line = in.nextLine();
            Scanner friendLine = new Scanner(line);
            while(friendLine.hasNext()){
                //Change the delimiter to a comma to fit the file format
                friendLine.useDelimiter(",");

                //for each name, get the name from the scanner, check it exists
                //in the BST and then set the first element of the friends array to the first name
                name1 = friendLine.next();
                profileExists(name1, tree);
                friends[0] = name1;

                //Do the same for the second as with the first
                name2 = friendLine.next();
                profileExists(name2, tree);
                friends[1] = name2;

                //call the fillFriends method with the friends array and the BST
                fillFriends(friends, tree);
            }
            friendLine.close();
        }
        in.close();
    }

    /**
     * This profile checks whether a raised profile in the BST exists, throws a
     * NoSuchElementException if it doesn't and exits the program, continues if not
     * @param name The name of the profile that is being queried
     * @param tree The BST that is being searched through
     * @throws NoSuchElementException If the profile does not exist in the tree, throw an error
     */
    private void profileExists(String name, BST tree) throws NoSuchElementException {
        //Gets an array of profiles from the BST
        ArrayList<Profile> profileList = tree.getProfiles();
        boolean isFound = false;
        //For each profile in the tree, get the name and compare it to the name being searched for
        for (Profile p : profileList) {
            if (p.getMyName().equals(name)) {
                //If it is found we can stop searching as the condition is true
                isFound = true;
                break;
            }
        }
        //Throw an error if it is not found
        if (!isFound) {
            throw new NoSuchElementException("A node has been raised that does not exist");
        }
    }

    /**
     * Updates the friend lists of two people by setting each other as friends
     * @param friends The two profiles that share a friendship with each other
     * @param tree The BST that holds the profiles that are to be updated
     */
    private void fillFriends(String[] friends, BST tree){
        //Create a profile list that can be iterated over
        ArrayList<Profile> profileList = tree.getProfiles();
        //find the index at which the two profiles occur in the list
        //it is easy to do since the profiles are in an alphabetical ordering
        int index1 = getIndexInList(friends[0], tree);
        int index2 = getIndexInList(friends[1], tree);

        //If the two users don't share a friendship with each other already
        //Then in turn, the other is added to the other's friend list
        //E.g. if A was friends with B, then that means B is friends with A
        if(!checkIfFriends(index1, index2, tree)){
            profileList.get(index1).addFriend(profileList.get(index2));
            profileList.get(index2).addFriend(profileList.get(index1));
        }
    }

    /**
     * This method returns the index at which a searched for profile is within
     * the BST in the form of an alphabetical array list
     * @param name The name of the profile being searched for, can assume each profile name is unique
     * @param tree The BST being searched through which will provide an array list
     * @return The index at which the profile being searched for is, as the profile
     * is already confirmed to exist, no error clause is needed
     */
    private int getIndexInList(String name, BST tree){
        //Create array list
        ArrayList<Profile> profileList = tree.getProfiles();
        int index = 0;
        //Iterate through the list, break the loop when the index is found
        for(int i = 0; i < profileList.size(); i++){
            if(profileList.get(i).getMyName().equals(name)){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Confirms whether two people are already on each other's friend list, this is used
     * to avoid any duplicate data affecting the friend lists of profiles
     * @param index1 The index at which the first profile is within an array list of the BST
     * @param index2 The index at which the second profile is within an array list of the BST
     * @param tree The provided BST that is being used to create a profile list
     * @return
     */
    private boolean checkIfFriends(int index1, int index2, BST tree){
        //create an array list of profiles
        ArrayList<Profile> profileList = tree.getProfiles();
        //Check if the first profile has the second added already
        //no need to check the second profile
        Profile profileToEdit = profileList.get(index1);
        //get the length of friend list of the first profile, used to iterate over
        //in the for loop
        int lengthOfList = profileToEdit.numOfFriends();
        boolean areFriends = false;
        for(int i = 0; i < lengthOfList - 1; i++){
            //If any of the profiles in the first person's friend list match the
            //the current profile being iterated over, are friends is true and the loop is exited
            if(profileToEdit.getFriend(i) == profileList.get(index2)){
                areFriends = true;
                break;
            }
        }
        return areFriends;
    }

    /**
     * Calculates a BST of all of the people that can come to a party
     * Those who can come are those who are on the invites list and by extension
     * all of the people that are friends with the original invitees
     * @param invitations The list of people (Profiles) that are invited to the party
     * @return A BST of all the people that can come to a party
     */
    public BST bigParty(ArrayList<Profile> invitations){
        //create an empty BST
        partyBST = new BST();
        //loop through every profile in the invites list
        for(Profile i : invitations){
            //get their name
            String initialName = i.getMyName();
            //if they are not already in the BST, add them to it
            if(!partyBST.findNode(initialName)){
                partyBST.insertProfile(i);
            }
            //for each person get their number of friends
            int numFriends = i.numOfFriends();
            for(int j = 0; j < numFriends; j++){
                //for every friend, check if they are in the BST
                //if they aren't, add them to the BST
                Profile toAdd = i.getFriend(j);
                String name = toAdd.getMyName();
                if(!partyBST.findNode(name)){
                    partyBST.insertProfile(toAdd);
                }
            }
        }
        return partyBST;
    }
}
