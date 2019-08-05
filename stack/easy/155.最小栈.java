import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (49.34%)
 * Likes:    253
 * Dislikes: 0
 * Total Accepted:    36.4K
 * Total Submissions: 73.7K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 
 * 
 * 示例:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 */
class MinStack {
    
    class TreeNode{
        int val;
        TreeNode next;
        TreeNode(int x){
            this.val = x;
            this.next = null;
        }
    }
    Stack<Integer>  stack;
    TreeNode minList ;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minList = new TreeNode(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        stack.push(x);
        TreeNode node = this.minList;
        while(node != null && x > node.val)
            node = node.next;
        if(node == null)
            this.minList = new TreeNode(x);
        else
            node.
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

