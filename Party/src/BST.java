import java.util.ArrayList;

/**
 * A class that implements a binary search tree. The only attribute of the class
 * is the BSTNode root which is used within a recursive method call so that all
 * other nodes within the tree can be accessed through recursive calls on
 * getLeft() and getRight() methods.
 * @author James Brock
 */

public class BST {
    //The root node of the binary search tree
    private BSTNode root;

    /**
     * Constructs an empty binary search tree
     */
    public BST(){}

    /**
     * This method is used to insert a new given profile into the BST
     * @param p A provided profile that is to be contained as a BSTNode's data
     */
    public void insertProfile(Profile p){
        //A new BSTNode is constructed from the given profile p
        BSTNode newNode = new BSTNode(p);
        //If there is no root node, the BST is empty and the newest node becomes the root
        if(root == null){
            this.root = newNode;
        } else {
            //The recursive insert method is called with the given profile and the root BSTNode
            insert(root, p);
        }
    }

    /**
     * Recursively called so that a new profile can be inserted into the BST
     * If the child nodes of any nodes are not equal to null, the method is
     * recursively called until an appropriate free child node is found in which
     * the new node can be created in
     * @param rootNode The root node of the binary search tree which recursively
     *                 iterates to become the next appropriate child node, this is
     *                 a result of each subsequent root node calling a getLeft() or
     *                 getRight() method.
     * @param p The profile that contains the data to be stored in the newly created
     *          BSTNode
     */
    private void insert(BSTNode rootNode, Profile p){
        //Name of the profile stored within the current root node is found in lowercase
        String rootName = rootNode.getProfile().getMyName().toLowerCase();
        //Name of the profile to be inserted is found in lowercase
        String childName = p.getMyName().toLowerCase();
        //The two names are compared to see whether the getLeft() or getRight() method is called
        int compare = childName.compareTo(rootName);
        //The profile to be inserted comes alphabetically after the current root node
        if(compare > 0){
            //If the right child of the current root node is null, the right child
            //of the current node becomes the the container for the given profile
            if(rootNode.getRight() == null){
                BSTNode newChild = new BSTNode(p);
                //The right child of the current root node is updated
                rootNode.setRight(newChild);
            } else{
                //Neither child node is null, hence the insert function is recursively called
                //The new root node is the right child of the current root node
                insert(rootNode.getRight(), p);
            }
        //The profile to be inserted comes alphabetically before the current root node
        //If they are equal, the child node comes before it, due to reading from left to right
        } else{
            //Everything done for the right child is repeated for the left child of the current root node
            if(rootNode.getLeft() == null){
                BSTNode newChild = new BSTNode(p);
                rootNode.setLeft(newChild);
            } else {
                //New root node is the left child of the current root node
                insert(rootNode.getLeft(), p);
            }
        }
    }

    /**
     * Method is used to print the contents of the BST in an alphabetical manner
     */

    public void printAlphabetical(){
        //Calls the getProfiles() method to get an arrayList of all the Profiles in the BST
        ArrayList<Profile> profileList = getProfiles();
        for(Profile p : profileList){
            //As the profiles are fetched inorder, the profile list can be printed normally
            //Only the name of each profile is printed
            System.out.println(p.getMyName());
        }
    }

    /**
     * Creates a list of profiles by calling the recursive inOrder() method
     * @return An arrayList of profiles in an alphabetical ordering
     */

    public ArrayList<Profile> getProfiles(){
        //Creates a new empty arrayList of type Profile
        ArrayList<Profile> profileList = new ArrayList<>();
        //Call the recursive inOrder method with the initial root node of the BST
        //and the initial empty profile list
        inOrder(root, profileList);
        return profileList;
    }

    /**
     * Traverses the entire binary tree recursively until every node has been visited
     * The left child of the current root node is visited, the current node is added to
     * The the profile list and then the right child is visited
     * Inorder is used so that the profiles are stored alphabetically
     * @param node The current node being inspected
     * @param list The complete list of all the visited profiles
     */
    private void inOrder(BSTNode node, ArrayList<Profile> list){
        //Base case if the current node is null
        if(node == null){
            return;
        }
        //visit the left branch recursively
        inOrder(node.getLeft(), list);
        //add the current node to the profile list
        list.add(node.getProfile());
        //visit the right branch recursively
        inOrder(node.getRight(), list);
    }

    /**
     * This method can search for any element in a BST given a root node and a name
     * @param name The name of the node that is being search for
     * @return Returns either null if the node is not there or returns the node
     * that was being searched for
     */

    public boolean findNode(String name) {
        return search(root, name);
    }

    /**
     * Acts as the method above except uses the private root node within the class
     * This is so that the method can be called outside the class without needing the root node
     * @param node The current node that is being iterated over
     * @param name The name of the profile being searched for
     * @return returns true if the name is in the BST, false if not
     */
    private boolean search(BSTNode node, String name) {
        boolean found = false;
        while(node != null && !found){
            //Alphabetically get the names in lower case for comparing
            String rootName = node.getProfile().getMyName().toLowerCase();
            name = name.toLowerCase();
            //The two names are compared to see whether the getLeft() or getRight() method is called
            int compare = name.compareTo(rootName);
            if(compare < 0){
                //set the new root node to be the left child of the current node
                node = node.getLeft();
            } else if(compare > 0){
                //set the new root node to be the right child of the current node
                node = node.getRight();
            } else {
                //if the name matches then it has been found
                found = true;
                break;
            }
            //recursively call the function with an updated node
            found = search(node, name);
        }
        return found;
    }
}