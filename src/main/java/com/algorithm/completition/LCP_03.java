package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author scott
 * @date 2023/8/6 10:58
 */
public class LCP_03 {

    int maxSer = 0;
    Stack<Pair> path = new Stack<>();
    List<Pair> trList = new ArrayList<>();
    Map<Pair, Integer> map = new HashMap<>();

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int r = grid.size(), c = grid.get(0).size();
        if (grid.get(0).get(0) == 1 || grid.get(r - 1).get(c - 1) == 1) {
            return 0;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0 ; j <c;j++) {
                if (grid.get(i).get(j) == 1) {
                    trList.add(new Pair(i, j));
                }
            }
        }

        path.add(new Pair(0, 0));
        dfs(0, 0, grid);
        return maxSer;
    }


    public void dfs(int r, int c, List<List<Integer>> grid) {
        if ((r > grid.size() - 1 || c > grid.get(0).size() - 1) || grid.get(r).get(c) == 1) {
            return;
        }

        // 走到终点更新最大的安全系数
        if (r == grid.size() - 1 && c == grid.get(0).size() - 1) {
            int ser = Integer.MAX_VALUE;
            for (Pair pathPair : path) {
                int cp = pathPair.getC();
                int rp = pathPair.getR();
                for (Pair pair : trList) {
                    // 一条路上算出 距离各个小偷的安全系数  最小的那个点 就是距离小偷最近的点
                    int ct = pair.getC();
                    int rt = pair.getR();
                    int MHD = 0;
                    String key = cp + "_" + rp + "_" + ct + "_" +rt;
                    if (map.containsKey(key)) {
                        MHD = map.get(key);
                    } else {
                         MHD = Math.abs(ct - cp) + Math.abs(rt - rp);
                        map.put(pathPair, MHD);
                    }

                    ser = Math.min(ser, MHD);
                }

            }

            // 在更新每条路上 哪条路离小偷最近的点 是最远的
            maxSer = Math.max(ser, maxSer);
            return;
        }


        path.add(new Pair(r, c+ 1));
        dfs(r , c + 1, grid);
        path.pop();

        path.add(new Pair( r + 1, c));
        dfs(r + 1, c, grid);
        path.pop();

    }

    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getC() {
            return c;
        }

        public int getR() {
            return r;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }


    @Test
    public void test1() {
        Assert.assertEquals(0, maximumSafenessFactor(List.of(List.of(1,0,0),List.of(0,0,0), List.of(0,0,1))));
        Assert.assertEquals(2, maximumSafenessFactor(List.of(List.of(0,0,1),List.of(0,0,0), List.of(0,0,0))));
        Assert.assertEquals(2, maximumSafenessFactor(List.of(List.of(0,0,0,1), List.of(0,0,0,0), List.of(0,0,0,0), List.of(1,0,0,0))));
    }
}