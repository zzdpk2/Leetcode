class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0, pos = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) {
                pos++;
                nums[pos] = nums[i];
                count++;
            }
        }
        return count;
    }
}