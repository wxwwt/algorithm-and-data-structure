package com.algorithm.leetcode.leetcode;

import com.algorithm.leetcode.leetcode.template.UnionFindQuickUnion;

/**
 * @author scott
 * @date 2023/8/14 8:31
 */
public class SwimInWater_778 {

    public int swimInWater(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int n = r * c;
        int[] index = new int[n];
        // 先把所有元素按照顺序放入到数组中
        for (int i = 0; i < n ; i++) {



        }

        // 在使用并查集 随着i++ 就是时间的增加 把小于等于i的元素连起来
        // 只要左上角(0,0) 和右下角(n-1,n-1)相连了就返回当时的时间i
        UnionFindQuickUnion uf = new UnionFindQuickUnion(n);
        for (int i = 0; i < n ;i++) {

            if (uf.isConnected(0, n - 1)) {
                return i;
            }
        }
        return -1;
    }



}

