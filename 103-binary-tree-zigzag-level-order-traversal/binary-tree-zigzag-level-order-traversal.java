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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        int flag=0;
        if (root==null){
            return result;
        }
        deque.addFirst(root);
        while (!deque.isEmpty()){
            int levelSize = deque.size(); //initially its 1
            List<Integer> subList = new ArrayList<>();
            for (int i=0;i<levelSize;i++){
                //we have two cases either remove from front or from back
                if (flag % 2 == 0){
                    TreeNode target = deque.pollFirst(); //remove first and add to subList
                    subList.add(target.val);
                    if (target.left!=null){
                        deque.addLast(target.left);
                    }
                    if (target.right!=null){
                        deque.addLast(target.right);
                    }
                }else {
                    //remove from back, insert children in the front
                    TreeNode target = deque.pollLast();
                    subList.add(target.val);
                    if (target.right!=null){
                        deque.addFirst(target.right);
                    }
                    if (target.left!=null){
                        deque.addFirst(target.left);
                    }
                }
            }
            flag = flag+1;
            result.add(subList);
        }
        return result;
    }
}