/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head, prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preLeft = dummy;
        for (int i = 1; i < left; i++) {
            preLeft = preLeft.next;
        }
        ListNode rightNode = preLeft;
        for (int i = left; i <= right; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = preLeft.next;
        ListNode sublistTail = rightNode.next;
        rightNode.next = null;

        preLeft.next = reverse(leftNode);
        leftNode.next = sublistTail;

        return dummy.next;
    }
}