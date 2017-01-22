package com.nwshire.daily;

/**
 * Created by james on 1/22/2017.
 */
public class InsertBst {
    TreeNode<Integer> root = null;

    void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode<Integer> node, int value) {
        if ( node == null ) {
            node = new TreeNode<>(value);
        } else {
            if ( value > node.value ) {
                node.right = insert(node.right, value);
            } else {
                node.left = insert(node.left, value);
            }
        }

        return node;
    }
}
