package priv.yins.leetcode.datastructures;

import java.util.List;

/**
 * @ClassName: Day13
 * @Description: 700. 二叉搜索树中的搜索 701. 二叉搜索树中的插入操作
 * @Author: yinshuang
 * @Date: 2021/7/27 9:28
 * @Version: 1.0
 */
public class Day13 {
    /**
     * 700. 二叉搜索树中的搜索
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    /**
     * 701. 二叉搜索树中的插入操作
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null){
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    public void insert(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            insert(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            insert(root.right, val);
        }
    }
}
