class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i];
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i];
            } else if (nums[i] == el1)
                cnt1++;
            else if (nums[i] == el2)
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el1)
                count1++;
            if (nums[i] == el2)
                count2++;
        }
        int mini = (int)(nums.length / 3) + 1;
        if (count1 >= mini)
            list.add(el1);
        if (count2 >= mini)
            list.add(el2);

        return list;
    }
}