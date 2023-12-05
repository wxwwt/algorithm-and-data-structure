package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CountCompleteSubstrings_100145 {

    public int countCompleteSubstrings(String word, int k) {
        char[] chars = word.toCharArray();
        int count = 0;
        int n = chars.length;
        int s = 0;
        for (int i = 0; i < n; i++) {
            if ((i + 1 < n && Math.abs(chars[i + 1] - chars[i] )> 2 )|| i == n -1) {
                count += deal(word.substring(s, i + 1), k);
                s = i + 1;
            }
        }
        return count;
    }


    public int deal(String word,  int k) {
        int count = 0;
        for (int i = 1; i <= 26 && i * k <= word.length() ; i++) {
            int[] cnt = new int[26];
            for (int j = 0; j < word.length(); j++) {
                cnt[word.charAt(j) - 'a']++;
                int l = j + 1 - i * k;
                if (l >= 0) {
                    boolean plus = true;
                    // 如果是k的倍数 就可能是符合的 就判断下
                    if ((j + 1 - l) % k == 0) {
                        for (int c : cnt) {
                            if (c != 0 && c != k) {
                                plus = false;
                                break;
                            }
                        }

                        if (plus) {
                            count++;
                        }
                        cnt[word.charAt(l) - 'a']--;
                    }
                }
            }
        }


        return count;
    }





    @Test
    public void test1() {
        Assert.assertEquals(1, countCompleteSubstrings("ziifzzzf", 3));
        Assert.assertEquals(3, countCompleteSubstrings("igigee", 2));
        Assert.assertEquals(6, countCompleteSubstrings("aaabbbccc", 3));
    }
}
