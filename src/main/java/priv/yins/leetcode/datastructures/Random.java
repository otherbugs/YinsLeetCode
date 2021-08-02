package priv.yins.leetcode.datastructures;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: Random
 * @Description: 随机的
 * @Author: yinshuang
 * @Date: 2021/7/29 9:31
 * @Version: 1.0
 */
public class Random {

    /**
     * 24. 两两交换链表中的节点
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        head = next;
        return head;
    }

    /**
     * 171. Excel 表列序号
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = columnTitle.length() - 1; i > 0; i--) {
            result += ((int) Math.pow(26, i)) * (columnTitle.charAt(columnTitle.length() - i - 1) - 64);
        }
        result += (columnTitle.charAt(columnTitle.length() - 1) - 64);
        return result;
    }

    /**
     * 743. 网络延迟时间 times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
     * n是节点葛
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        return 0;
    }

    /**
     * 987. 二叉树的垂序遍历
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //Map<所在列,Map<所在行,所有值>>
        Map<Integer, Map<Integer, List<Integer>>> values = new HashMap();
        inorder(root, values, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        //遍历所有列
        values.keySet().stream().sorted().collect(Collectors.toList()).forEach(row -> {
            //遍历当前列的所有行
            Map<Integer, List<Integer>> lines = values.get(row);
            List<Integer> l = new ArrayList<>();
            lines.keySet().stream().sorted().collect(Collectors.toList()).forEach(value -> {
                List<Integer> temp = lines.get(value);
                l.addAll(temp.stream().sorted().collect(Collectors.toList()));
            });

            result.add(l);
        });

        return result;
    }

    public void inorder(TreeNode treeNode, Map<Integer, Map<Integer, List<Integer>>> result, int currentLine, int currentRow) {
        if (treeNode != null) {
            if (result.get(currentRow) != null) {
                //获得该列的所有行
                Map<Integer, List<Integer>> row = result.get(currentRow);
                if (row.get(currentLine) != null) {
                    //获得该行的所有值
                    List<Integer> list = row.get(currentLine);
                    list.add(treeNode.val);
                    row.put(currentLine, list);
                } else {
                    List val = new ArrayList();
                    val.add(treeNode.val);
                    row.put(currentLine, val);
                }
            } else {
                Map map = new HashMap();
                List val = new ArrayList();
                val.add(treeNode.val);
                map.put(currentLine, val);
                result.put(currentRow, map);
            }
            inorder(treeNode.left, result, currentLine + 1, currentRow - 1);
            inorder(treeNode.right, result, currentLine + 1, currentRow + 1);
        }
    }

    /**
     * 1006. 笨阶乘
     */
    public int clumsy(int n) {
        int result = 0;
        int temp = n;
        for (int i = 0; n > 1; i++, n = n - 1) {
            switch (i % 4) {
                case 0:
                    temp = temp * (n - 1);
                    break;
                case 1:
                    temp = temp / (n - 1);
                    break;
                case 2:
                    result = result + temp + n - 1;
                    temp = 2 - n;
                    break;
            }
        }
        result = result + temp;
        return result;
    }

    /**
     * 1104. 二叉树寻路
     */
    public List<Integer> pathInZigZagTree(int label) {
        /*整体思路：先看下是不是二叉树最边上的值，不是的用该值在当前所在行的位置，除以二得到上一行的位置*/
        //第i层(i从0开始)
        int n = (int) Math.floor(Math.log(label) / Math.log(2));
        Integer[] result = new Integer[n + 1];
        result[0] = 1;
        result[result.length - 1] = label;
        //是2的幂次方 或者 -1
        if ((label > 0 && (label & (label - 1)) == 0) || (label > 1 && ((label + 1) & label) == 0)) {
            for (int i = result.length - 2; i > 0; i--, n--) {
                label = label % 2 == 0 ? label - 1 : (int) Math.pow(2, i);
                result[i] = label;
            }
            return Arrays.asList(result);
        }

        int index = (int) (n % 2 == 0 ? label - Math.pow(2, n) + 1 : Math.pow(2, n + 1) - label);
        result[result.length - 1] = label;
        n--;
        for (int i = result.length - 2; i > 0; i--, n--) {
            index = (int) Math.ceil(index / (double) 2);
            label = (int) (i % 2 == 0 ? Math.pow(2, i) + index - 1 : Math.pow(2, i + 1) - index);
            result[i] = label;
        }
        return Arrays.asList(result);
    }

    /**
     * 1337. 矩阵中战斗力最弱的 K 行
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        boolean[] isBreak = new boolean[mat.length];
        int[] result = new int[k];
        int count = 0;
        //遍历所有列
        for (int i = 0; i < mat[0].length; i++) {
            //遍历当前列的所有行
            for (int j = 0; j < mat.length; j++) {
                if (!isBreak[j]) {
                    if (mat[j][i] == 0) {
                        //如果是平民
                        result[count] = j;
                        count++;
                        if (count == k) {
                            return result;
                        }
                        isBreak[j] = true;
                    }
                }
            }
        }
        if (count < k) {
            for (int i = 0; count != k; i++) {
                if (!isBreak[i]) {
                    result[count] = i;
                    count++;
                }
            }
        }
        return result;
    }
}
