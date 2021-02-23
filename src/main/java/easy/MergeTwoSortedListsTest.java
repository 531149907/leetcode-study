package easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class MergeTwoSortedListsTest {
    @Test
    void test() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + " > ");
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(-1);
        ListNode resultPointer = resultList;
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;

        while (true) {
            if (l1Pointer == null && l2Pointer == null) {
                return resultList.next;
            }

            if (l1Pointer == null) {
                resultPointer.next = l2Pointer;
                return resultList.next;
            }

            if (l2Pointer == null) {
                resultPointer.next = l1Pointer;
                return resultList.next;
            }

            if (l1Pointer.val < l2Pointer.val) {
                resultPointer.next = l1Pointer;
                l1Pointer = l1Pointer.next;
            } else {
                resultPointer.next = l2Pointer;
                l2Pointer = l2Pointer.next;
            }

            resultPointer = resultPointer.next;
        }
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
