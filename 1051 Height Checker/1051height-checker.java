class Solution {
    public int heightChecker(int[] heights) {
        int[] sortedArr = Arrays.stream(heights).sorted().toArray();
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedArr[i])
                count++;
        }
        return count;
    }
}