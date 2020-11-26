package daily;

/**
 * @author xzx
 * @date 2020/11/13
 */
public class OddEvenList {

    public static class ListNode {
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
    }


    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode result = head;
        ListNode temp = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        head = head.next.next;
        while (head != null) {
            odd.next = head;
            odd = head;
            if (head.next != null) {
                even.next = head.next;
                even = head.next;
                head = head.next.next;
            } else {
                head = null;
            }
        }
        odd.next = temp;
        even.next = null;
        return result;
    }
}
