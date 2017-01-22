package com.nwshire.daily;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/21/2017.
 */
public class DepthFirstSearchTest {
    @Test
    public void dfsFindNode() throws Exception {
        String serializedTree = "50, 25,75, 12,37,6,80, 6,15,30,42,45,65,70,90";
        BinaryTreeCodec codec = new BinaryTreeCodec();

        TreeNode<Integer> root = codec.deserialize(serializedTree);
        DepthFirstSearch dfs = new DepthFirstSearch();
        TreeNode node = dfs.dfsFindNode(root, 6);

        assertNotNull(node);
        assertNull(node.left);
        assertNull(node.right);

        node = dfs.dfsFindNode(root, 33);
        assertNull(node);
    }
}