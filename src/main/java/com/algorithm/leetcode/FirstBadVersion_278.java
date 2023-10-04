package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/8/5 11:19
 */
public class FirstBadVersion_278 {

    public int firstBadVersion(int n) {
        int l = 1, r = n, mid;
        while (l < r) {
            mid = ((r - l) >> 1) + l;
            if (isBadVersion(mid)) {
                // 相当于nums[i] > target 因为targer之后都是错误版本，都是true ，修改右边界
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    boolean isBadVersion(int version) {
        return version >= 1;
    }

    @Test
    public void tet1() {
//        Assert.assertEquals(4, firstBadVersion(5));
        Assert.assertEquals(1, firstBadVersion(1));
    }
}