package bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3_15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for (int i = 0; i < result.size(); i++)     System.out.println(result.get(i));

    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length - 1] < 0 || nums.length < 3)
            return result;

        int temp = 0, left = 0, right = 0, val = 0;
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            temp = nums[i];
            left = i + 1;
            right = nums.length - 1;
            val = -temp;

            while(left < right){
                if(nums[left] + nums[right] == val){
                    tempList.add(temp);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    result.add(tempList);
                    tempList.clear();
                }
                right--;
                left++;
            }
        }

        return result;
    }


}
