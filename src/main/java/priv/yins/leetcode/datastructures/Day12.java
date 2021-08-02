package priv.yins.leetcode.datastructures;

/**
 * @ClassName: Day12
 * @Description: 226. 翻转二叉树 112. 路径总和
 * @Author: yinshuang
 * @Date: 2021/7/27 9:28
 * @Version: 1.0
 */
public class Day12 {

    /**
     * 226. 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        if (root.left != null) {
            invert(root.left);
        }
        if (root.right != null) {
            invert(root.right);
        }
    }

    /**
     * 112. 路径总和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return false;
    }
}
