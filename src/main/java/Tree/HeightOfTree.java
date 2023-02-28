package Tree;
import java.util.LinkedList;
        import java.util.Queue;

class HeightOfTree {

    // A tree node structure
    static class Node {
        int key;
        Node left;
        Node right;
    }

    // Utility function to create
    // a new node
    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.key = key;
        temp.left = temp.right = null;
        return temp;
    }

    /*Function to find the height(depth) of the tree*/
    public static int height(Node root)
    {

        // Initialising a variable to count the
        // height of tree
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int height = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            height++;
        }
        return height;
    }

    // Driver Code
    public static void main(String args[])
    {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);

        root.left.left = newNode(4);
        root.left.right = newNode(5);

        System.out.println("Height(Depth) of tree is: "
                + height(root));
    }
}