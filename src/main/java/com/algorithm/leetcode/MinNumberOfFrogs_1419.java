package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MinNumberOfFrogs_1419 {

    static Map<Character, Integer> map = new HashMap<>() {{
        put('c', 0);
        put('r', 1);
        put('o', 2);
        put('a', 3);
        put('k', 4);
    }};



    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) {
            return -1;
        }
        char[] chars = croakOfFrogs.toCharArray();
        int[] arr = new int[5];
        int n = chars.length;
        int ans = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int index = map.get(chars[i]);
            arr[index]++;
            if (chars[i] == 'c') {
                count++;
            } else {
                if (arr[index - 1] < arr[index]) {
                    // 如果上一个字母出现的比当前字母少 就说明无法凑成croak 直接返回-1
                    return -1;
                }

                if (chars[i] == 'k') {
                    ans = Math.max(count, ans);
                    count--;
                }
            }
        }

        if (arr[0] != arr[4]) {
            return -1;
        }
        return ans;
    }

    private static final char[] PREVIOUS = new char['s'];

    static { // 预处理每个字母在 "croak" 中的上一个字母
        var s = "croakc".toCharArray();
        for (int i = 1; i < s.length; i++)
            PREVIOUS[s[i]] = s[i - 1];
    }

    public int minNumberOfFrogs2(String croakOfFrogs) {
        var cnt = new int['s'];
        for (var ch : croakOfFrogs.toCharArray()) {
            var pre = PREVIOUS[ch]; // pre 为 ch 在 "croak" 中的上一个字母
            if (cnt[pre] > 0) {// 如果有青蛙发出了 pre 的声音
                cnt[pre]--;
            }// 复用一只
            else if (ch != 'c') { // 否则青蛙必须从 'c' 开始蛙鸣
                return -1;
            }// 不符合要求
            cnt[ch]++; // 发出了 ch 的声音
        }
        if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0)
            return -1; // 有发出其它声音的青蛙，不符合要求
        return cnt['k']; // 最后青蛙们都发出了 'k' 的声音
    }



    @Test
    public void test() {
//        Assert.assertEquals(-1, minNumberOfFrogs("croa"));
        Assert.assertEquals(1, minNumberOfFrogs("croak"));
        Assert.assertEquals(1, minNumberOfFrogs("croakcroak"));
        Assert.assertEquals(2, minNumberOfFrogs("crcoakroak"));
        Assert.assertEquals(-1, minNumberOfFrogs("croakcrook"));
        Assert.assertEquals(-1, minNumberOfFrogs("croacroak"));
        Assert.assertEquals(-1, minNumberOfFrogs("croakcroa"));
        Assert.assertEquals(2, minNumberOfFrogs("ccrrooaakk"));
        Assert.assertEquals(-1, minNumberOfFrogs("cccccccrrooaakk"));

    }
}
