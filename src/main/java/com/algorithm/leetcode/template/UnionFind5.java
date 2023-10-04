package com.algorithm.leetcode.template;

/**
 * 基于QuickUnion的按秩排序并且路径压缩的并查集
 *
 * @author scott
 * @date 2023/9/9 22:29
 */
public class UnionFind5 {
    private int[] root;
    private int[] rank;

    public UnionFind5(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }


    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }


    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        // 下面的例子就更好理解了，我们先初始化并查集一共6个元素，就是上面图中的元素
        // 在图中的连接情况 把0,1,2连起来，3,4连起来，并用connected()测试下元素的连通性
        // 最后我们把元素5加入到1的集合中，测试下2和5的连通性，发现确实2和5也相连了，程序测试完成。
        UnionFind5 uf = new UnionFind5(6);
        // 0-1-2 3-4 5
        uf.union(0, 1);
        uf.union(0, 2);
        uf.union(3, 4);

        // true
        System.out.println(uf.connected(1, 2));
        // false
        System.out.println(uf.connected(1, 3));
        // false
        System.out.println(uf.connected(4, 5));

        // 0-1-2 3-4 5
        uf.union(1, 5);
        // true
        System.out.println(uf.connected(2, 5));
    }
}