import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int removeDuplicates(int[] nums) {
        int num[] = {1,1,1,1,2,2,2};
        nums = num;
        int dupcount = 0, pos = 0;
        int count = nums.length;
        if (nums.length <= 2)
            return nums.length;
        
        for(int i = 0; i < (nums.length-2); i++){
            if(nums[i] == nums[i+1] && (dupcount == 0 || dupcount == 1 ||dupcount > 2))                     dupcount++;
            if(nums[i] == nums[i+1] && dupcount == 2){
                pos = i;
                dupcount++;
            } 
            if(nums[i] != nums[i+1]){
                nums[pos] = nums[i+1];
                count -= dupcount;
                dupcount = 0;
                pos = i;
            }
        }
        return count;
    }
}


public class MainClass_80 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            int ret = new Solution().removeDuplicates(nums);
            String out = integerArrayToString(nums, ret);
            
            System.out.print(out);
        }
    }
}