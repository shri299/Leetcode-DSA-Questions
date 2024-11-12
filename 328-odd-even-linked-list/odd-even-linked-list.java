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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp = head;
        ListNode evenLast = null;
        ListNode oddLast = null;
        ListNode oddStart = null;
        boolean isEven = true;
        while(temp!=null){
            if(isEven){
                if(evenLast==null){
                    evenLast = temp;
                }else{
                    evenLast.next = temp;
                    evenLast = temp;
                }
                isEven = false;
            }else{
                if(oddLast==null){
                    oddLast = temp;
                    oddStart = temp;
                }else{
                    oddLast.next = temp;
                    oddLast = temp;
                }
                isEven = true;
            }
            temp = temp.next;
        }

        evenLast.next = oddStart;
        oddLast.next = null;
        

        return head;
    }
}