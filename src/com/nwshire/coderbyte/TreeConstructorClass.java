package com.nwshire.coderbyte;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        left = right = null;
    }

    public TreeNode(int value) {
        this();
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.equals(value);
    }
}

class Pair {
    int cv;
    int pv;

    Pair(String px) {
        px = px.replace("(", "");
        px = px.replace(")", "");
        String p[] = px.split("[,]");
        cv = Integer.valueOf(p[0]);
        pv = Integer.valueOf(p[1]);
    }

    boolean isLeft() {
        return cv < pv;
    }

    boolean isRight() {
        return cv > pv;
    }
}

public class TreeConstructorClass {

    public static String TreeConstructor(String[] strArr) {
        Map<Integer, TreeNode> nmap = new HashMap<>();
        Set<TreeNode> rcs = new HashSet<>();

        for (String pair : strArr) {
            Pair p = new Pair(pair);

            TreeNode pn = getNode(nmap, p.pv, rcs, true);
            if (p.isLeft() && pn.left == null) {
                pn.left = getNode(nmap, p.cv, rcs, false);
            } else if (p.isRight() && pn.right == null) {
                pn.right = getNode(nmap, p.cv, rcs, false);
            } else {
                return "false";
            }
        }

        if (rcs.size() < 1) {
            return "false";
        } else if (rcs.size() > 1) {
            return "false";
        }

        removeNode(nmap, rcs.iterator().next());

        if (!nmap.isEmpty()) {
            return "false";
        }

        return "true";
    }

    static void removeNode(Map<Integer, TreeNode> nmap, TreeNode n) {
        if (n == null)
            return;

        if (nmap.containsKey(n.value)) {
            nmap.remove(n.value);
            removeNode(nmap, n.left);
            removeNode(nmap, n.right);
        }
    }

    static TreeNode getNode(Map<Integer, TreeNode> nmap, Integer value, Set<TreeNode> rcs, boolean parent) {
        TreeNode tn;

        if (nmap.containsKey(value)) {
            tn = nmap.get(value);
            if (!parent) {
                rcs.remove(tn);
            }
        } else {
            tn = new TreeNode();
            tn.value = value;
            nmap.put(value, tn);
            if (parent) {
                rcs.add(tn);
            }
        }

        return tn;
    }
}
