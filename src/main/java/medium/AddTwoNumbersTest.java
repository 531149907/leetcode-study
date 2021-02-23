package medium;

import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
    @Test
    void test() {
        ListNode l1 = new ListNode(2, new ListNode(3, new ListNode(8, new ListNode(7, new ListNode(6, new ListNode(9))))));
        ListNode l2 = new ListNode(7, new ListNode(9, new ListNode(9, new ListNode(8, new ListNode(2, new ListNode(1, new ListNode(0, new ListNode(2))))))));

        System.out.println(addTwoNumbers(l1, l2));
        System.out.println(111);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode();
        ListNode l1CurrentNode = l1;
        ListNode l2CurrentNode = l2;
        ListNode sumCurrentNode = sumList;

        boolean nextCarry = false;
        int currentSum;
        int l1CurrentVal;
        int l2CurrentVal;

        while (true) {
            l1CurrentVal = l1CurrentNode == null ? 0 : l1CurrentNode.val;
            l2CurrentVal = l2CurrentNode == null ? 0 : l2CurrentNode.val;

            currentSum = l1CurrentVal + l2CurrentVal + (nextCarry ? 1 : 0);
            sumCurrentNode.val = currentSum % 10;
            nextCarry = currentSum >= 10;

            l1CurrentNode = l1CurrentNode == null ? null : l1CurrentNode.next;
            l2CurrentNode = l2CurrentNode == null ? null : l2CurrentNode.next;

            if (l1CurrentNode != null || l2CurrentNode != null) {
                sumCurrentNode.next = new ListNode();
                sumCurrentNode = sumCurrentNode.next;
            } else {
                if (nextCarry) {
                    sumCurrentNode.next = new ListNode(1);
                }
                return sumList;
            }
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
