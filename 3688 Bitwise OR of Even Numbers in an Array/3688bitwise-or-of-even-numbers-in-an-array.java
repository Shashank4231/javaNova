class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int result = 0;
          for(int i=0;i<nums.length;i++){
            if((nums[i] & 1) ==0){
                result = result | nums[i];
            }
          }
          return result;
    }
}