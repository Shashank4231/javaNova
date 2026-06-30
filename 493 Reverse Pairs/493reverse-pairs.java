class Solution {
    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static int countPairs(int arr[], int l, int m, int r) {
    int right = m + 1;
    int cnt = 0;

    for (int i = l; i <= m; i++) {
        while (right <= r && (long) arr[i] > 2L * arr[right]) {
            right++;
        }
        cnt += right - (m + 1);
    }

    return cnt;
}

    public static int mergeSort(int arr[], int l, int r) {
        int cnt = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            cnt += mergeSort(arr, l, m);
            cnt += mergeSort(arr, m + 1, r);
            cnt += countPairs(arr, l, m, r);
            merge(arr, l, m, r);
        }
        return cnt;
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);

    }
}