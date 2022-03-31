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
    int FindHeight(TreeNode* temp)
    {
        if(temp==NULL)
            return 0;
        int lh = FindHeight(temp->left);
        int rh = FindHeight(temp->right);
        return 1 + max(lh,rh);
    }
    bool isBalanced(TreeNode* root) {
        
        if(root==NULL)
            return true;
        int lh = FindHeight(root->left);
        int rh = FindHeight(root->right);
        if(abs(lh-rh)>1)
            return false;
        bool left = isBalanced(root->left);
        bool right = isBalanced(root->right);
        
        if(!left || !right)
            return false;
        return true;
        
    }
};