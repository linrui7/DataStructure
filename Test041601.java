package com.github7;
/*
    运用栈，检查括号是否匹配
    Name:  linrui
    Date: 2019/4/16
*/

import java.util.Stack;

public class Test041601 {

    boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        //取出字符串中的每一个括号
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //如果遇到左括号，进行压栈，
            //如果遇到右括号，进行出栈
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    //如果此时遇到了右括号
                    if (stack.isEmpty()) {
                        return false;
                    }
                    //如果此时栈中保存着左括号,看与右括号是否匹配
                    //移除栈顶元素
                    char left = stack.pop();
                    //如果不匹配
                    if (!((left == '(' && ch == ')') || (left == '{' && ch == '}') || (left == '[' && ch == ']'))) {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }
        //此时字符串中字符已经都走过了
        //栈中应该是空的
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Test041601 test041601=new Test041601();
        boolean b=test041601.isValid("{{}}");
        System.out.println(b);
    }
}
