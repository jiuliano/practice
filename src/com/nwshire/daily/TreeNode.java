package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class TreeNode<T> {
    T value;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        left = right = null;
    }

    public TreeNode(T value) {
        this();
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.equals(value);
    }
}
