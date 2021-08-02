package priv.yins.leetcode.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @ClassName: Day9
 * @Description: 20. 有效的括号 232. 用栈实现队列
 * @Author: yinshuang
 * @Date: 2021/7/23 11:57
 * @Version: 1.0
 */
public class Day9 {
    /**
     * 20. 有效的括号
     */
    public boolean isValid(String s) {
        if (s.length() <= 1 || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                if (stack.isEmpty() || !Objects.equals(stack.pop(), map.get(s.charAt(i)))) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty() ? true : false;
    }
}

/**
 * 232. 用栈实现队列
 */
//class MyQueue {
//    private Stack<Integer> queue;
//    private Stack<Integer> temp;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public MyQueue() {
//        queue = new Stack<>();
//        temp = new Stack<>();
//    }
//
//    /**
//     * Push element x to the back of queue.
//     */
//    public void push(int x) {
//        while (!queue.isEmpty()) {
//            temp.push(queue.pop());
//        }
//        queue.push(x);
//        while (!temp.isEmpty()) {
//            queue.push(temp.pop());
//        }
//    }
//
//    /**
//     * Removes the element from in front of queue and returns that element.
//     */
//    public int pop() {
//        return queue.pop();
//    }
//
//    /**
//     * Get the front element.
//     */
//    public int peek() {
//        return queue.peek();
//    }
//
//    /**
//     * Returns whether the queue is empty.
//     */
//    public boolean empty() {
//        return queue.isEmpty();
//    }
//}
