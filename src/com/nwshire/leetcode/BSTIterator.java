package com.nwshire.leetcode;

import java.util.Stack;

/**
 * Created by james on 1/19/2017.
 *
 * Start with the root of the tree, and stack the root followed by all nodes to the left.
 * On each call to next, pop a node and return its value.  If the node has a right node, stack the node's right node,
 * and all of that node's left nodes, etc.  This gives you in-order traversal, using a stack.
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        loadStack(root);
    }

    private void loadStack(TreeNode node) {
        while ( node != null ) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int value = node.val;

        loadStack(node.right);
        return value;
    }
}
