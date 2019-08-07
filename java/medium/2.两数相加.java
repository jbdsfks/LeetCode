/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (34.17%)
 * Likes:    2433
 * Dislikes: 0
 * Total Accepted:    131.9K
 * Total Submissions: 386K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = l1.val + l2.val;

        ListNode ln = new ListNode(num % 10);
        int add_num = num / 10;
        ListNode temp_ln = ln;
        while (l1.next != null && l2.next != null) {

            l1 = l1.next;
            l2 = l2.next;
            int temp = l1.val + l2.val + add_num;
            add_num = temp / 10;
            ListNode temp_ln_e = new ListNode(temp % 10);
            temp_ln.next = temp_ln_e;
            temp_ln = temp_ln_e;
        }
        if (l1.next == null) {
            l2.val = l2.val + add_num;
            temp_ln.next = l2.next;
        } else if (l2.next == null) {
            l1.val = l1.val + add_num;
            temp_ln.next = l1.next;
        }
        return ln;
    }
}
