package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 232. Implement Queue using Stacks
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * @Author lzj
 * @Date 2019/5/7 20:20
 */
public class ImplementQueueUsingStacks {
    static class MyQueue {

        Deque<Integer> stack;
        /** Initialize your data structure here. */
        public MyQueue() {
            this.stack = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            this.stack.addLast(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return this.stack.pollFirst();
        }

        /** Get the front element. */
        public int peek() {
            return this.stack.peekFirst();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return this.stack.isEmpty();
        }
    }
}
