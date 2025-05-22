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
        if(root==null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node current = null;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                current = queue.poll();
                if(i!=levelSize-1){
                    current.next = queue.peek();
                }
                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
            current.next = null;
        }

        return root;
    }
}