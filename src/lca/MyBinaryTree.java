// Kathleen Jones 17325867
// BinaryTree and Node structures taken from geeksforgeeks, find code at: 
// https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
// LCA of Binary Tree implementation also taken from geeksforgeeks, find code at

package lca;

public class MyBinaryTree {

	class Node {
		
		int key; 
	    Node left, right; 
	  
	    public Node(int item) 
	    { 
	        key = item; 
	        left = right = null; 
	    }
	    
	}
	
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
    
} 
