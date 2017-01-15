package com.nwshire.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 1/15/2017.
 */
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traverse(root, result);

        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if ( node != null ) {
            traverse(node.left, result);
            traverse(node.right, result);
            result.add(node.val);
        }
    }
}
