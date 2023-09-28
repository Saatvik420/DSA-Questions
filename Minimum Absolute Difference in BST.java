/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        if(root.right != null) {
            minValue = findMin(root.right);
            min = Math.min(min, minValue-root.val);
        }
        if(root.left != null) {
            maxValue = findMax(root.left);
            min = Math.min(min, root.val - maxValue);
        }

        dfs(root.left);
        dfs(root.right);
    }

    private int findMax(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(findMax(root.left), Math.max(findMax(root.right), root.val));
    }

    private int findMin(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(findMin(root.left), Math.min(findMin(root.right), root.val));
    }
}