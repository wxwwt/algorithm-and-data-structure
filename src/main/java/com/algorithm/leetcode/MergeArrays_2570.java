package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author scott
 * @date 2023/8/10 22:44
 */
public class MergeArrays_2570 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] arr : nums1) {
            map.put(arr[0], arr[1]);
        }

        for (int[] arr : nums2) {
            if (map.containsKey(arr[0])) {
                map.put(arr[0], map.get(arr[0]) + arr[1]);
            } else {
                map.put(arr[0], arr[1]);
            }
        }

       int[][] r =  new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] t = {entry.getKey(), entry.getValue()};
            r[i++] = t;
        }
        return r;
    }

    @Test
    public void test1() {
        int[][] arr = {{1,6},{2,3},{3,2},{4,6}};
        int [][] a1 = {{1,2},{2,3},{4,5}};
        int [][] a2 = {{1,4},{3,2},{4,1}};
        Assert.assertArrayEquals(arr, mergeArrays(a1, a2));


//      int[][] a11 =  {{148,597},{165,623},{306,359},{349,566},{403,646},{420,381},{566,543},{730,209},{757,875},{788,208},{932,695}};
//
//
//        int [][] a22 = {{74,669},{87,399},{89,165},{99,749},{122,401},{138,16},{144,714},{148,206},{177,948},{211,653},{285,775},{309,289},{349,396},{386,831},{403,318},{405,119},{420,153},{468,433},{504,101},{566,128},{603,688},{618,628},{622,586},{641,46},{653,922},{672,772},{691,823},{693,900},{756,878},{757,952},{770,795},{806,118},{813,88},{919,501},{935,253},{982,385}};
//        Assert.assertArrayEquals(arr, mergeArrays(a11, a22));
    }
}