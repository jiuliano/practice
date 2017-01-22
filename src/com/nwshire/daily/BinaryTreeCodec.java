package com.nwshire.daily;

import com.nwshire.leetcode.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by james on 1/21/2017.
 */
public class BinaryTreeCodec {
    public String serialize(TreeNode<Integer> root) {
        StringBuilder serialized = new StringBuilder();
        StringBuilder nulls = new StringBuilder();

        if ( root != null ) {
            serialized.append(root.value);

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);

            while ( deque.size() > 0 ) {
                TreeNode node = deque.removeFirst();
                serializeNode(node.left, deque, nulls, serialized);
                serializeNode(node.right, deque, nulls, serialized);
            }
        }

        return serialized.toString();
    }

    private void serializeNode(TreeNode<Integer> node, Deque deque, StringBuilder nulls, StringBuilder serialized) {
        if ( node == null ) {
            nulls.append(",#");
        } else {
            serialized.append(nulls).append(",").append(node.value);
            nulls.setLength(0);
            deque.addLast(node);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode<Integer> deserialize(String data) {
        List<List<Integer>> levels = new ArrayList<>();
        StringBuilder serialized = new StringBuilder(data);
        TreeNode<Integer> root = deserializeNode(serialized);
        return root;
    }

    private TreeNode<Integer> deserializeNode(StringBuilder serialized) {
        TreeNode<Integer> root = createNextNode(serialized);

        if ( root != null ) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);

            while ( deque.size() > 0 ) {
                TreeNode node = deque.removeFirst();

                node.left = createNextNode(serialized);
                if ( node.left != null ) {
                    deque.addLast(node.left);
                }

                node.right = createNextNode(serialized);
                if ( node.right != null ) {
                    deque.addLast(node.right);
                }
            }
        }

        return root;
    }

    TreeNode createNextNode(StringBuilder serialized) {
        TreeNode node = null;

        if ( hasNextToken(serialized) ) {
            String tok = nextToken(serialized);
            if ( !tok.equals("#") ){
                node = new TreeNode();
                node.value = Integer.valueOf(tok);
            }
        }

        return node;
    }

    String nextToken(StringBuilder serialized) {
        int comma = serialized.indexOf(",");
        String token = "";

        if ( comma >= 0 ) {
            token = serialized.substring(0, comma);
            serialized.delete(0, comma+1);
        } else {
            token = serialized.toString();
            serialized.setLength(0);
        }

        return token.trim();
    }

    boolean hasNextToken(StringBuilder serialized) {
        return serialized.length() > 0;
    }
}
