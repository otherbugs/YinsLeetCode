package priv.yins.leetcode.datastructures;

/**
 * @ClassName: TreeNode
 * @Description: TODO
 * @Author: yinshuang
 * @Date: 2021/7/27 9:33
 * @Version: 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
