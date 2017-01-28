package com.nwshire.daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by james on 1/19/2017.
 */
public class BreadthFirstSearch<T> {
    public TreeNode<T> bfsFindNode(TreeNode<T> node, T value) {
        TreeNode<T> found = null;
		
		if ( node != null ) {
    		Deque<TreeNode> dq = new ArrayDeque<>();
			dq.add(node);
			
			while ( dq.size() > 0 ) {
				TreeNode n = dq.removeFirst();
				
				if ( n.value.equals(value) ) {
					found = n;
					break;
				} 
				
				if ( n.left != null ) dq.addLast(n.left);
				if ( n.right != null ) dq.addLast(n.right);
			}
		}

        return found;
    }
}
