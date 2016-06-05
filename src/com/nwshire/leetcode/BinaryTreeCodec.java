package com.nwshire.leetcode;

public class BinaryTreeCodec {
    public String serialize(TreeNode root) {
        StringBuilder serialized = new StringBuilder();
        serializeNode(root, serialized);
        return serialized.toString();
    }

    private void serializeNode(TreeNode node, StringBuilder serialized) {
        if ( serialized.length() > 0 ) {
            serialized.append(",");
        }

        if ( node == null ) {
            serialized.append("#");
        } else {
            serialized.append(node.val);
            serializeNode(node.left, serialized);
            serializeNode(node.right, serialized);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder serialized = new StringBuilder(data);
        TreeNode root = deserializeNode(serialized);
        return root;
    }

    private TreeNode deserializeNode(StringBuilder serialized) {
        TreeNode node = null;

        if ( hasNextToken(serialized) ) {
            String tok = nextToken(serialized);
            if ( !tok.equals("#") ) {
                node = new TreeNode(Integer.valueOf(tok));
                node.left = deserializeNode(serialized);
                node.right = deserializeNode(serialized);
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

        return token;
    }

    boolean hasNextToken(StringBuilder serialized) {
        return serialized.length() > 0;
    }
}
