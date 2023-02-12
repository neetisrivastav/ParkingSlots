package Tree;

class PreOrderNode {
    int key;
    PreOrderNode left, right;

    public PreOrderNode(int item)
    {
        key = item;
        left = right = null;
    }
}

class PreOrder {
    // Root of Binary Tree
    PreOrderNode root;

    PreOrder() { root = null; }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(PreOrderNode node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPreorder() { printPreorder(root); }

    // Driver code
    public static void main(String[] args)
    {
        PreOrder tree = new PreOrder();
        tree.root = new PreOrderNode(1);
        tree.root.left = new PreOrderNode(2);
        tree.root.right = new PreOrderNode(3);
        tree.root.left.left = new PreOrderNode(4);
        tree.root.left.right = new PreOrderNode(5);

        // Function call
        System.out.println(
                "Preorder traversal of binary tree is ");
        tree.printPreorder();
    }
}