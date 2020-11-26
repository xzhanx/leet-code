package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzx
 * @date 2020/10/20
 */
public class ReorderList {

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

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        // 先遍历一遍
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            ListNode first = list.get(i);
            ListNode second = list.get(j);
            if (i == j || i + 1 == j) {
                second.next = null;
            } else {
                second.next = first.next;
                first.next = second;
            }
        }
    }

    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0, count1 = 0, count2 = 0;
        while (i < name.length() && j < typed.length()) {
            char ci = name.charAt(i);
            char cj = typed.charAt(j);
            if (ci != cj) {
                return false;
            }
            while (true) {
                if (++i < name.length() && ci == name.charAt(i)) {
                    count1++;
                } else {
                    break;
                }
            }
            while (true) {
                if (++j < typed.length() && cj == typed.charAt(j)) {
                    count2++;
                } else {
                    break;
                }
            }
            if (count1 > count2) {
                return false;
            }
            count1 = count2 = 0;
        }
        return i == name.length() && j == typed.length();
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
    }


//    public boolean isPalindrome(ListNode head) {
//        if (head == null) {
//            return true;
//        }
//
//    }
}
