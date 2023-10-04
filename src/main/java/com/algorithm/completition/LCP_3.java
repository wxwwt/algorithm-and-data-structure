package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author scott
 * @date 2023/7/30 10:08
 */
public class LCP_3 {

//    public String minimumString(String a, String b, String c) {
//        String[] strings = new String[]{a, b, c};
//        List<Character> list = new ArrayList<>();
//        for (String s : strings) {
//            if (!list.contains(s.charAt(0))) {
//                list.add(s.charAt(0));
//            }
//        }
//        list.sort(Comparator.naturalOrder());
//        for (Character ch : list) {
//            for (String s : strings) {
//                if (ch.equals(s.charAt(0))) {
//                    a = a.substring(1);
//                }
//            }
//        }
//    }

    public String minimumString(String a, String b, String c) {
        List[] arr = new List[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new ArrayList<>();
        }
        String[] strings = new String[]{a, b, c};
        for (String s : strings) {
            List<String> temp = arr[s.charAt(0) - 'a'];
            String sub = s.substring( 1);
            if (!temp.contains(sub)) {
                temp.add(sub);
            }
            temp.sort(Comparator.naturalOrder());
        }

        // 在从a开始一个个遍历下去
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < arr.length;j++) {
            List<String> sArr = arr[j];
            if (sArr.size() != 0) {

                while (sArr.size() != 0) {
                    builder.append((char) (j + 'a'));
                    int i = 0;
                  String temp = sArr.get(i);
                    sArr.remove(i);
                    List<String> newSArr = arr[temp.charAt(0) - 'a'];
                    if (temp.substring(1).length() > 0) {
                        newSArr.add(temp.substring(1));
                        newSArr.sort(Comparator.naturalOrder());
                    }

                }

                }


        }
        return builder.toString();
    }

//    public static void main(String[] args) {
//        System.out.println('a' + 0);
//    }

    @Test
    public void test1() {
        Assert.assertEquals("aaabca", minimumString("abc", "bca", "aaa"));
    }
}