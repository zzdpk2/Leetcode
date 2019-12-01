package bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3_15 {
    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};
        List<List<Integer>> result = threeSum(nums);
        for (int i = 0; i < result.size(); i++)     System.out.println(result.get(i));

    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length < 3)
            return result;

        int temp = 0, left = 0, right = 0, val = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            temp = nums[i];
            left = i + 1;
            right = nums.length - 1;
            val = -temp;

            while(left < right){
                if(nums[left] + nums[right] == val)
                    result.add(Arrays.asList(temp, nums[left], nums[right]));
                right--;
                left++;
            }
        }

        return result;
    }


}
