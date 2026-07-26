class Solution {
    private static int hist(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int area = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                area = Math.max(area, arr[element] * (nse - pse - 1));
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int element = st.pop();
            int nse = arr.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            area = Math.max(area, arr[element] * (nse - pse - 1));
        }
        return area;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] pSum = new int[m][n];

        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == '1')
                    sum++;
                else
                    sum = 0;

                pSum[i][j] = sum;
            }
        }

        int area = 0;
        for (int i = 0; i < m; i++) {
            area = Math.max(area, hist(pSum[i]));
        }

        return area;
    }
}