class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] first = new int[nums.length];
        int[] second = new int[nums.length];
        int[] answer = new int[nums.length];

        int product = 1, sec_product = 1;

        for (int i = 0; i < nums.length; i++) {
            first[i] = product;
            product *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            second[i] = sec_product;
            sec_product *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = first[i] * second[i];
        }
        return answer;
    }
}