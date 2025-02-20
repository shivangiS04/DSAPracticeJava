/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        
        dfs(root, p, q, new ArrayList<>());
        
        int i;
        for (i = 0; i < Math.min(pathP.size(), pathQ.size()); i++) {
            if (!pathP.get(i).equals(pathQ.get(i))) {
                break;
            }
        }
        
        return pathP.get(i - 1);
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if (root == null) {
            return;
        }
        
        path.add(root);
        
        if (root == p) {
            pathP = new ArrayList<>(path);
        }
        if (root == q) {
            pathQ = new ArrayList<>(path);
        }
        
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        
        path.remove(path.size() - 1);
    }
}
