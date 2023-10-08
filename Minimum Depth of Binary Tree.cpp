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
    int minDepth(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        queue<TreeNode*> Q;
        Q.push(root);
        int i = 0;
        while (!Q.empty()) {
            i++;
            int k = Q.size();
            for (int j = 0; j < k; j++) {
                TreeNode* a = Q.front();
                if (a -> left) {
                    Q.push(a -> left);
                } 
                if (a -> right) {
                    Q.push(a -> right);
                }
                Q.pop();
                if (a -> left == NULL && a -> right == NULL) {
                    return i;
                }
            }
        }
        return -1;
    }
};