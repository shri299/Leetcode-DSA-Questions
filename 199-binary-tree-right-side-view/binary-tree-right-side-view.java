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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return result;
        }
        queue.offer(root);
        result.add(root.val);
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i=0;i<levelSize;i++){
                TreeNode current = queue.poll();
                if(current.right!=null){
                    queue.offer(current.right);
                }
                if(current.left!=null){
                    queue.offer(current.left);
                }
            }
            TreeNode target = queue.peek();
            if(target!=null){
                result.add(target.val);
            }
        }
        return result;
    }
}