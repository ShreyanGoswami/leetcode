package priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Leetcode 1094 https://leetcode.com/problems/car-pooling/
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
 *
 * You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi]
 * indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively.
 * The locations are given as the number of kilometers due east from the car's initial location.
 *
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 */

public class CarPooling {
    class Pair {
        int f,s;
        Pair(int first, int second) {
            this.f = first;
            this.s = second;
        }
    }


    public boolean carPooling(int[][] trips, int capacity) {
        List<Pair> l = new ArrayList<Pair>();
        for (int[] t: trips) {
            l.add(new Pair(t[0],t[1]));
            l.add(new Pair((-1 * t[0]),t[2]));
        }

        Collections.sort(l, (final Pair p1, final Pair p2) -> {
            if (p1.s == p2.s) {
                return p1.f-p2.f;
            }
            return p1.s - p2.s;
        });
        int currCapacity = 0;
        for (Pair p: l) {
            currCapacity += p.f;
            if (currCapacity > capacity) return false;
        }
        return true;
    }
}
