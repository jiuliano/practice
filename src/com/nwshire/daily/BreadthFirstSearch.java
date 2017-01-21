package com.nwshire.daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by james on 1/19/2017.
 */
public class BreadthFirstSearch {
    public TreeNode bfsFindNode(TreeNode root, TreeNode node) {
        TreeNode found = null;
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.addLast(root);
        while ( queue.size() > 0 ) {
            TreeNode dqNode = queue.removeFirst();

            if ( dqNode == node ) {
                found = dqNode;
                break;
            } else {
                if ( dqNode.left != null )
                    queue.addLast(dqNode.left);

                if ( dqNode.right != null )
                    queue.addLast(dqNode.right);
            }
        }

        return found;
    }
}
