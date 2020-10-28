package lca;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyBinaryTree {

	@Test
	public void findLCAOfEmptyTree() {
		MyBinaryTree tree = new MyBinaryTree(); 
		assertNull("If LCA is called on an empty tree, retur null", tree.findLCA(1, 2));
	}
	
	@Test
	public void findLCAOfTreeWithOneNode() {
		MyBinaryTree tree = new MyBinaryTree();
		tree.root = tree.new Node(1);
		assertEquals("Where a binary tree has only one node which is the root, the LCA of the root passed twice will be the root", tree.findLCA(1, 1), tree.root);
	}
	
	@Test
	public void findLCAOfNonEmptyTree() {
		MyBinaryTree tree = new MyBinaryTree(); 
        tree.root = tree.new Node(1); 
        tree.root.left = tree.new Node(2); 
        tree.root.right = tree.new Node(3); 
        tree.root.left.left = tree.new Node(4); 
        tree.root.left.right = tree.new Node(5); 
        tree.root.right.left = tree.new Node(6); 
        tree.root.right.right = tree.new Node(7); 
        
        assertEquals("Given a non-empty binary tree, the lowest common ancestor should be the lowest node in the tree that has both passed nodes as a descendent", tree.findLCA(4, 5), tree.root.left);
        assertEquals("Given a non-empty binary tree, the lowest common ancestor should be the lowest node in the tree that has both passed nodes as a descendent", tree.findLCA(2, 7), tree.root);       
	}
}
