class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE;
        int[] best = new int[n];
        int left = 0;
        long sum = 0;
        int minLen = INF;
        int answer = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target && left <= right) {
                sum -= arr[left++];
            }
            if (sum == target) {
                int len = right - left + 1;
                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(answer, len + best[left - 1]);
                }

                minLen = Math.min(minLen, len);
            }
            best[right] = minLen;
        }

        return answer == INF ? -1 : answer;
    }
}
