package com.nwshire.daily;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/21/2017.
 */
public class BreadthFirstSearchTest {
    @Test
    public void bfsFindNode() throws Exception {
        String serializedTree = "50,25,75,12,37,6,80,6,15,30,42,45,65,70,90";
        BinaryTreeCodec codec = new BinaryTreeCodec();

        TreeNode<Integer> root = codec.deserialize(serializedTree);
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        TreeNode node = bfs.bfsFindNode(root, 6);

        assertNotNull(node);
        assertEquals(node.left.value, 45);
        assertEquals(node.right.value, 65);

        node = bfs.bfsFindNode(root, 33);
        assertNull(node);
    }

}