/**
 * This class represents a node in the BST class
 * Each node contains data on a profile within the network and references a
 * left child node and a right child node which are by default null when created
 * @author James Brock
 */

public class BSTNode {
    //Attributes are data which of type Profile and references to child nodes
    //which are both of type BSTNode
    private Profile data;
    private BSTNode left;
    private BSTNode right;

    /**
     * Creates a new BSTNode with a provided profile which is stored in the node
     * Both child nodes are set to null
     * @param data The profile that is being stored
     */
    public BSTNode(Profile data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * Gets the data stored in the BSTNode in the form of a Profile
     * @return The profile stored by the BSTNode
     */
    public Profile getProfile() {
        return data;
    }

    /**
     * Sets the left child of the BSTNode with another BSTNode
     * @param l a BSTNode that is referenced within the current node as its left child
     */
    public void setLeft(BSTNode l) {
        this.left = l;
    }

    /**
     * Gets the left child node of the current BSTNode
     * @return the left child of the current BSTNode as another BSTNode
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * Sets the right child of the BSTNode with another BSTNode
     * @param r a BSTNode that is referenced within the current node as its right child
     */
    public void setRight(BSTNode r) {
        this.right = r;
    }

    /**
     * Gets the right child node of the current BSTNode
     * @return the right child of the current BSTNode as another BSTNode
     */
    public BSTNode getRight() {
        return right;
    }
}
