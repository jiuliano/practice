package com.nwshire.daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by james on 1/19/2017.
 */
public class BreadthFirstSearch<T> {
    public TreeNode<T> bfsFindNode(TreeNode<T> node, T value) {
        TreeNode<T> found = null;
		Deque<TreeNode> dq = new ArrayDeque<>();
		
		dq.add(node);
		while ( dq.size() > 0 ) {
			node = dq.removeFirst();
			if ( node.value.equals(value) ) {
				found = node;
				break;
			}
			
			if ( node.left != null ) dq.addLast(node.left);
			if ( node.right != null ) dq.addLast(node.right);
		}
		

        return found;
    }
}
