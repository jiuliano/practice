package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class DepthFirstSearch {
    public TreeNode dfsFindNode(TreeNode root, TreeNode node) {
        TreeNode found = null;

		if ( root == node ) {
			found = root;
		} else {
			found = dfsFindNode(root.left, node);
			if ( found == null ) {
				found = dfsFindNode(root.right, node);
			}
		}
		
        return found;
    }
}
