class Solution {
    public void sortColors(int[] nums) {
        int low = 0,high=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                low++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 2){
                int temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high++;
            }
        }
    }
}