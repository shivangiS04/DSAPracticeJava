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
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root,0);
        return sum;
    }
    private void dfs(TreeNode root, int currSum){
        //base
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum = sum + currSum * 10 + root.val;
            return;
        }
        dfs(root.left,currSum* 10 + root.val);
        dfs(root.right,currSum* 10 + root.val);
    }
}