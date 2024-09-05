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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null && cloned==null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(cloned);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i=0;i<levelSize;i++){
                TreeNode current = queue.poll();
                if(current.val==target.val){
                    return current;
                }
                if(current.left!=null){
                    queue.offer(current.left);
                }

                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
        }

        return null;
    }
}