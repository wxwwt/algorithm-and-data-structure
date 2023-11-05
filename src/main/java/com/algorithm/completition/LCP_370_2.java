package com.algorithm.completition;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LCP_370_2 {


    static Map<Integer, List<Integer>> map = new HashMap<>();
    public int findChampion(int n,int[][] grid) {

        int c = grid.length;
        if (c < n - 1) {
            return -1;
        } else {
            if (c == 0) {
                return 0;
            }
        }
        int r = grid[0].length;
        Set<Integer> winner = new HashSet<>();
        int ans = -1;
        // 孩子指向父亲
       map = new HashMap<>();
        for (int i = 0; i < c ; i++) {
            int x = grid[i][0];
            int y = grid[i][1];

                   List<Integer> list = map.getOrDefault(y, new ArrayList<>());
                   list.add(x);
                    map.put(y, list);


        }

        if (map.size() < n - 1) {
            return -1;
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> paList = getPaList(entry.getKey());
            winner.addAll(paList);
        }
        return winner.size() >1 ? -1 : winner.stream().findFirst().get();
    }

    public List<Integer> getPaList(int i) {
        List<Integer> ans = new ArrayList<>();
       List<Integer> paList =  map.get(i);
       if (paList == null) {
           ans.add(i);
       } else {
               for (int curI: paList) {
                 List<Integer> result =  getPaList(curI);
                   ans.addAll(result);
               }

       }
       return ans;
    }


    @Test
    public void test() {
//        Assert.assertEquals(0, findChampion(new  int[][]{{0,1},{0,0}}));

        Assert.assertEquals(-1, findChampion(4, new  int[][]{{0,1},{2,0},{2,1}}));
        Assert.assertEquals(0, findChampion(3, new  int[][]{{0,1},{1,2}}));
        Assert.assertEquals(-1, findChampion(3, new  int[][]{{0,2},{1,3},{1,2}}));
        Assert.assertEquals(-1, findChampion(3, new  int[][]{{0,2},{1,2},{3,2}}));
        Assert.assertEquals(-1, findChampion(2, new  int[][]{}));
        Assert.assertEquals(0, findChampion(1, new  int[][]{}));
        Assert.assertEquals(-1, findChampion(3, new  int[][]{}));
        Assert.assertEquals(-1, findChampion(3, new  int[][]{{0,1}}));

//        Assert.assertEquals(-1, findChampion(3, new  int[][]{{0,2},{1,0},{2,1}}));


//        [[0,0],[1,0]]
    }
}
