package disjointsetunion;

class UnionFind {

    int[] id;
    int[] sz;

    int numOfComponents;

    UnionFind(int n) {
        this.id = new int[n];
        this.sz = new int[n];
        this.numOfComponents = n;
        for (int i = 0; i < n; i++) {
            this.id[i] = i;
            this.sz[i] = 1;
        }
    }

    UnionFind(int n, int numOfComponents) {
        id = new int[n];
        sz = new int[n];

        for (int i=0;i<n;i++) {
            id[i] = i;
            sz[i] = 1;
        }
        this.numOfComponents = numOfComponents;
    }

    int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        // Path compression
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    boolean union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 == root2) return false;
        int sz1 = sz[root1];
        int sz2 = sz[root2];

        if (sz1 >= sz2) {
            id[root2] = root1;
            sz[root1] += sz[root2];
        } else {
            id[root1] = root2;
            sz[root2] += sz[root1];
        }

        numOfComponents--;
        return true;
    }

    int getNumberOfComponents() {
        return numOfComponents;
    }

    int getMaxSize() {
        int max = 1;
        for (int x: sz) {
            if (x > max) max = x;
        }
        return max;
    }
}
