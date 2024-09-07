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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return helper(head , root);
    }
    boolean helper(ListNode curr , TreeNode node){

        if(node==null) return false;
        return check_path(curr,node) || helper(curr,node.left) || helper(curr,node.right);
    }
    boolean check_path(ListNode curr,TreeNode node){
       if(curr==null) return true;
       if(node==null) return false;
       if(curr.val!=node.val) return false;
       return check_path(curr.next,node.right)||check_path(curr.next,node.left);
    }
}