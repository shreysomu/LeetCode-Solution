class Solution {
public:
 void inorder(TreeNode*& res, TreeNode* root) {
        if (!root) 
            return;
        inorder(res, root->left);
        res->right = new TreeNode(root->val);
        res = res->right;
        inorder(res, root->right);
    }
    TreeNode* increasingBST(TreeNode* root) {
        TreeNode* temp;
        TreeNode* res = new TreeNode();
        temp = res;
        inorder(res, root);
        return temp->right;
    }
};
