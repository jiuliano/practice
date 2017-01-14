package com.nwshire.msh;

/**
 * Created by james on 1/12/2017.
 */
public class TerTree {
    // String value used for indentation in pretty printing of the tree.
    private static final String tab = "    ";

    // Head of the tree.
    private TTNode head = null;

    /**
     * Add a node to the tree.
     *
     * @param value
     */
    public void addNode(int value) {
        if ( head == null ) {
            head = new TTNode(value);
        } else {
            head.insert(value);
        }
    }

    /**
     * Get the head of the tree.
     *
     * @return
     */
    public TTNode getHead() {
        return head;
    }

    /**
     *  Pretty print the contents of the tree.
     */
    public void prettyPrint() {
        head.prettyPrint(0);
    }

    /**
     *   Class representing a ternary tree node.  Contains the value, and left, middle and right children.
     */
    public class TTNode {
        int value;
        TTNode left = null;
        TTNode middle = null;
        TTNode right = null;

        TTNode(int value) {
            this.value = value;
        }

        /**
         * Insert a value into the ternary tree.  If the next node to be assigned is already populated, recurse
         * to the next node, until the correct insertion point is found.
         *
         * @param value
         */
        public void insert(int value) {
            if ( value < this.value) {
                if ( left != null ) {
                    left.insert(value);
                } else {
                    left = new TTNode(value);
                }
            } else if ( value > this.value) {
                if ( right != null ) {
                    right.insert(value);
                } else {
                    right = new TTNode(value);
                }
            } else {
                if ( middle != null ) {
                    middle.insert(value);
                } else {
                    middle = new TTNode(value);
                }
            }
        }

        /**
         * Pretty print the ternary tree, so that its contents can be easily read and confirmed.
         *
         * @param level - The level in the tree being pretty printed.  Used to set indentation of the content.
         */
        public void prettyPrint(int level) {
            dtab(level); System.out.println("Value: " + value);
            dsub("Left", left, level);
            dsub("Middle", middle, level);
            dsub("Right", right, level);
        }

        /**
         * Print a subnode of the ternary tree, with a label to indicate left, middle or right.
         *
         * @param label
         * @param node
         * @param level
         */
        private void dsub(String label, TTNode node, int level) {
            if ( node != null ) {
                dtab(level); System.out.println(label + ": {");
                node.prettyPrint(level+1);
                dtab(level); System.out.println("}");
            }
        }

        /**
         * Prefix the next line to be printed with the correct amount of indentation.
         *
         * @param level
         */
        private void dtab(int level) {
            for ( int n=0; n<level; n++ ) {
                System.out.print(tab);
            }
        }
    }
}
