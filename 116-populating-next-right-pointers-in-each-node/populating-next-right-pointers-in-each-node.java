/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root==null){
            return root;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            Node target = null;
            for(int i=0;i<levelSize;i++){
                Node current = queue.poll();
                if(target!=null){
                    target.next=current;
                    target=current;
                }else{
                    target=current;
                }
                if(current.left!=null){
                    queue.offer(current.left);
                }

                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
            target.next=null;
            
        }

        return root;
    }
}