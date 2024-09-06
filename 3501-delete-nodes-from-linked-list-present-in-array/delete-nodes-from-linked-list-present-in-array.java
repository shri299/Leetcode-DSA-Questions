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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> valuesToRemove = new HashSet<>();
        for (int val : nums) {
            valuesToRemove.add(val);
        }
        ListNode itr = head;
        ListNode prev = null;
       
        while(itr!=null){
                if(valuesToRemove.contains(itr.val)){
                    if(itr==head){ //head is getting removed
                        head = itr.next;
                        itr = head;
                    }else{
                        prev.next = itr.next;
                        itr = prev.next;
                    }
                }
                else {
                    prev = itr;
                    itr = itr.next;
                }
            }

        return head;

    }
}