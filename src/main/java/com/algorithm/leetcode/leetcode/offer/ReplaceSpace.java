package com.algorithm.leetcode.leetcode.offer;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scott
 * @date 2022/6/5 23:25
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
           if ( 32 == s.charAt(i)) {
                list.add(i);
           }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i <= 0) {
                s = s.substring(0, list.get(i)) + "%20" + s.substring(list.get(i) + 1);

            } else {
                s = s.substring(0, list.get(i) + 2 * i) + "%20" + s.substring(list.get(i) + 2*i+ 1);
            }
        }
        return s;
    }

    @Test
    public void test1(){
  //      Assertions.assertEquals("We%20are%20happy.", replaceSpace("We are happy."));
        Assertions.assertEquals("%20%20%20%20%20", replaceSpace("     "));
    }
}