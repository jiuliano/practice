package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class DepthFirstSearch<T> {
    public TreeNode<T> dfsFindNode(TreeNode<T> node, T value) {
        TreeNode<T> found = null;
  
        if ( node != null ) {
			if ( node.value.equals(value) ) {
				found = node;
			} else {
				found = dfsFindNode(node.left, value);
				if ( found == null ) {
					found = dfsFindNode(node.right, value);
				}
			}
		} 
  
        return found;
    }
}
