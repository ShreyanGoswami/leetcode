package disjointsetunion;

import java.util.*;

/**
 * Leetcode 1584 https://leetcode.com/problems/min-cost-to-connect-all-points/
 *
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
 *  where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 */

public class Kurskal {
    class Point {
        int x, y;

        Point (int f, int s) {
            this.x = f;
            this.y = s;
        }

        @Override
        public int hashCode() {
            return x * 31 + y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Point that = (Point) o;
            return x == that.x && y == that.y;
        }

    }

    class Edge {
        Point p1, p2;
        int d;
        Edge (Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
            this.d = manhattanDistance(p1,p2);
        }
    }


    private int manhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
    }


    public int minCostConnectPoints(int[][] points) {
        // Put the distances in a priority queue
        int l = points.length;

        Map<Point, Integer> m = new HashMap<>();
        for (int i=0;i<l;i++) {
            m.put(new Point(points[i][0], points[i][1]), i);
        }

        List<Edge> edges = new ArrayList<>(0);
        for (int i=0;i<l;i++) {
            for (int j=i+1;j<l;j++) {
                edges.add(new Edge(new Point(points[i][0],points[i][1]), new Point(points[j][0],points[j][1])));
            }
        }
        Collections.sort(edges, Comparator.comparingInt((Edge e) -> e.d));
        // Initialize UnionFind
        UnionFind uf = new UnionFind(l);
        int d = 0;

        // While the number of components is not 1
        int i = 0;
        int s = edges.size();
        while (uf.getNumberOfComponents() != 1 && i < s) {
            Edge e = edges.get(i);
            if (uf.union(m.get(e.p1),m.get(e.p2))) {
                d += e.d;
            }
            i++;
        }

        return d;

    }
}
