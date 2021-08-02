package priv.yins.leetcode.datastructures;

/**
 * @ClassName: Day8
 * @Description: 206. 反转链表 83. 删除排序链表中的重复元素
 * @Author: yinshuang
 * @Date: 2021/7/22 9:33
 * @Version: 1.0
 */
public class Day8 {

    /**
     * 206. 反转链表
     * 7 8 0 1 2 3
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode reverseList = new ListNode(head.val);
        head = head.next;

        while (head != null) {
            reverseList = new ListNode(head.val, reverseList);
            head = head.next;
        }
        return reverseList;
    }

    /**
     * 83. 删除排序链表中的重复元素
     */
    public ListNode deleteDuplicates(ListNode head) {
        //方式一
//        deleteDuplicatestRecurrence(head);
//        return head;

        //方式二
        ListNode deleteDuplicates = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return deleteDuplicates;
    }

    public void deleteDuplicatestRecurrence(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        if (node.val == node.next.val) {
            node.next = node.next.next;
            deleteDuplicatestRecurrence(node);
        } else {
            deleteDuplicatestRecurrence(node.next);
        }
    }
}
