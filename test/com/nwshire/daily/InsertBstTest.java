package com.nwshire.daily;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/22/2017.
 */
public class InsertBstTest {
    @Test
    public void test() throws Exception {
        InsertBst ib = new InsertBst();

        ib.insert(50);
        ib.insert(10);
        ib.insert(12);
        ib.insert(100);
        ib.insert(40);
        ib.insert(12);
        ib.insert(30);
        ib.insert(45);
        ib.insert(55);
        ib.insert(65);

        TreeNode root = ib.root;

        assertNotNull(root);
        assertEquals(root.value, 50);
        assertNotNull(root.left);
        assertEquals(root.left.value, 10);
        assertNotNull(root.right);
        assertEquals(root.right.value, 100);
    }

}