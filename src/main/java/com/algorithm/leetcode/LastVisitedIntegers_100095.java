package com.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LastVisitedIntegers_100095 {

    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();
        int n = words.size();
        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            if (words.get(i).equals("prev")) {
                    count++;
                    if (count > cache.size()) {
                        ans.add(-1);
                    } else {
                       int k = cache.size()  - count ;
                       ans.add(cache.get(k));
                    }
            } else {
                 count = 0;
                cache.add(Integer.valueOf(words.get(i)));
            }
        }
        return ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(Lists.newArrayList(-1,-1,-1), lastVisitedIntegers(Lists.newArrayList("prev","prev","prev","27")));
        Assert.assertEquals(Lists.newArrayList(2,1,-1), lastVisitedIntegers(Lists.newArrayList("1","2","prev","prev","prev")));
    }
}
