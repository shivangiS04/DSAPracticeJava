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
    TreeNode func(int[] preorder,int[] postorder,HashMap<Integer,Integer> postindex,int poststart,int postend,int[] preindex){
        if(preindex[0]>=preorder.length || poststart>postend){
            return null;
        }

        TreeNode root=new TreeNode(preorder[preindex[0]++]);
        

        if(poststart==postend || preindex[0]==preorder.length) return root;

        int left=postindex.get(preorder[preindex[0]]);

        root.left=func(preorder,postorder,postindex,poststart,left,preindex);
        root.right=func(preorder,postorder,postindex,left+1,postend-1,preindex);

        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> postindex=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            postindex.put(postorder[i],i);
        }
        int[] preindex={0};
        int poststart=0;
        int postend=postorder.length-1;

        TreeNode root=func(preorder,postorder,postindex,poststart,postend,preindex);

        return root;
    }
}