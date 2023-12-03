package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MaximumBalancedSubsequenceSum_100112 {

    public long maxBalancedSubsequenceSum1(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        long sum = nums[0];
        // 表示以nums[i]结尾的最大
        dp[0] = nums[0];
        int[] max = new int[n];
        max[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[max[i-1]]) {
                max[i] = i;
            } else {
                max[i] = max[i-1];
            }
        }

        for (int i = 1; i < n; i++) {
            int j = max[i -1];
            if (nums[i] - nums[j] >=  i-j) {
                dp[i] = Math.max(dp[j] + nums[i], nums[i]);
            } else {
                while (j > 0 && nums[i] - nums[j] < i - j) {
                    j--;
                }

                if (nums[i] - nums[j] > i - j) {
                    dp[i] = Math.max(dp[j] + nums[i], nums[i]);
                } else {
                    dp[i] = nums[i];
                }

            }
            sum = Math.max(dp[i], sum);
        }
        return sum;
    }

    public long maxBalancedSubsequenceSum2(int[] nums) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        Long max = (long)nums[0];
        for (int i = 0; i < nums.length; i ++) {
            max = Math.max(nums[i], max);
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] < 0) {
                continue;
            }
            Map.Entry<Integer,Long> entry = map.floorEntry(nums[i] - i);
            if (entry != null) {
                map.put(nums[i] - i, entry.getValue() + nums[i]);
                max = Math.max(max, entry.getValue() + nums[i]);
            } else {
                map.put(nums[i] - i, (long)nums[i]);
                max = Math.max(max, nums[i]);
            }
            Map.Entry<Integer,Long> node = map.ceilingEntry(nums[i] - i + 1);
            while (node != null && node.getValue() <= map.get(nums[i] - i)) {
                map.remove(node.getKey());
                node = map.ceilingEntry(nums[i] - i + 1);
            }
        }
        return max;


    }

    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        long[] tmp = new long[n];
        for(int i = 0;i < n;++i){
            tmp[i] = nums[i] - i;
        }
        Arrays.sort(tmp);
        BinIndexTree bit = new BinIndexTree(n);
        for(int i = 0;i < n;++i){
            // 排序+二分对nums[i]-i做离散化处理
            int idx = lower_bound(tmp, nums[i]-i) + 1;
            long dp = bit.query(idx) + nums[i]; // 求dp[i]
            bit.update(idx, dp);    // 用dp[i]更新树状数组
            ans = Math.max(dp, ans);
        }
        return ans;
    }

    /**
     * 二分求离散值的下标
     * @param arr
     * @param target
     * @return
     */
    public int lower_bound(long[] arr, long target){
        int l = 0, r = arr.length;
        while(l <= r){
            int mid = (l+r)>>1;
            if(arr[mid] >= target) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }


    /**
     * 树状数组的模板
     */
    class BinIndexTree {
    public int n;
    public long[] tree;

    BinIndexTree(int _n) {
        this.n = _n;
        this.tree = new long[n + 1];
    }

    static int lowbit(int x) {
        return x & (-x);
    }

    public long query(int x) {
        long ret = 0;
        while (x > 0) {
            ret = Math.max(ret, tree[x]);
            x -= lowbit(x);
        }
        return ret;
    }

    public void update(int x, long val) {
        while (x <= n) {
            tree[x] = Math.max(tree[x], val);
            x += lowbit(x);
        }
    }

}




    @Test
    public void test() {
        Assert.assertEquals(14, maxBalancedSubsequenceSum(new int[]{3,3,5,6}));
//        Assert.assertEquals(13, maxBalancedSubsequenceSum(new int[]{5,-1,-3,8}));
//        Assert.assertEquals(-1, maxBalancedSubsequenceSum(new int[]{-2,-1}));
//
//        Assert.assertEquals(65, maxBalancedSubsequenceSum(new int[]{34,34,32,33}));
//        []

    }
}
