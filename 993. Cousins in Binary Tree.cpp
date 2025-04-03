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
    bool isCousins(TreeNode* root, int x, int y) {
                queue<pair<TreeNode*, TreeNode*>> q; //current, parent
        q.push({root, nullptr});

        while(!q.empty())
        {
            int len = q.size();
            unordered_map<int, TreeNode*> nodes;
            for(int i = 0; i < len; ++i)
            {
                auto [node, parentNode] = q.front(); q.pop();

                nodes[node->val] = parentNode;
                if(nodes.find(x) != nodes.end() && nodes.find(y) != nodes.end() && nodes[x] != nodes[y])
                {
                    return true;
                }
                if(node->left)
                {
                    q.push({node->left, node});
                }
                if(node->right)
                {
                    q.push({node->right, node});
                }
            }
        }

        return false;
    }
};
