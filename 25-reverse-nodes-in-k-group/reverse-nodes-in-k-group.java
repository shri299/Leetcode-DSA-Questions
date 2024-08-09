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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;

        ListNode temp = null;
        ListNode curr = head;
        ListNode pre = null;
        int count = 0;
        while(curr != null && count < k){
            curr = curr.next;
            count++;
        }
        curr = head;
        if(count == k) {
            count = 0;
            while(curr != null && count < k){
                temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
                count++;
            }
        }else {
            pre = head;
        }
        if(temp != null){
            head.next = reverseKGroup(temp, k);
        }
        return pre;
    }
}