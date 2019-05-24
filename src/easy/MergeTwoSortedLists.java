package easy;

/**
 * @Description 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * @Author lzj
 * @Date 2019/5/24 18:52
 */
public class MergeTwoSortedLists {
    static /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
            }
        }
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            ListNode result = null;
            ListNode resTemp = null;
            while (l1 != null && l2!=null)
            {
                ListNode temp;
                if (l1.val < l2.val){
                    temp = new ListNode(l1.val);
                    l1 = l1.next;
                }else {
                    temp = new ListNode(l2.val);
                    l2 = l2.next;
                }
                if (result == null){
                    result = temp;
                    resTemp = result;
                }else {
                    resTemp.next = temp;
                    resTemp = temp;
                }
            }
            if (l1 != null)
                resTemp.next = l1;
            else resTemp.next = l2;
            return result;
        }
    }
}
