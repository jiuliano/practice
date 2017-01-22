package com.nwshire.cracking;

import java.util.Stack;

/**
 * Created by james on 1/21/2017.
 */
public class StackWithMinimum {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minimum = new Stack<>();

    public void push(int value) {
        stack.push(value);
        if ( minimum.empty() || value <= minimum.peek() ) {
            minimum.push(value);
        }
    }

    public int pop() {
        int value = stack.pop();
        if ( minimum.peek() == value ) {
            minimum.pop();
        }

        return value;
    }

    public int min() {
        return minimum.peek();
    }
}
