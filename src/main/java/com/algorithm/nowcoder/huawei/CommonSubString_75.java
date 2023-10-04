package com.algorithm.nowcoder.huawei;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author scott
 * @date 2022/9/24 10:30
 */
public class CommonSubString_75 {

//    public int getSubStringLength(String a, String b) {
//        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
//            return 0;
//        }
//        int lengthA = a.length();
//        int lengthB = b.length();
//        if (lengthA <= lengthB) {
//            return process(a.toCharArray(), b.toCharArray());
//        } else {
//            return process(b.toCharArray(), a.toCharArray());
//        }
//    }
//
//    public int process(char[] s, char[] l) {
//
//        int max = 0;
//        for (int i = 0; i < s.length; i++) {
//            int count = 0;
//            int index = i;
//            for (int j = 0; j < l.length; j++) {
//                if (s[index] == l[j]) {
//                    count++;
//                    index++;
//                }
//
//                if (index > s.length - 1 ) {
//                    break;
//                }
//            }
//            max = Math.max(count, max);
//        }
//        return max;
//    }

    @Test
    public void test1() {
        Assert.assertEquals(6, getSubStringLength("asdfas", "werasdfaswer"));
        Assert.assertEquals(1, getSubStringLength("a", "a"));
        Assert.assertEquals(4, getSubStringLength("addbbccaacbddbbb", "ddcddcbcdbcbbbdabdcddabddcadbbbbdddabacaadcdcaacd"));
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(process2(a.toCharArray(), b.toCharArray()));
    }


    public static int getSubStringLength(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return 0;
        }
        int lengthA = a.length();
        int lengthB = b.length();
        if (lengthA <= lengthB) {
            return process2(a.toCharArray(), b.toCharArray());
        } else {
            return process2(b.toCharArray(), a.toCharArray());
        }
    }

    public static int process(char[] s, char[] l) {

        int max = 0;
        for (int i = 0; i < s.length; i++) {
            int count = 0;
            int index = i;
            for (int j = 0; j < l.length; j++) {

                if (s[index] == l[j]) {
                    count++;
                    index++;
                }

                if (index > s.length - 1) {
                    break;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static int process2(char[] s, char[] l) {

        int max = 0;
        for (int i = 0; i < s.length; i++) {

            int index = i;
            for (int j = 0; j < l.length; j++) {
                int cur = j;
                int count = 0;
                while (index < s.length && cur < l.length ) {
                    if (s[index] == l[cur]) {
                        count++;
                        index++;
                        cur++;
                    } else {
                        index = i;
                        cur++;
                        count = 0;
                    }
                    max = Math.max(count, max);

                }



            }


        }
        return max;
    }


}
