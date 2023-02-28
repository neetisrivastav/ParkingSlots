package Tree;

public class InvertBinaryTree {
}
class Nodes
{
    int data;
    Nodes left = null, right = null;

    Nodes(int data) {
        this.data = data;
    }
}

class Main
{
    // Function to perform preorder traversal on a given binary tree
    public static void preorder(Nodes root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Utility function to swap left subtree with right subtree
    public static void swap(Nodes root)
    {
        if (root == null) {
            return;
        }

        Nodes temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // Function to invert a given binary tree using preorder traversal
    public static void invertBinaryTree(Nodes root)
    {
        // base case: if the tree is empty
        if (root == null) {
            return;
        }

        // swap left subtree with right subtree
        swap(root);

        // invert left subtree
        invertBinaryTree(root.left);

        // invert right subtree
        invertBinaryTree(root.right);
    }

    public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */

        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(7);

        invertBinaryTree(root);
        preorder(root);
    }
}