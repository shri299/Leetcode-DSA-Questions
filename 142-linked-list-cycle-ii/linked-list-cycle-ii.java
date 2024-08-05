/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                flag = true;
                break;
            }
        }

        //count length of cycle
        if(flag){
            slow = slow.next;
        int count = 1;
        while (fast!=slow){
            slow = slow.next;
            count = count+1;
        }

        ListNode temp = head;
        ListNode temp1 = head;
        while(count!=0){
            temp1 = temp1.next;
            count--;
        }

        while(temp!=temp1){
            temp = temp.next;
            temp1 = temp1.next;
        }
        return temp;
        }

        return null;
    }
}