package com.nwshire.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by james on 1/15/2017.
 */
public class PostOrderTraversalTest {
    @Test
    public void postorderTraversal() throws Exception {
        BinaryTreeCodec btc = new BinaryTreeCodec();
        TreeNode root = btc.deserialize("1,#,2,3");

        PostOrderTraversal pot = new PostOrderTraversal();
        List<Integer> result = pot.postorderTraversal(root);

        assertEquals((int)result.get(0), 3);
        assertEquals((int)result.get(1), 2);
        assertEquals((int)result.get(2), 1);
    }
}