/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode newNext = null;
        ListNode itr = head;
        while(itr!=null){
            ListNode currentNext = itr.next;
            itr.next = newNext;
            newNext = itr;
            itr = currentNext;
        }
        return newNext;
    }
}