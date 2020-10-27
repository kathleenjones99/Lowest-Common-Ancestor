// Kathleen Jones 17325867
// BinaryTree and Node structures taken from geeksforgeeks, find code at: 
// https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
// LCA of Binary Tree implementation also taken from geeksforgeeks, find code at

package lca;

public class MyBinaryTree {

	// Root of Binary Tree 
    Node root; 
  
    // Constructors 
    MyBinaryTree(int key) 
    { 
        root = new Node(key); 
    } 
  
    MyBinaryTree() 
    { 
        root = null; 
    } 
  
    Node findLCA(int node1, int node2) {
    	return findLCA(root, node1, node2);
    }
    
    private Node findLCA(Node root, int node1, int node2) {
    	
    	Node LCA = null;
    	
    	if(root == null) {											// base case, tree/node passed is null
    		return LCA;
    	} else if (root.key == node1 || root.key == node2) {		// If either n1 or n2 matches with root's key, report 
            LCA = root;  											// the presence by returning root (Note that if a key is 
            return LCA;												// ancestor of other, then the ancestor key becomes LCA)
    	}    			   											
    	
        Node left_lca = findLCA(root.left, node1, node2); 			// Look for keys in left and right subtrees 
        Node right_lca = findLCA(root.right, node1, node2); 
  
        // If both of the above calls return Non-NULL, then one key 
        // is present in one subtree and other is present in other, 
        // so this node is the LCA.
        // Otherwise check if left subtree or right subtree is LCA 
        if (left_lca!=null && right_lca!=null) { 
            LCA = root; 
        } else {													
        	LCA = (left_lca != null) ? left_lca : right_lca; 
        }
        
    	return LCA;
    }
    
    
    // main function building a binary tree and using function to find LCA
    public static void main(String args[]) 
    { 
        MyBinaryTree tree = new MyBinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        System.out.println("LCA(4, 5) = " + 
                            tree.findLCA(4, 5).key); 
        System.out.println("LCA(4, 6) = " + 
                            tree.findLCA(4, 6).key); 
        System.out.println("LCA(3, 4) = " + 
                            tree.findLCA(3, 4).key); 
        System.out.println("LCA(2, 4) = " + 
                            tree.findLCA(2, 4).key); 
    } 
    
} 
