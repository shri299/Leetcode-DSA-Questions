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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return false;
        }
        queue.offer(root);
        int levelCounter = 0;
        TreeNode parentOne = null;
        TreeNode parentTwo = null;
        int levelOne = 0;
        int levelTwo = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i=0;i<levelSize;i++){
                TreeNode current = queue.poll();

                if(current.left!=null){
                    if(current.left.val==x){
                        parentOne=current;
                        levelOne = levelCounter;
                    }
                    if(current.left.val==y){
                        parentTwo=current;
                        levelTwo = levelCounter;
                    }
                    queue.offer(current.left);
                }


                if(current.right!=null){
                    if(current.right.val==x){
                        parentOne=current;
                        levelOne = levelCounter;
                    }
                    if(current.right.val==y){
                        parentTwo=current;
                        levelTwo = levelCounter;
                    }
                    queue.offer(current.right);
                }
            }

            levelCounter = levelCounter + 1;
        }

        if(parentOne==null || parentTwo==null){
            return false;
        }
        if(parentOne!=parentTwo && levelOne==levelTwo){
            return true;
        }else{
            return false;
        }
    }
}