package priv.yins.leetcode.datastructures;

/**
 * @ClassName: ListNode
 * @Description: TODO
 * @Author: yinshuang
 * @Date: 2021/7/21 16:04
 * @Version: 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] vals) {
        ListNode temp = new ListNode();
        ListNode head = temp;

        for (int i = 1; i < vals.length; i++) {
            ListNode newNode = new ListNode(vals[i]);
            temp.next = newNode;
            temp = newNode;
        }
        this.val = vals[0];
        this.next = head.next;
    }
}
