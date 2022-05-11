/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> v;
        recursion(root,0,v);
        return v;
        
    }
    void recursion(TreeNode* root,int level, vector<int> &v)
    {
        if(root == NULL)
            return;
        if(v.size()==level)
            v.push_back(root->val);
        recursion(root->right,level+1,v);
        recursion(root->left,level+1,v);
    }
};