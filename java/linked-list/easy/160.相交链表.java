import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
 *
 * algorithms
 * Easy (46.32%)
 * Likes:    362
 * Dislikes: 0
 * Total Accepted:    36.5K
 * Total Submissions: 78.8K
 * Testcase Example:  '8\n[4,1,8,4,5]\n[5,0,1,8,4,5]\n2\n3'
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 
 * 如下面的两个链表：
 * 
 * 
 * 
 * 在节点 c1 开始相交。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2,
 * skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为
 * [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 
 * 
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB
 * = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为
 * [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 
 * 
 * 
 * 
 * 示例 3：
 * 
 * 
 * 
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为
 * 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 暴力法，对于每一个链表A节点，遍历链表B节点，看是否有相同节点
         * O(mn), O(1)
         */
        // ListNode p = headA;
        // while(p != null){
        //     ListNode q = headB;
        //     while(q != null){
        //         if( p == q)
        //             return p;
        //         q = q.next;
        //     }
        //     p = p.next;
        // }
        // return null;

        /**
         * 遍历链表 A 并将每个结点的地址/引用存储在哈希表中。
         * 然后检查链表 B 中的每一个结点​是否在哈希表中。
         * 若在，则返回当前节点
         * O(m+n)
         * O(m)或O(n)
         */
        // HashMap<ListNode, Integer> map = new HashMap<>();
        // ListNode p = headA;
        // while(p != null){
        //     map.put(p, 1);
        //     p = p.next;
        // }
            
        // ListNode q = headB;
        // while(q != null){
        //     if(map.containsKey(q))
        //         return q;
        //     q = q.next;
        // }
        // return null;

        /**
         * 双指针发
         * O(m+n)
         * O(1)或O(1)
         */

         ListNode p = headA;
         ListNode q = headB;
         while( p != q ){
             p = p == null ? headB : p.next;
             q = q == null ? headA : q.next;
         }
         return p;
    }
}

