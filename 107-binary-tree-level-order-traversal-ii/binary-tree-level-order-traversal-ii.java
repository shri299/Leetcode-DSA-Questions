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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size(); //initially its 0
            List<Integer> subList = new ArrayList<>();
            for (int i=0;i<levelSize;i++){
                TreeNode target = queue.poll();
                subList.add(target.val);
                if (target.left!=null){
                    queue.offer(target.left);
                }
                if (target.right!=null){
                    queue.offer(target.right);
                }
            }
            result.add(0,subList);
        }
        return result;
    }
}