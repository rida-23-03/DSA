class Solution {
    public TreeNode f(TreeNode root,TreeNode p,TreeNode q){
        if(root==null || root==p || root==q) return root;
        TreeNode leftsubtree=f(root.left,p,q);
        TreeNode rightsubtree=f(root.right,p,q);

        if(leftsubtree==null && rightsubtree==null) return null;
        else if(leftsubtree==null) return rightsubtree;
        else if(rightsubtree==null) return leftsubtree;
        else return root;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return f(root,p,q);
        

    }
}