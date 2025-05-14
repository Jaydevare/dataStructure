package DSA;

class node {
    int data;
    node left, right;

    public node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BS {
    // Function to insert a node into BST
    public node insert(node root, int val) {
        if (root == null) return new node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    // Function to check if two trees are identical
    public boolean areIdentical(node root1, node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return (root1.data == root2.data) &&
               areIdentical(root1.left, root2.left) &&
               areIdentical(root1.right, root2.right);
    }

    // Function to check if second BST is a subtree of first BST
    public boolean isSubtree(node mainTree, node subTree) {
        if (subTree == null) return true;  // Empty subtree is always a subtree
        if (mainTree == null) return false; // If main tree is empty, it can't contain subtree

        if (areIdentical(mainTree, subTree)) return true;

        return isSubtree(mainTree.left, subTree) || isSubtree(mainTree.right, subTree);
    }
}

public class BSTSubtreeCheck {
    public static void main(String[] args) {
        BS bst = new BS();
        node mainTree = null;
        node subTree = null;

        // Constructing Main BST
        mainTree = bst.insert(mainTree, 10);
        mainTree = bst.insert(mainTree, 5);
        mainTree = bst.insert(mainTree, 15);
        mainTree = bst.insert(mainTree, 3);
        mainTree = bst.insert(mainTree, 7);
        mainTree = bst.insert(mainTree, 18);

        // Constructing Sub BST
        subTree = bst.insert(subTree, 5);
        subTree = bst.insert(subTree, 3);
        subTree = bst.insert(subTree, 7);

        // Check if subTree is a subtree of mainTree
        if (bst.isSubtree(mainTree, subTree))
            System.out.println("Subtree is present in the main BST.");
        else
            System.out.println("Subtree is NOT present in the main BST.");
    }
}

