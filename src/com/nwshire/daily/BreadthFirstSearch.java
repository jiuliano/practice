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
		
		dq.addLast(node);
		while ( dq.size() > 0 ) {
			TreeNode dqNode = dq.removeFirst();
			
			if ( dqNode.value.equals(value) ) {
				found = dqNode;
				break;
			} else {
				if ( dqNode.left != null ) dq.addLast(dqNode.left);
				if ( dqNode.right != null ) dq.addLast(dqNode.right);
			}
		}

        return found;
    }
}
