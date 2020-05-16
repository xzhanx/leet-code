package daily;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xzx
 * @since 2020/5/16 - 16:35
 */
public class ReverseKGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void print(ListNode head) {
        System.out.print("[ ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("]");
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // 创建一个虚拟头部以及它的复制
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;
        ListNode virtualTemp = virtualHead;

        while (virtualTemp != null) {
            virtualTemp = reverseGroup(virtualTemp, k);
        }
        return virtualHead.next;
    }

    private static ListNode reverseGroup(ListNode head, int k) {
        ListNode copy = head;
        for (int i = 0; i < k; i++) {
            if (copy.next == null) {
                // 标记下一组已经不足k个元素
                return null;
            }
            copy = copy.next;
        }
        copy = head.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode c = copy.next.next;
            ListNode b = copy.next;
            copy.next.next = head.next;
            copy.next = c;
            head.next = b;
        }
        return copy;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        print(head);
        print(reverseKGroup(head, 4));
    }
}
