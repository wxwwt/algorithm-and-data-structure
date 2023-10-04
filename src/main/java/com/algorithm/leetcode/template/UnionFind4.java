package com.algorithm.leetcode.template;

/**
 * @author scott
 * @date 2023/8/14 8:37
 */
public class UnionFind4 {

    public int root[];

    public UnionFind4(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // 优化点在这里 再查找父节点的同时会把根节点赋值给递归过程的其他元素
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
            root[rootY] = rootX;
        }
    };

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }



    public static void main(String[] args) throws Exception {
        // 下面的例子就更好理解了，我们先初始化并查集一共6个元素，就是上面图中的元素
        // 在图中的连接情况 把0,1,2连起来，3,4连起来，并用connected()测试下元素的连通性
        // 最后我们把元素5加入到1的集合中，测试下2和5的连通性，发现确实2和5也相连了，程序测试完成。
        UnionFind4 uf = new UnionFind4(6);
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