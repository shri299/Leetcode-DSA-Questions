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
        
        vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
                 
        vector<vector<int>> ans ; 
        
        if(root == NULL) return ans ;
        TreeNode *node = root ; 
        int ltr = 1 ; 
        
        queue <TreeNode*> q ; 
        q.push(node) ; 
        while (!q.empty()) {
            
            int size = q.size() ; 
            vector<int> temp(size) ; 
            
            for(int i=0 ; i<size ; i++) {
                
                node = q.front() ; 
                q.pop(); 
                
                if(node->left) q.push(node->left) ; 
                if(node->right) q.push(node->right) ; 
                
                if(ltr) {
                    temp[i] = node->val ; 
                }
                else{
                    temp[size-i-1] = node->val ; 
                }
                
            }
            
            ans.push_back(temp) ; 
            ltr = !ltr ; 
        }
        
        return ans ;
    }
};