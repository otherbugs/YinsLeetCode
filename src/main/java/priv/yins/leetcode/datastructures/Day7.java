package priv.yins.leetcode.datastructures;

/**
 * @ClassName: Day7
 * @Description: 141. 环形链表 21. 合并两个有序链表 203. 移除链表元素
 * @Author: yinshuang
 * @Date: 2021/7/21 9:56
 * @Version: 1.0
 */
public class Day7 {
    /**
     * 141. 环形链表
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode n = head.next.next;
        while (n != null && n.next != null && n.next.next != null) {
            if (head == n) {
                return true;
            }
            head = head.next;
            n = n.next.next;
        }
        return false;
    }

    /**
     * 21. 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode tempHead = new ListNode();
        tempHead.next = l1;
        merge(tempHead, l2);
        return tempHead.next;
    }

    public void merge(ListNode a, ListNode b) {
        if (a != null && b != null) {
            if (a.next == null) {
                a.next = b;
                return;
            }
            if (a.next.val < b.val) {
                merge(a.next, b);
            } else {
                ListNode temp = new ListNode(b.val, a.next);
                a.next = temp;
                merge(a.next, b.next);
            }
        }
    }


    /**
     * 203. 移除链表元素
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        forNode(head, val);
        return head.val == val ? head.next : head;
    }

    public void forNode(ListNode node, int val) {
        if (node == null || node.next == null) {
            return;
        }
        if (node.next.val == val) {
            node.next = node.next.next;
            forNode(node, val);
        }
        forNode(node.next, val);
    }
}