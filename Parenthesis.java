package com.github7;
/*
   Author:linrui
   Date:2019/5/22
   Content:对于一个字符串，判断其是否为一个合法的括号串
   eg1："((()))123"  true
   eg2: ")((5a)"     false
*/


import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) {
        String  str="((()))";
        chkParenthesis(str,6);
    }

    public static boolean chkParenthesis(String A, int n) {
        //判断括号匹配问题可以进行压栈，如果遇到相匹配的进行出栈
        //最后检查栈中剩余的
        Stack<Character> stack = new Stack();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ']':
                    //判断是否有左括号
                    if(stack.isEmpty()){
                        return false;
                    }
                    //移除栈顶元素，看是否与当前的右括号匹配
                    char left=stack.pop();
                    if (left != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty()){
                        return false;
                    }
                    char left1=stack.pop();
                    if (left1 != '{') {
                        return false;
                    }
                    break;
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }
                    char left2=stack.pop();
                    if (left2 != '(') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        //最后检查栈中是否还存在着括号
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}