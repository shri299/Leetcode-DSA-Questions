/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode start = head;
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return slow;
            }
        }
        System.out.println(slow.val);

        return null;
    }
}