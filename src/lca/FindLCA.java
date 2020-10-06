// Implementation and explanation found at: 
// https://java2blog.com/lowest-common-ancestor-n-ary-tree/#:~:text=A%20n%2Dary%20tree%20is,can%20say%2C%20farthest%20from%20root.

package lca;

import java.util.ArrayList;
import java.util.Scanner;
 
public class FindLCA {
 
	static int lca = -1;
	
	public static void main(String[] args) {
 
		Scanner scn = new Scanner(System.in);
 
		int numNodes = scn.nextInt();
 
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] tree = new ArrayList[numNodes + 1];
 
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
 
		// for a tree, edges are always equal to nodes-1 as it does not 
		// have any cycle.
		int edges = numNodes - 1;
 
		while (edges-- > 0) {
			int parent = scn.nextInt();
			int child = scn.nextInt();
 
			tree[parent].add(child);
		}
 
		getLCA(1, tree, scn.nextInt(), scn.nextInt());
		scn.close();
 
		System.out.println("Output: "+lca);
 
	}
 
	public static boolean getLCA(int node, ArrayList<Integer>[] tree, int u, int v) {
 
		/* if current node is equal to one of the nodes whose lca 
		   we are finding, then it is a potential candidate for 
           being the lca.
		 */
		boolean self = node == u || node == v ? true : false;
 
 
		int count = 0;
		/* recurring for every child. and keeping a count of result
		  of how many times we are getting true.
		 */
		for (int child : tree[node]) {
			if (getLCA(child, tree, u, v)) {
				count++;
			}
		}
 
		/* this is the main check, if current node itself is one of 
		   the node whose LCA is to be found and its getting true from 
		   any of its child, then surely it is LCA of given nodes.
		   also, if we get true from exactly two sides, this means 
		   that current node is the node after which the path for 
		   both nodes diverge, and hence it is the LCA for given nodes.
		 */ 
		if (((self && count == 1) || (count == 2))) {
			/* LCA will be set only once, as the parent of
               LCA will have the count==2 condition as true,
			   but that is not the correct answer.
			 */
			if (lca == -1) {
				lca = node;
			}
			return true;
		}
		/* current node will return true only if either the 
		   current node is one of the given nodes, or one of its 
		   children return true for count == 2, we already handled it
           while setting LCA.
		 */
		return self || count == 1;
	}
}