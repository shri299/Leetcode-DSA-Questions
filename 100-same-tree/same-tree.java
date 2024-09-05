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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if((p==null && q!=null) || (p!=null && q==null)){
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(p);
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.offer(q);

        while(!queue1.isEmpty() && !queue2.isEmpty()){
            int levelSize1 = queue1.size();
            int levelSize2 = queue2.size();
            if(levelSize1!=levelSize2){
                return false;
            }
            for(int i=0;i<levelSize1;i++){
                TreeNode target1 = queue1.poll();
                TreeNode target2 = queue2.poll();
                if(target1.val!=target2.val){
                    return false;
                }

                if(target1.left!=null && target2.left!=null){
                    //check for values
                    if(target1.left.val!=target2.left.val){
                        return false;
                    }
                    queue1.offer(target1.left);
                    queue2.offer(target2.left);
                }else if(target1.left!=null && target2.left==null){
                    return false;
                }else if (target1.left==null && target2.left!=null){
                    return false;
                }

                if(target1.right!=null && target2.right!=null){
                    //check for values
                    if(target1.right.val!=target2.right.val){
                        return false;
                    }
                    queue1.offer(target1.right);
                    queue2.offer(target2.right);
                }else if(target1.right!=null && target2.right==null){
                    return false;
                }else if (target1.right==null && target2.right!=null){
                    return false;
                }
            }
    }

    if((queue1.isEmpty() && !queue2.isEmpty()) || (!queue1.isEmpty() && queue2.isEmpty())){
        return false;
    }

    return true;
}}