package com.nwshire.daily;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/21/2017.
 */
public class BinaryTreeCodecTest {
    @Test
    public void test() throws Exception {
        String serializedTree = "50,25,75,12,37,6,80,6,15,30,42,45,#,70,90";
        BinaryTreeCodec codec = new BinaryTreeCodec();

        TreeNode root = codec.deserialize(serializedTree);

        String reSerializedTree = codec.serialize(root);

        assertEquals(serializedTree, reSerializedTree);
    }

}