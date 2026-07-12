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
    private static ListNode find(ListNode temp, int k) {
        int cnt = 1;
        while (temp != null) {
            if (cnt == k)
                return temp;
            cnt++;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        if (k % length == 0)
            return head;
        k = k % length;
        tail.next = head;
        ListNode newNode = find(head, length - k);

        head = newNode.next;
        newNode.next = null;

        return head;
    }
}