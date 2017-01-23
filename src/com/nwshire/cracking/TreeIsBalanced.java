package com.nwshire.cracking;

import com.nwshire.daily.TreeNode;

/**
 * Created by james on 1/22/2017.
 */
public class TreeIsBalanced {

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) - minDepth(root) > 1;
    }

    int maxDepth(TreeNode node) {
        if ( node == null )
            return 0;

        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    int minDepth(TreeNode node) {
        if ( node == null )
            return 0;

        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }
}
