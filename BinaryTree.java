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
        System.out.println("Enter the tree nodes");
        for (int i = 0; i < n; i++) {
            root = InsertNode(root, sc.nextInt());
        }
        System.out.println("Inorder:");
        inOrder(root);
        System.out.println("\nPreorder:");
        preOrder(root);
        System.out.println("\nPostorder:");
        postOrder(root);
    }

    static Node InsertNode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = InsertNode(root.left, data);
        } else {
            root.right = InsertNode(root.right, data);

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