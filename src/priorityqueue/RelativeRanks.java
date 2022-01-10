package priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode 506
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
 * All the scores are guaranteed to be unique.
 * The athletes are placed based on their scores, where
 * the 1st place athlete has the highest score,
 * the 2nd place athlete has the 2nd highest score, and so on.
 * The placement of each athlete determines their rank:
 *     The 1st place athlete's rank is "Gold Medal".
 *     The 2nd place athlete's rank is "Silver Medal".
 *     The 3rd place athlete's rank is "Bronze Medal".
 *     For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
 * Return an array answer of size n where answer[i] is the rank of the ith athlete.
 */

public class RelativeRanks {

    int first, second;

    class Pair {
        int first, second;
        Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        List<Pair> l = new ArrayList<>();
        String res[] = new String[score.length];
        int n = score.length;
        for (int i= 0;i<score.length;i++) {
            l.add(new Pair(score[i],i));
        }
        Comparator<Pair> comp = new Comparator<>() {
            @Override
            public int compare(final Pair p1, final Pair p2) {
                return p2.first - p1.first;
            }
        };
        Collections.sort(l, comp);
        printList(l);
        res[l.get(0).second] = "Gold Medal";
        if (n >= 2) res[l.get(1).second] = "Silver Medal";
        else return res;
        if (n >= 3) res[l.get(2).second] = "Bronze Medal";
        else return res;
        for (int i=3;i<n;i++) {
            res[l.get(i).second] = ""+(i+1);
        }
        return res;
    }

    private void printList(List<Pair> l) {
        for (Pair p: l) {
            System.out.print(String.format("(%d,%d) ", p.first, p.second));
        }
    }
}
