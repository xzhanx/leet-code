package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xzx
 * @date 2020/10/13
 */
public class SwapPairs {

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

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode result = head.next;
        swapPairs1(head, null);
        return result;
    }

    public void swapPairs1(ListNode node, ListNode front) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = node;
            if (front != null) {
                front.next = next;
            }
        }
        swapPairs1(node.next, node);
    }


    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int half = 0;
        while (x > half) {
            half = half * 10 + x % 10;
            x /= 10;
        }
        return x == half || x == half / 10;
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        int i = 0;
        while (i < chars.length) {
            if (i + 1 < chars.length) {
                int first = map.get(chars[i]);
                int second = map.get(chars[i + 1]);
                if (first < second) {
                    sum = sum + second - first;
                    i += 2;
                    continue;
                } else {
                    sum += first;
                }
            } else {
                // 最后一个
                sum += map.get(chars[i]);
            }
            i += 1;
        }
        return sum;
    }

    static Map<Character, Integer> map = new HashMap<>(8);

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        s = s.trim();
        int index = s.lastIndexOf(" ");
        return index < 0 ? s.length() : s.substring(index + 1).length();
    }

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > result) {
                result = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
            int val = node.val;
            if (node.next.val != val) {
                node = node.next;
                continue;
            }
            ListNode next = node.next;
            while (next != null && val == next.val) {
                next = next.next;
            }
            node.next = next;
        }
        return head;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        int[] nums = new int[nums1.length];
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[i + j] = nums1[i];
                i++;
            } else {
                nums[i + j] = nums2[j];
                j++;
            }
        }
        if (i < m) {
            System.arraycopy(nums1, i, nums, i + j, m - i);
        } else {
            System.arraycopy(nums2, j, nums, i + j, n - j);
        }
        System.arraycopy(nums, 0, nums1, 0, nums1.length);
    }
}
