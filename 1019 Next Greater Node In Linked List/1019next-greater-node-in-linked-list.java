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
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public int[] nextLargerNodes(ListNode head) {

        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        head = reverse(head);

        int idx = n - 1;

        while (head != null) {

            while (!st.isEmpty() && st.peek() <= head.val) {
                st.pop();
            }

            ans[idx] = st.isEmpty() ? 0 : st.peek();

            st.push(head.val);
            idx--;
            head = head.next;
        }

        return ans;
    }
}