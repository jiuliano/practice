package com.nwshire.cracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 1/21/2017.
 */
public class SetOfStacks<T> {
    List<SStack<T>> sstackList = new ArrayList<>();
    SStack<T> currentStack = new SStack<>();

    void push(T value) {
        if ( currentStack.isFull() ) {
            sstackList.add(0, currentStack);
            currentStack = new SStack<>();
        }

        currentStack.push(value);
    }

    T pop() {
        while ( currentStack.isEmpty() && sstackList.size() > 0 ) {
            currentStack = sstackList.remove(0);
        }

        return !currentStack.isEmpty() ? currentStack.pop() : null;
    }

    T popAt(int at) {
        T value = null;

        if ( at == 0 && !currentStack.isEmpty() ) {
            value = currentStack.pop();
        } else if ( at <= sstackList.size() ) {
            value = sstackList.get(at-1).pop();
        }

        return value;
    }

    private class SStack<T> {
        Object[] values = new Object[10];
        int pos = -1;

        boolean isEmpty() {
            return pos == -1;
        }

        boolean isFull() {
            return pos+1 == values.length;
        }

        void push(T value) {
            if ( pos+1 < values.length )
                values[++pos] = value;
        }

        T pop() {
            return pos >= 0 ? (T)values[pos--] : null;
        }
    }
}
