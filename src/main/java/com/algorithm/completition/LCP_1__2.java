//package com.algorithm.leetcode.completition;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//
///**
// * @author scott
// * @date 2023/7/30 10:08
// */
//public class LCP_1__2 {
//
//    int fx, fy,  t;
//    boolean value = false;
//
//    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
//        if (sx == fx && sy == fy && t == 1) {
//            return false;
//        }
//        this.fx = Math.abs(sx - fx);
//        this.fy = Math.abs(sy - fy);
//        this.t = t;
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.add(new int[]{0,0});
//        queue.add(new int[]{fx, fy});
//        int hasUsedT = 0;
//        while (!queue.isEmpty()) {
//            int[] arr = queue.poll();
//            int c = arr[0];
//            int r = arr[1];
//            if (0 <= c && c <= fx && 0 <= r && r <= fy && hasUsedT <= t) {
//                if (c == fx && r == fy) {
//                    value = true;
//                }
//                queue.add(new int[]{ c + 1, r});
//                queue.add(new int[]{ c - 1, r});
//
//                queue.add(new int[]{ c, r + 1});
//                queue.add(new int[]{ c, r - 1});
//
//                queue.add(new int[] {c - 1, r + 1});
//                queue.add(new int[]{ c - 1, r - 1});
//
//                queue.add(new int[]{ c + 1, r + 1});
//                queue.add(new int[]{ c + 1, r - 1});
//        }
//
//        return value;
//    }
//
////    public void bfs(int c, int r, int hasUsedT) {
////        // 要在地区范围之内 并且时间没有超过就继续走
////        if (0 <= c && c <= fx && 0 <= r && r <= fy && hasUsedT <= t) {
////            if (c == fx && r == fy) {
////                value = true;
////            }
////
////           queue.add(new int[]{ c + 1, r});
////           queue.add(new int[]{ c - 1, r});
////
////           queue.add(new int[]{ c, r + 1});
////           queue.add(new int[]{ c, r - 1});
////
////           queue.add(new int[] {c - 1, r + 1});
////           queue.add(new int[]{ c - 1, r - 1});
////
////           queue.add(new int[]{ c + 1, r + 1});
////           queue.add(new int[]{ c + 1, r - 1});
////
////    }
//
//    @Test
//    public void test1() {
//        Assert.assertTrue(isReachableAtTime(2, 4, 7, 7, 6));
//    }
//
//    @Test
//    public void test2() {
//        Assert.assertFalse(isReachableAtTime(3, 1, 7, 3, 3));
//    }
//
//    @Test
//    public void test3() {
//        Assert.assertEquals(true, isReachableAtTime(1,1,1,3,2));
//    }
//
//    @Test
//    public void test4() {
//        Assert.assertEquals(true, isReachableAtTime(1,2,1,1,2));
//    }
//
//    @Test
//    public void test5() {
//        Assert.assertEquals(false, isReachableAtTime(1,2,1,2,1));
//    }
//
//    @Test
//    public void test6() {
//        Assert.assertEquals(true , isReachableAtTime(1,1,4,5,9));
//
//    }
//
//
//}