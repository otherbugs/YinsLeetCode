package priv.yins.leetcode.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Day14
 * @Description: 98. 验证二叉搜索树 653. 两数之和 IV - 输入 BST 235. 二叉搜索树的最近公共祖先
 * @Author: yinshuang
 * @Date: 2021/7/28 9:02
 * @Version: 1.0
 */
public class Day14 {
    /**
     * 98. 验证二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        try {
            validBST(root, root.val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void validBST(TreeNode root, int val) throws Exception {
        if (root == null) {
            return;
        }
        if (root.left != null && (root.left.val >= root.val || root.left.val >= val)) {
            throw new Exception("非二叉搜索树");
        } else {
            validBST(root.left, val)
            ;
        }
        if (root.right != null && (root.right.val <= root.val || root.right.val <= val)) {
            throw new Exception("非二叉搜索树");
        } else {
            validBST(root.right, val);
        }
    }


    /**
     * 653. 两数之和 IV - 输入 BST
     */
//    public boolean findTarget(TreeNode root, int k) {
//        Map<Integer,Integer> map =new HashMap();
//
//
//
//
//
//
//
//        while () {
//
//            if (k > 2 * root.val) {
//                if (root.left == null) {
//                    root
//                    continue;
//                }
//                if (root.left.val + root.val == k) {
//                    return true;
//                }
//                if (root.left.val + root.val)
//            }
//        }
//    }
    
    /**
     * 235. 二叉搜索树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val) {
            return root;
        }
        if (q.val == root.val) {
            return root;
        }

        if ((p.left != null && p.left.val == q.val) || (p.right != null && p.right.val == q.val)) {
            return p;
        }
        if ((q.left != null && q.left.val == p.val) || (q.right != null && q.right.val == p.val)) {
            return q;
        }

        while (root != null) {
            if (p.val == root.val) {
                return root;
            }
            if (q.val == root.val) {
                return root;
            }
            if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
                return root;
            }
            if (p.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
