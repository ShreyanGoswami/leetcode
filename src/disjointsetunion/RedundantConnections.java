package disjointsetunion;

/**
 * Leetcode 684 https://leetcode.com/problems/redundant-connection/
 *
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
 * The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
 * The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 * If there are multiple answers, return the answer that occurs last in the input.
 */

public class RedundantConnections {
    public int[] findRedundantConnection(int[][] edges) {
        int l = edges.length;
        UnionFind uf = new UnionFind(l);
        int res[] = new int[2];
        for (int[] edge: edges) {
            if (!uf.union(edge[0]-1, edge[1]-1)) {
                res[0] = edge[0];
                res[1] = edge[1];
            }
        }
        return res;
    }
}
