package DSA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CBTNode {  // Changed class name from TNode to CBTNode
    int data;
    CBTNode left, right;

    public CBTNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class CompleteBinaryTreeOperations {  
    CBTNode root;

    // Function to insert nodes level-wise in Complete Binary Tree
    public void insertLevelWise(int data) {
        CBTNode newNode = new CBTNode(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<CBTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            CBTNode temp = queue.poll();

            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    // Function to find the minimum value in Complete Binary Tree
    public int findMin(CBTNode root) {
        if (root == null) return Integer.MAX_VALUE;

        int minValue = root.data;
        Queue<CBTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            CBTNode temp = queue.poll();
            minValue = Math.min(minValue, temp.data);

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }

        return minValue;
    }

    // Function to find the maximum value in Complete Binary Tree
    public int findMax(CBTNode root) {
        if (root == null) return Integer.MIN_VALUE;

        int maxValue = root.data;
        Queue<CBTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            CBTNode temp = queue.poll();
            maxValue = Math.max(maxValue, temp.data);

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }

        return maxValue;
    }
}

public class CompleteBinaryTreeMinMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompleteBinaryTreeOperations cbt = new CompleteBinaryTreeOperations();

        System.out.print("Enter number of nodes to insert: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            cbt.insertLevelWise(value);
        }

        // Find and print min and max values
        System.out.println("Minimum value in Complete Binary Tree: " + cbt.findMin(cbt.root));
        System.out.println("Maximum value in Complete Binary Tree: " + cbt.findMax(cbt.root));

        scanner.close();
    }
}
