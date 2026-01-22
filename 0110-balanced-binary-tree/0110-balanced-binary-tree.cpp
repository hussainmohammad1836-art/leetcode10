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
    int checkAns(TreeNode* root,bool &ans){
        if(root==NULL) return 0;
        int left=checkAns(root->left,ans)+1;
        int right=checkAns(root->right,ans)+1;

        int diff=left-right;
        if(diff>1 || diff<-1){
            ans=false;
        }
        return max(left,right);
    }


    bool isBalanced(TreeNode* root) {
        bool ans=true;
        int height= checkAns(root,ans);
        return ans;
    }
};