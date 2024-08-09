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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        int length = 1;

        ListNode temp = head;
        while(temp.next!=null){
            length = length + 1;
            temp = temp.next;
        }

        if(k==length || k%length==0){
            return head;
        }

        int itr_length=0;
        if(k>length){
            int mod = k%length;
            itr_length = length-mod;
        }else{
            itr_length = length-k;
        }

        ListNode temp1 = head;
        for(int i=1;i<itr_length;i++){
            temp1 = temp1.next;
        }
        ListNode new_head = temp1.next;
        temp1.next=null;
        temp.next = head;

        return new_head;

    }
}