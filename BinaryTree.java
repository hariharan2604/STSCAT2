import java.util.*;
import java.lang.*;
import java.io.*;

class Node {

	int data;
	Node left, right;

	Node(int d) {
		data = d;
		left = right = null;
	}
}

public class BinaryTree {
    static Node root = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the tree nodes");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        root = InsertNode(arr);
        System.out.println("Inorder:");
        inOrder(root);
        System.out.println("\nPreorder:");
        preOrder(root);
        System.out.println("\nPostorder:");
        postOrder(root);
    }

    public static Node InsertNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node root = new Node(arr[0]);
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node node = queue.poll();

            // Add left child if it exists
            if (arr[i] != -1) { // Assuming -1 represents null or no child
                node.left = new Node(arr[i]);
                queue.add(node.left);
            }
            i++;

            // Add right child if it exists
            if (i < arr.length && arr[i] != -1) {
                node.right = new Node(arr[i]);
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
}