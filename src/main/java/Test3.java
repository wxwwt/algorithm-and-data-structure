import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scott
 * @date 2022/9/25 10:54
 */
public class Test3 {

    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.length / 2 == 0 && k == nums.length / 2) {
            return list;
        }

        int[][] dp = new int[nums.length][nums.length];
        for (int i = k; i < nums.length - 1 - k; i++) {
            if (findLeft(i, nums, dp) && findRight(i, nums, dp)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean findLeft(int k, int[] nums, int[][] dp) {
        // dp 初始化为0  nums[i] > nums[j] == 1
        // 小于就 -1 等于就 2
        for (int j = 0; j < k; j++) {

            int count = 1;
            for (int l = j + 1; j < k; k++) {
                if (dp[j][l] == 1) {
                    count++;
                } else {
                    if (nums[j] >= nums[l]) {
                        count++;
                        dp[j][l] = 1;
                    } else {
                        dp[j][l] = -1;
                    }
                }

                if (count >= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findRight(int k, int[] nums, int[][] dp) {
        for (int j = k + 1; j < nums.length - 1; j++) {
            int count = 1;
            for (int l = j + 1; j < k; k++) {
                if (dp[j][l] == -1) {
                    count++;
                } else {
                    if (nums[j] <= nums[l]) {
                        count++;
                        dp[j][l] = -1;
                    } else {
                        dp[j][l] = 1;
                    }
                }

                if (count >= k) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test1() {
//        Assert.assertEquals(new ArrayList<>(), goodIndices(new int[]{2, 1, 1, 2}, 2));
        Assert.assertEquals(new ArrayList<>(), goodIndices(new int[]{2,1,1,1,3,4,1}, 2));
    }
}