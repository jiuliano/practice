package com.nwshire.leetcode;

/**
 * Created by james on 1/17/2017.
 */
public class CopyRandom {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = head;
        RandomListNode newHead = null;

        while ( node != null ) {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;

            if ( node == head ) {
                newHead = newNode;
            }

            node = newNode.next;
        }

        node = head;
        while ( node != null ) {
            node.next.random = (node.random != null ? node.random.next : null);
            node = node.next.next;
        }

        node = head;
        while ( node != null ) {
            RandomListNode newNode = node.next;
            node.next = newNode.next;
            newNode.next = newNode.next != null ? newNode.next.next : null;
            node = node.next;
        }

        return newHead;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next;
        RandomListNode random;

        public RandomListNode(int label) {
            this.label = label;
        }
    }
}
