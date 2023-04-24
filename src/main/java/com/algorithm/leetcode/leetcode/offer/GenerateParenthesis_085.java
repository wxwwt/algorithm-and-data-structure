package com.algorithm.leetcode.leetcode.offer;


import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * @author scott
 * @date 2023/4/18 8:49
 */
public class GenerateParenthesis_085 {

//    public List<String> generateParenthesis(int n) {
//        List<String> list = new ArrayList<String>();
//        if (n == 1) {
//            list.add("()");
//            return list;
//        }
//
//        list.add("()");
//        for (int i = 2; i < n; i++) {
//            for (int j = 0; j < list.size(); j++) {
//                StringBuilder builder = new StringBuilder(list.get(0));
////                builder.
//            }
//        }
//
//    }


//    public void add(String raw, List<String> total) {
//        StringBuilder builder = new StringBuilder(raw);
//        int lastIndex = raw.length() - 1;
//        for (int i = 0; i < lastIndex; i++) {
//            builder.insert(0, )
//        }
//    }


    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        Set<String> hs = new HashSet<>();
        for (String s : generateParenthesis(n-1)) {
            for (int i = 0; i < 2*n-2; i++) {
                hs.add(s.substring(0,i) + "()" + s.substring(i,s.length()));
            }
        }
        return new ArrayList(hs);
    }

    @Test
    public void test1() {
        Assertions.assertTrue(generateParenthesis(1).containsAll(Lists.newArrayList("()")));

        Assertions.assertTrue(generateParenthesis(3).containsAll(Lists.newArrayList("((()))","(()())","(())()","()(())","()()()")));

    }

}