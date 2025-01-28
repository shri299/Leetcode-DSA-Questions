/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean ans = false;
    private TreeNode answer = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return answer;
    }

    public int helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || ans){
            return 0;
        }
        int found = 0;
        if(root.val==p.val || root.val==q.val){
            found = 1;
        }
        int leftTrack = helper(root.left,p,q);
        int rightTrack = helper(root.right,p,q);
        if((found + leftTrack + rightTrack)==2 && !ans){
            ans = true;
            answer = root;
        }
        return found + leftTrack + rightTrack;
    }
}