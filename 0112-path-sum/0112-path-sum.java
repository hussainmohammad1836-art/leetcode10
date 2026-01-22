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
    int target;
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        if (root != null)
            findpathsum(root, 0);
        return res;
    }

    public void findpathsum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && !res)
            res = (sum + root.val) == target;

        if (root.left != null)
            findpathsum(root.left, sum + root.val);
        if (root.right != null)
            findpathsum(root.right, sum + root.val);

    }
}