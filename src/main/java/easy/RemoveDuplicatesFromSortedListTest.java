package easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class RemoveDuplicatesFromSortedListTest {
    @Test
    void test() {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pointer = head;
        int lastVal = head.val;

        while (pointer.next != null) {
            if (pointer.next.val == lastVal) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
                lastVal = pointer.val;
            }
        }

        return head;
    }

    public static final class ListNode {
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

}
