package TreeDfs;

import javax.swing.tree.TreeNode;

public class PathSum {
    
 // Definition for a binary tree node.
  public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
  }
 
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == targetSum) return true;


        hasSum(root, targetSum);
        return ans;
    }

    public void hasSum(TreeNode root, int targetSum) {
        if(root == null || ans == true) return;
        if(root.left == null && root.right == null && root.val == targetSum) {
            ans = true;
            return;
        }
        hasSum(root.left, targetSum - root.val);
        hasSum(root.right, targetSum - root.val);
    }
    
}
