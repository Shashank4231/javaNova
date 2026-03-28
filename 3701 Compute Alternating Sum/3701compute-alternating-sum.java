class Solution {
    public int alternatingSum(int[] nums) {
        int add = 0 , sub = 0;
           for(int i=0;i<nums.length;i++){
            if((i & 1) == 0){
               add += nums[i];
            }
            else{
                sub += nums[i];
            }
           }
           return (add - sub);
    }
}