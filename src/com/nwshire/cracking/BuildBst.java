package com.nwshire.cracking;

/**
 * Created by james on 1/22/2017.
 */
public class BuildBst {
    TreeNode root = null;

    void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode node, int value) {
        if ( node == null ) {
            node = new TreeNode(value);
        } else {
            if ( value > node.value ) {
                node.right = insert(node.right, value);
            } else {
                node.left = insert(node.left, value);
            }
        }

        return node;
    }

    public class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }
}
