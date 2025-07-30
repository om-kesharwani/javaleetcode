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
    public TreeNode helper(int[] preorder, int[] postorder,int pl,int ph,int pol)
    {   if(pl>ph)return null;
        TreeNode root=new TreeNode(preorder[pl]);
        if(pl==ph)
        return root;
        int nextNode=preorder[pl+1];
        int r=pol;
        while(r<postorder.length&&postorder[r]!=nextNode)
        r++;
        int ls=r-pol+1;
        root.left =helper(preorder,postorder,pl+1,pl+ls,pol);
        root.right=helper(preorder,postorder,pl+ls+1,ph,r+1); 
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder,postorder,0,preorder.length-1,0);
    }
}