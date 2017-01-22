package com.nwshire.cracking;

import java.util.Stack;

/**
 * Created by james on 1/21/2017.
 */
public class TowersOfHanoi {
    private Tower[] towers = new Tower[3];

    TowersOfHanoi() {
        for ( int n=0; n<3; n++ ) {
            towers[n] = new Tower(n);
        }
    }

    public void run(int nDisks) {
        for ( int n=nDisks; n>0; n-- ) {
            towers[0].push(n);
        }

        towers[0].moveTo(nDisks, towers[2], towers[1]);
    }


    private class Tower {
        Stack<Integer> disks = new Stack<>();
        int index;

        Tower(int index) {
            this.index = index;
        }

        void moveTopTo(Tower to) {
            Integer disk = pop();
            System.out.println("Moving disk " + disk + " from tower " + index + " to tower " + to.index);
            to.push(disk);
        }

        void moveTo(int nDisks, Tower to, Tower buf) {
            if ( nDisks > 0 ) {
                moveTo(nDisks-1, buf, to);
                moveTopTo(to);
                buf.moveTo(nDisks-1, to, this);
            }
        }

        Integer pop() {
            return disks.pop();
        }

        void push(Integer disk) {
            if ( !disks.empty() && disks.peek() < disk ) {
                System.err.println("Gangrene");
            } else {
                disks.push(disk);
            }
        }
    }
}
