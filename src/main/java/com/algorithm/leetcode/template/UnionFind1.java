package com.algorithm.leetcode.template;

/**
 * @author scott
 * @date 2023/8/7 22:39
 */
public class UnionFind1 {
    // 首先我们创建了一个数组 用来保存每个元素的根节点
   public int root[];

    // 然后我们根据元素的数量 初始化数组，数组的下标就是节点，数组的值就是元素i的根节点，一开始每个元素的根节点都是自己
    public UnionFind1(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // find找根节点，直接返回x对应的根节点root[x]
    public int find(int x) {
        return root[x];
    }

    // union合并两个元素x，y
    public void union(int x, int y) {
        // 先找到各自的根节点 一开始都是元素自己
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            // 因为两个根节点不一样 所以我们随便取一个元素的根节点作为新的根节点
            // 这里取的rootX为新的根节点，然后把原来所有根节点是rootY的都修改为rootX
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    ;

    // 判断两个元素是否相连 其实就是判断根节点是否相同 是对find()的一种运用
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }


    public static void main(String[] args) throws Exception {
        // 下面的例子就更好理解了，我们先初始化并查集一共6个元素，就是上面图中的元素
        // 在图中的连接情况 把0,1,2连起来，3,4连起来，并用connected()测试下元素的连通性
        // 最后我们把元素5加入到1的集合中，测试下2和5的连通性，发现确实2和5也相连了，程序测试完成。
        UnionFind1 uf = new UnionFind1(6);
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

