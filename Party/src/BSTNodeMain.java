/**
 * Class used to test the BSTNode class by creating individual nodes
 * and then setting some nodes to be the children of other nodes
 * By calling profile method calls, the BSTNodes can be properly tested
 * @author James Brock
 */

public class BSTNodeMain {
    public static void main(String[] args){
        //Creates a new profile with given data
        Profile james = new Profile("James", "Swansea", "UK", "British", 23, 12, 1998, new String[]{"Guitar", "Reading", "Running"});
        //A new BSTNode is created from the profile
        BSTNode newNode = new BSTNode(james);

        //Testing the node attributes
        System.out.println(newNode.getProfile());
        System.out.println("Left node: " + newNode.getLeft());
        System.out.println("Right node: " + newNode.getRight());

        //Creating new nodes to be set as children nodes to newNode
        Profile Bob = new Profile("Bob", "Bath", "UK", "French", 7, 1, 2001, new String[]{"Writing", "Dog walking", "Cycling"});
        BSTNode newNodeLeftChild = new BSTNode(Bob);
        newNode.setLeft(newNodeLeftChild);
        Profile Kate = new Profile("Kate", "Melbourne", "Australia", "Australian", 21, 7, 1995, new String[]{"Yoga", "Raves", "Swimming"});
        BSTNode newNodeRightChild = new BSTNode(Kate);
        newNode.setRight(newNodeRightChild);

        //Testing the child nodes of newNode
        System.out.println("Left node: " + newNode.getLeft().getProfile());
        System.out.println("Right node: " + newNode.getRight().getProfile());
    }
}
