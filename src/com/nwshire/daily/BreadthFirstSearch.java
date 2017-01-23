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
			TreeNode qNode = dq.removeFirst();
			if ( qNode.value.equals(value) ) {
				found = qNode;
				break;
			} 
			
			if ( qNode.left != null ) dq.addLast(qNode.left);
			if ( qNode.right != null ) dq.addLast(qNode.right);
		}
		
        return found;
    }
}
