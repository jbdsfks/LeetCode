package medium;

/**
 * @Description 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 给出两个非空的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @Author lzj
 * @Date 2019/4/15 18:24
 */


public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        static ListNode buildFromIntArray(int[] l1) {
            ListNode L1 = new ListNode(l1[0]);
            ListNode temp = L1;
            for (int i = 1; i < l1.length; i++) {
                temp.next = new ListNode(l1[i]);
                temp = temp.next;
            }
            return L1;
        }

        void printListNode(ListNode L1) {
            while (L1 != null) {
                if (L1.next == null) {
                    System.out.print(L1.val);
                } else {
                    System.out.print(L1.val + "->");
                }
                L1 = L1.next;
            }
            System.out.println();
        }
    }


    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode(0);
        ListNode ln_temp = ln;
        ListNode ln_temp_0 = ln;
        int add_sum = 0;
        while (l1 != null && l2 != null) {
            add_sum = l1.val + l2.val + add_sum;
            ln_temp.val = add_sum % 10;
            ln_temp_0 = ln_temp;
            ln_temp.next = new ListNode(0);
            ln_temp = ln_temp.next;
            add_sum = add_sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                add_sum = add_sum + l1.val;
                ln_temp.val = add_sum % 10;
                ln_temp.next = new ListNode(0);
                add_sum = add_sum / 10;
                ln_temp_0 = ln_temp;
                ln_temp = ln_temp.next;
                l1 = l1.next;
            }
            if (add_sum > 0) {
                ln_temp.val = add_sum;
            } else {
                ln_temp_0.next = null;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
                add_sum = add_sum + l2.val;
                ln_temp.val = add_sum % 10;
                ln_temp.next = new ListNode(0);
                add_sum = add_sum / 10;
                ln_temp_0 = ln_temp;
                ln_temp = ln_temp.next;
                l2 = l2.next;
            }

        }
        if (add_sum > 0) {
            ln_temp.val = add_sum;
        } else {
            ln_temp_0.next = null;
        }
        return ln;
    }


    public static void main(String[] args) {
        System.out.println("First Test: ");

        int[] l1 = new int[]{2, 4, 3};
        int[] l2 = new int[]{5, 6, 4};
        ListNode L1 = ListNode.buildFromIntArray(l1);
        ListNode L2 = ListNode.buildFromIntArray(l2);

        ListNode res = addTwoNumbers(L1, L2);
        L1.printListNode(L1);
        System.out.println("+");
        L2.printListNode(L2);
        System.out.println("=");
        res.printListNode(res);

    }
}
