class Solution {
    public void backtrack(int[] nums, int index, int currentOR, int maxOR, int[] count) {
        if (currentOR == maxOR) {
            count[0]++;
            if(index!=nums.length)
            count[0]+=Math.pow(2,nums.length-index)-1;
            return;
        }
        for (int i = index; i < nums.length; i++) {
            backtrack(nums, i + 1, currentOR | nums[i], maxOR, count);
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for (int num : nums) {
            maxOR |= num;
        }
        int[] count = new int[1];
        backtrack(nums, 0, 0, maxOR, count);
        return count[0];
    }
}