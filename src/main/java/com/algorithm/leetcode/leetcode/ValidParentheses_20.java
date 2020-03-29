package com.algorithm.leetcode.leetcode;


import org.springframework.util.Assert;

/**
 * @author scott
 * @date 2020/3/26 21:19
 */
public class ValidParentheses_20 {


    public static boolean isValid(String s) {
        char[] tempArr = s.toCharArray();
        char[] stack = new char[tempArr.length];
        int stackNumber = 0;
        for (int i = 0; i < tempArr.length; i++) {
            if (0 == stackNumber) {
                stack[0] = tempArr[i];
                ++stackNumber;
            } else {
                // 当前准备放入的元素和栈内的元素比较
                // 1.如果能匹配就将栈里元素弹出 当前元素也跳过
                // 2.如果不能匹配 就放入栈中
                switch (stack[stackNumber - 1]) {
                    case '[':
                        if (tempArr[i] == ']') {
                            stack[stackNumber - 1] = '\u0000';
                            --stackNumber;
                            continue;
                        } else {
                            ++stackNumber;
                            stack[stackNumber - 1] = tempArr[i];

                        }
                        break;
                    case '(':
                        if (tempArr[i] == ')') {
                            stack[stackNumber - 1] = '\u0000';
                            --stackNumber;
                            continue;
                        } else {
                            ++stackNumber;
                            stack[stackNumber - 1] = tempArr[i];

                        }
                        break;
                    case '{':
                        if (tempArr[i] == '}') {
                            stack[stackNumber - 1] = '\u0000';
                            --stackNumber;
                            continue;
                        } else {
                            ++stackNumber;
                            stack[stackNumber - 1] = tempArr[i];

                        }
                        break;
                    default:
                        break;
                }
            }

        }
        return stackNumber == 0;

    }


    public static void main(String[] args) {
        Assert.isTrue(isValid("()"), "答案1错误");
        Assert.isTrue(isValid("()[]{}"), "答案2错误");
        Assert.isTrue(!isValid("(]"), "答案3错误");
        Assert.isTrue(!isValid("([)]"), "答案4错误");
        Assert.isTrue(isValid("{[]}"), "答案5错误");
        Assert.isTrue(isValid(""), "答案6错误");

    }
}