package com.nwshire.daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by james on 1/19/2017.
 */
public class BreadthFirstSearch {
	Deque<TreeNode> dq = new ArrayDeque<>();
	
    public TreeNode bfsFindNode(TreeNode root, TreeNode node) {
        TreeNode found = null;

		dq.addLast(root);
		while ( dq.size() > 0 ) {
			TreeNode qNode = dq.getFirst();
			
			if ( qNode == node ) {
				found = qNode;
				break;
			} else {
				if ( qNode.left != null ) {
					dq.addLast(qNode.left);
				}
				
				if ( qNode.right != null ) {
					dq.addLast(qNode.right);
				}
			}
		}
		
        return found;
    }
}
