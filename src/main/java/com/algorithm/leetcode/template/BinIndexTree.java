package com.algorithm.leetcode.template;

public class BinIndexTree {


    static long[] c;
    int n;

    public BinIndexTree(int n) {
        this.n = n;
        c = new long[n + 1];
    }

    int lowbit(int x) {
        return x & (x ^ (x - 1));
    }

    /**
     * 更新一个元素，初始数组c都是0，所以可以用这个方法初始化c，这时候增加与更新是等价的
     *
     * @param p 更新第p个元素，索引从1开始
     * @param d 增加的值，不是更新后的值
     */
    public void update(int p, long d) {
        while (p <= n) {
            c[p] += d;
            p += lowbit(p);
        }
    }

    /**
     * 计算从第一个元素到第p个元素的和
     *
     * @param p
     * @return
     */
    public int query(int p) {
        int ret = 0;
        while (p > 0) {
            ret += c[p];
            p -= lowbit(p);
        }
        return ret;
    }

    /**
     * 计算从第s个元素到第e个元素的和
     *
     * @param s
     * @param e
     * @return
     */
    int query(int s, int e) {
        if (s > n || e < 1 || s > e || s < 1 || e > n) {
            return -1;
        }
        return query(e) - query(s - 1);
    }
}
