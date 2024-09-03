/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //from tree to preorder (add null as well)
        List<String> list = new ArrayList<>();
        helper(root,list);
        //convert the list to string
        StringBuilder res = new StringBuilder();
        for(String str: list){
            if(str!=null){
                res.append(str+",");
            }
        }
        if (res.length() > 0) {
            res.setLength(res.length() - 1); // Remove the trailing comma
        }
        return res.toString();

    }

    public void helper(TreeNode node, List<String> list){
        if(node==null){
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));
        helper(node.left,list);
        helper(node.right,list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
        Collections.reverse(list);
        TreeNode root = helperTwo(list);
        return root;
    }

    public TreeNode helperTwo(List<String> list){
        String val = list.remove(list.size()-1);
        if(val.charAt(0)=='n'){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helperTwo(list);
        node.right = helperTwo(list);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));