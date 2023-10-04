package com.algorithm.leetcode.template;

/**
 * @author scott
 * @date 2023/8/14 8:37
 */
public class UnionFind2 {

    public int[] root;

    public UnionFind2(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }


    public int find(int x) {
        while (root[x] != x) {
            return root[x] = find(root[x]);
        }
        return x;
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            root[yRoot] = xRoot;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        // 下面的例子就更好理解了，我们先初始化并查集一共6个元素，就是上面图中的元素
        // 在图中的连接情况 把0,1,2连起来，3,4连起来，并用connected()测试下元素的连通性
        // 最后我们把元素5加入到1的集合中，测试下2和5的连通性，发现确实2和5也相连了，程序测试完成。
        UnionFind2 uf = new UnionFind2(6);
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