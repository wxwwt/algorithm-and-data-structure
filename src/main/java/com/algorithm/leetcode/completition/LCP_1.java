package com.algorithm.leetcode.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author scott
 * @date 2023/7/30 10:08
 */
public class LCP_1 {

//    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
//        int count = 0;
//        for (int i = 0; i < hours.length; i++) {
//            if (hours[i] >= target) {
//                count++;
//            }
//        }
//        return count++;
//    }

//    public int furthestDistanceFromOrigin(String moves) {
//        char[] chars = moves.toCharArray();
//        int[] arr = new int[3];
//        for (char c : chars) {
//            if (c == 'L') {
//              int t = arr[0] ;
//              arr[0] =  ++t;
//            } else if (c == 'R') {
//                int t = arr[1] ;
//                arr[1] =  ++t;
//            } else {
//                int t = arr[2] ;
//                arr[2] =  ++t;
//            }
//        }
//
//        if (arr[0] >= arr[1]) {
//           return  arr[2] + arr[0] - arr[1] ;
//        } else {
//            return arr[2] + arr[1] - arr[0];
//        }
//    }

    public long minimumPossibleSum(int n, int target) {

        Set<Integer> set = new HashSet<>();
        long ans = 0;
        int num = 1;
        while (set.size() < n) {
            int temp = target - num;
            if (!set.contains(temp)) {
                set.add(num);
                ans += num;
            }
            num++;
        }
        return ans;
    }

    public long minimumPossibleSum1(int n, int target) {
        long ans=0;
        //cnt记录选择的数字个数
        int cnt=0;
        //从最小的正整数num=1开始计算，保证和最小
        int num=1;
        TreeSet<Integer> set=new TreeSet<>();
        while(cnt<n){
            if(!set.contains(target-num)){
                set.add(num);
                ans+=num;
                cnt++;
            }
            num++;
        }
        return ans;
    }



    @Test
    public void test1() {
        Assert.assertEquals(4, minimumPossibleSum(2,3));
        Assert.assertEquals(8, minimumPossibleSum(3,3));
        Assert.assertEquals(1, minimumPossibleSum(1,1));
        Assert.assertEquals(12, minimumPossibleSum(4,4));

        Assert.assertEquals(2948940321L, minimumPossibleSum(63623,82276));
//        System.out.println(Math.pow(10, 5));
    }
}