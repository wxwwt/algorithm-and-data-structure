package com.algorithm.completition;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCP_370_1 {


    public int findChampion(int[][] grid) {
        int c = grid.length;
        int r = grid[0].length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < c ; i++) {
            for (int j = 0; j < r; j++) {
                if (grid[i][j] == 1) {
                   map.put(j, i);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           int pa =  entry.getValue();
           while (map.get(pa) != null) {
                   pa = map.get(pa);
           }
           ans = pa;
        }
        return ans;
    }



    @Test
    public void test() {
//        Assert.assertEquals(0, findChampion(new  int[][]{{0,1},{0,0}}));

        Assert.assertEquals(1, findChampion(new  int[][]{{0,0},{1,0}}));

//        [[0,0],[1,0]]
    }
}
