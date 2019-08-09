package com.github7.QueueAndStack;
/*
   Author:linrui
   Date:2019/8/9
   Content: 检查括号是否匹配。
*/

import java.util.Stack;

public class KuoHaoStack {

    public static void main(String[] args) {
        System.out.println( isRight("((([[]])))"));
    }
    //输入一串括号，看是否匹配eg{{}}
     static  boolean isRight(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.empty()) {
                        return false;
                    } else {
                        if (stack.peek() == '(') {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    }
                case '}':
                    if (stack.empty()) {
                        return false;
                    } else {
                        if (stack.peek() == '{') {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    }
                case ']':
                    if (stack.empty()) {
                        return false;
                    } else {
                        if (stack.peek() == '[') {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    }
                default:
                    break;
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

}
