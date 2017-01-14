package com.nwshire.msh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/13/2017.
 */
public class TerTreeTest {
    TerTree terTree;

    @Before
    public void setUp() throws Exception {
        terTree = new TerTree();

        terTree.addNode(1);
        terTree.addNode(5);
        terTree.addNode(4);
        terTree.addNode(9);
        terTree.addNode(5);
        terTree.addNode(7);
        terTree.addNode(1);
        terTree.addNode(4);
        terTree.addNode(1);
    }

    @Test
    public void treeTest() throws Exception {
        TerTree.TTNode node = terTree.getHead();

        Assert.assertNotNull(node);
        Assert.assertEquals(node.value, 1);

        // 1 is the lowest value, and first in.  So there should be no nodes to the left.
        Assert.assertNull(node.left);

        // There are two more 1's inserted.  They should be down the middle
        Assert.assertNotNull(node.middle);
        Assert.assertEquals(node.middle.value, 1);
        Assert.assertNotNull(node.middle.middle);
        Assert.assertEquals(node.middle.middle.value, 1);
        Assert.assertNull(node.middle.middle.middle);

        // Right side tests
        Assert.assertNotNull(node.right);
        Assert.assertEquals(node.right.value, 5);
        Assert.assertNotNull(node.right.left);
        Assert.assertEquals(node.right.left.value, 4);
        Assert.assertNotNull(node.right.right);
        Assert.assertEquals(node.right.right.value, 9);
        Assert.assertNotNull(node.right.right.left);
        Assert.assertEquals(node.right.right.left.value, 7);
    }
}