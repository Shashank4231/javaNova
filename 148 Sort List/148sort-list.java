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
    private static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                temp = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = head2;
                head2 = head2.next;
            }
        }
        if (head1 != null)
            temp.next = head1;
        else
            temp.next = head2;

        return dummy.next;
    }

    private static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode middle = middleNode(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}