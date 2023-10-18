package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class CheckArray_2772 {

    /**
     * 这一题区间的元素要一直操作减到0，可以使用差分数组来解决
     * 首先不管是差分数组还是原数组要能满足最后元素全部为0，那么不管是原数组还是差分数组第一个元素肯定可以通过减去diff[0]变成0,
     * 处理完第一个元素为0后，可以看做后面的数组就是从第二个元素开始的，所以在对第二个元素进行同样的操作，以此类推到最后一个元素也可以为0就返回true。
     * 构建一个差分数组用来范围从i到i+k,减去 nums[i]用来完成i到i+k变成0。
     * 如果diff[i] > 0, diff[i] ~ diff[i + k]范围的元素都是需要减1来慢慢达成为0的条件, 依次遍历下去
     * 前提是k < n , 要不然不满足题目要求，如果当前元素是i, 那就是i + k < n。
     * 如果nums[0] = 0, 那么就不用管第一个数了，跳过去看下一个数
     * 如果nums[0] < 0, 那肯定没法继续了，不可能达到都为0的情况了
     */
    public boolean checkArray1(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        for (int i = 0; i + k <= n; i++) {
            if (diff[i] > 0) {
                if (i + k < n) {
                    diff[i + k] += diff[i];
                }
                diff[i] = 0;

            } else if (diff[i] < 0) {
                return false;
            }
            // 还有diff[i] == 0 的情况直接跳过了
        }

        for (int i: diff) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * diff = n + 1的情况
     * @param nums
     * @param k
     * @return
     */
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        diff[n] = -nums[n-1];

        for (int i = 0; i + k <= n; i++) {
            if (diff[i] > 0) {
                diff[i + k] += diff[i];
                diff[i] = 0;

            } else if (diff[i] < 0) {
                return false;
            }
            // 还有diff[i] == 0 的情况直接跳过了
        }

        for (int i: diff) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }



    public boolean checkArray2(int[] nums, int k) {
        int n = nums.length;
        // 计算差分数组
        int[] f = new int[n + 1];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) f[i] = nums[i] - nums[i - 1];

        f[n] = -nums[n - 1];
        // 从左到右对差分数组里的每个元素进行操作
        for (int i = 0; i + k <= n; i++)
            if (f[i] > 0) {
                f[i + k] += f[i];
                f[i] = 0;
            }
        // 检查差分数组中是否所有元素均为 0
        for (int i = 0; i <= n; i++)
            if (f[i] != 0) return false;
        return true;

    }

    @Test
    public void test1() {
        Assert.assertEquals(false, checkArray(new int[]{60,78,96,97,97,97,49,7,97,97,97,99,97,97,97,97,85,97,97,97,37,5,1},20 ));
        Assert.assertEquals(true, checkArray(new int[]{2,2,3,1,1,0}, 3));
        Assert.assertEquals(false, checkArray(new int[]{1,3,1,1,0}, 3));

    }


}
