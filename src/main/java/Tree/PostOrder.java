package Tree;

class PostOrderNode {
    int key;
    PostOrderNode left, right;

    public PostOrderNode(int item)
    {
        key = item;
        left = right = null;
    }
}

class PostOrder {
    // Root of Binary Tree
    PostOrderNode root;

    PostOrder() { root = null; }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    void printPostorder(PostOrderNode node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    // Wrappers over above recursive functions
    void printPostorder() {
        printPostorder(root);
    }

    // Driver code
    public static void main(String[] args)
    {
        PostOrder tree = new PostOrder();
        tree.root = new PostOrderNode(1);
        tree.root.left = new PostOrderNode(2);
        tree.root.right = new PostOrderNode(3);
        tree.root.left.left = new PostOrderNode(4);
        tree.root.left.right = new PostOrderNode(5);

        // Function call
        System.out.println(
                "\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }
}