package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author scott
 * @date 2022/4/10 18:02
 */
public class UniqueMorseCodeWords_804 {

    private final Map<Character, String> map = new HashMap<Character, String>() {{
        put('a', ".-");
        put('b', "-...");
        put('c', "-.-.");
        put('d', "-..");
        put('e', ".");
        put('f', "..-.");
        put('g', "--.");
        put('h', "....");
        put('i', "..");
        put('j', ".---");
        put('k', "-.-");
        put('l', ".-..");
        put('m', "--");
        put('n', "-.");
        put('o', "---");
        put('p', ".--.");
        put('q', "--.-");
        put('r', ".-.");
        put('s', "...");
        put('t', "-");
        put('u', "..-");
        put('v', "...-");
        put('w', ".--");
        put('x', "-..-");
        put('y', "-.--");
        put('z', "--..");
    }};

    /**
     * 最容易想到的直接用一个set储存出现过的单词的morse电码的值
     *
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> hashSet = new HashSet<>();
        for (String item : words) {
            StringBuilder builder = new StringBuilder();
            for (char curChar : item.toCharArray()) {
                builder.append(map.get(curChar));
            }
            hashSet.add(builder.toString());
        }
        return hashSet.size();
    }

    private final String[] strArr = new String[]{
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."};

    /**
     * 方法一的优化版本方法二，就是用一个String[]来代替HashMap，内存和查询效率都有响应的提升。
     * 因为是26字母，所以是有顺序的，只要用26字母的ASCII值减去a的ASCII值，就是String数组的
     * 下标的值。
     * 感觉这里是考察ascii的知识，char和int之间的关系。
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations2(String[] words) {
        Set<String> hashSet = new HashSet<>();
        for (String item : words) {
            StringBuilder builder = new StringBuilder();
            for (char curChar : item.toCharArray()) {
                builder.append(strArr[curChar - 'a']);
            }
            hashSet.add(builder.toString());
        }
        return hashSet.size();
    }

    /**
     * 方法三在方法二的基础上，修改了StringBuilder的使用，之前是每次遍历words都重新创建一个，
     * 这里使用StringBuilder清理方法，这样可以少创建一些对象，
     * 只会创建一个StringBuilder, 优化的是空间复杂度。
     * 这里涉及到StringBuilder的清理，参考了一篇博文：
     * https://www.cnblogs.com/kissfu/p/4105646.html
     * 结果令我比较差异的是，优化后，时间竟然变慢了1ms。。。看来setLength和delete的性能消耗，
     * 要比创建一个StringBuilder要大吧。
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations3(String[] words) {
        Set<String> hashSet = new HashSet<>();
        StringBuffer builder = new StringBuffer();
        for (String item : words) {
          builder.setLength(0);
            for (char curChar : item.toCharArray()) {
                builder.append(strArr[curChar - 'a']);
            }
            hashSet.add(builder.toString());
        }
        return hashSet.size();
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        Assert.assertEquals(1, uniqueMorseRepresentations(new String[]{"a"}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, uniqueMorseRepresentations2(new String[]{"gin", "zen", "gig", "msg"}));
        Assert.assertEquals(1, uniqueMorseRepresentations2(new String[]{"a"}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(2, uniqueMorseRepresentations3(new String[]{"gin", "zen", "gig", "msg"}));
        Assert.assertEquals(1, uniqueMorseRepresentations3(new String[]{"a"}));
    }


}