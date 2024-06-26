// Java program to correct the BST 
// if two nodes are swapped
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

class RecoverBST
{
	Node first, middle, last, prev;
	
	// This function does inorder traversal
	// to find out the two swapped nodes.
	// It sets three pointers, first, middle
	// and last. If the swapped nodes are
	// adjacent to each other, then first 
	// and middle contain the resultant nodes
	// Else, first and last contain the 
	// resultant nodes
	void correctBSTUtil( Node root)
	{
		if( root != null )
		{
			// Recur for the left subtree
			correctBSTUtil( root.left);

			// If this node is smaller than
			// the previous node, it's 
			// violating the BST rule.
			if (prev != null && root.data <
								prev.data)
			{
				// If this is first violation,
				// mark these two nodes as
				// 'first' and 'middle'
				if (first == null)
				{
					first = prev;
					middle = root;
				}

				// If this is second violation,
				// mark this node as last
				else
					last = root;
			}

			// Mark this node as previous
			prev = root;

			// Recur for the right subtree
			correctBSTUtil( root.right);
		}
	}

	// A function to fix a given BST where 
	// two nodes are swapped. This function 
	// uses correctBSTUtil() to find out 
	// two nodes and swaps the nodes to 
	// fix the BST
	void correctBST( Node root )
	{
		// Initialize pointers needed 
		// for correctBSTUtil()
		first = middle = last = prev = null;

		// Set the pointers to find out 
		// two nodes
		correctBSTUtil( root );

		// Fix (or correct) the tree
		if( first != null && last != null )
		{
			int temp = first.data;
			first.data = last.data;
			last.data = temp; 
		}
		// Adjacent nodes swapped
		else if( first != null && middle !=
									null ) 
		{
			int temp = first.data;
			first.data = middle.data;
			middle.data = temp;
		}
	}

	/* A utility function to print 
	Inorder traversal */
	void printInorder(Node node)
	{
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(" " + node.data);
		printInorder(node.right);
	}


	// Driver program to test above functions
	public static void main (String[] args) 
	{
		Node root = new Node(6);
		root.left = new Node(10);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);

		System.out.println("Inorder Traversal"+
						" of the original tree");
		RecoverBST tree = new RecoverBST();
		tree.printInorder(root);

		tree.correctBST(root);

		System.out.println("\nInorder Traversal"+
						" of the fixed tree");
		tree.printInorder(root);
	}
}
