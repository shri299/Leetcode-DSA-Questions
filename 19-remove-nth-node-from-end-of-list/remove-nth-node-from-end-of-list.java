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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode fast = head, slow = head;
        // for (int i = 0; i < n; i++) fast = fast.next;
        // if (fast == null) return head.next;
        // while (fast.next != null) {
        //     fast = fast.next;
        //     slow = slow.next;
        // }
        // slow.next = slow.next.next;
        // return head;}

        if (head==null){
            return null;
        }

        ListNode temp = head;
        int length=0;

        while(temp!=null){
            temp=temp.next;
            length = length+1;
        }

        int itr_length=length-n;

        ListNode prev = head;
        temp = head;

        if (itr_length==0){

            if (head.next==null)
                return null;
            else {
                head = head.next;
            }

        }else {

            for (int i=0;i<itr_length;i++){
                prev = temp;
                temp = temp.next;
            }

            prev.next=temp.next;

        }

        return head;
    }
}