class Solution {
    private int[] nse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] pse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;

        int[] next = nse(arr);
        int[] prev = pse(arr);

        long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            ans = (ans + left * right * arr[i]) % MOD;
        }

        return (int) ans;
    }
}
