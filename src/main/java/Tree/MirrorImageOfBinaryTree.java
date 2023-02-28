package Tree;


class Nodeses {
    int key;
    Nodeses left, right;
    Nodeses(int item)
    {
        key = item;
        left = right = null;
    }
}

class MirrorImageOfBinaryTree {
    Nodeses root;

    // returns true if trees with roots as root1 and
    // root2 are mirror
    boolean isMirror(Nodeses node1, Nodeses node2)
    {
        // if both trees are empty, then they are mirror image
        if (node1 == null && node2 == null)
            return true;

        // For two trees to be mirror images, the following
        // three conditions must be true
        // 1.) Their root node's key must be same
        // 2.) left subtree of left tree and right subtree
        // of right tree have to be mirror images
        // 3.) right subtree of left tree and left subtree
        // of right tree have to be mirror images
        if (node1 != null && node2 != null
                && node1.key == node2.key)
            return (isMirror(node1.left, node2.right)
                    && isMirror(node1.right, node2.left));

        // if none of the above conditions is true then
        // root1 and root2 are not mirror images
        return false;
    }

    // returns true if the tree is symmetric i.e
    // mirror image of itself
    boolean isSymmetric()
    {
        // check if tree is mirror of itself
        return isMirror(root, root);
    }

    // Driver code
    public static void main(String args[])
    {
        MirrorImageOfBinaryTree tree = new MirrorImageOfBinaryTree();
        tree.root = new Nodeses(1);
        tree.root.left = new Nodeses(2);
        tree.root.right = new Nodeses(2);
        tree.root.left.left = new Nodeses(3);
        tree.root.left.right = new Nodeses(4);
        tree.root.right.left = new Nodeses(4);
        tree.root.right.right = new Nodeses(3);
        boolean output = tree.isSymmetric();
        if (output == true)
            System.out.println("Symmetric");
        else
            System.out.println("Not symmetric");
    }
}