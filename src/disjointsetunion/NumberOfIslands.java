package disjointsetunion;

/**
 * Leetcode 200 https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */

public class NumberOfIslands {

    public int numIslands(char[][] arr) {

        int l = arr.length;
        int c = arr[0].length;

        int n = 0;
        for (int i=0;i<l;i++) {
            for (int j=0;j<c;j++) {
                if (arr[i][j] == '1') n++;
            }
        }

        UnionFind uf = new UnionFind(l*c, n);

        for (int i=0;i<l;i++) {
            for (int j=0;j<c;j++) {
                if (arr[i][j] == '1') {
                    int h1 = i*c;

                    if (i-1 >= 0 && arr[i-1][j] == '1') {
                        uf.union((h1+j), ((i-1)*c+j));
                    }
                    if (j+1 < c && arr[i][j+1] == '1') {
                        uf.union((h1+j), ((i)*c+(j+1)));
                    }
                    if (i+1 < l && arr[i+1][j] == '1') {
                        uf.union((h1+j), ((i+1)*c+(j)));
                    }
                    if (j-1 >= 0 && arr[i][j-1] == '1') {
                        uf.union((h1+j), ((i)*c+(j-1)));
                    }
                }
            }
        }
        return uf.getNumberOfComponents();
    }
}
