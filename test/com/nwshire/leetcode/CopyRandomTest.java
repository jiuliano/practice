package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/17/2017.
 */
public class CopyRandomTest {
    @Test
    public void copyRandomList() throws Exception {
        CopyRandom.RandomListNode head = new CopyRandom.RandomListNode(1);
        CopyRandom.RandomListNode node1 = new CopyRandom.RandomListNode(2);
        CopyRandom.RandomListNode node2 = new CopyRandom.RandomListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = null;

        head.random = node2;
        node1.random = node2;
        node2.random = node1;

        CopyRandom cr = new CopyRandom();
        CopyRandom.RandomListNode newHead = cr.copyRandomList(head);

        head.next = null;
        head.random = head;
        newHead = cr.copyRandomList(head);

        head.random = null;
        newHead = cr.copyRandomList(head);
    }

}