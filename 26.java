class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0, count = 0;
        int i = 0;
        if(nums.length > 0) count = 1;
        // nums[pos] = nums[i];
        for(i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i+1]){
                count++;
                pos++;
                nums[pos] = nums[i+1];
            }
        }
        return count;
    }
}