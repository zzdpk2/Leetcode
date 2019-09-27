import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        result.add(new ArrayList<>(col));
        if(nums.length == 0)
            return result;
        bk(0,result,col,nums);
        return result;

    }

    public void bk(int start, List<List<Integer>> result, ArrayList<Integer> subset, int[] nums){
        for(int i = start; i < nums.length; i++){

            System.out.println("i for new loop: " + i);
            subset.add(nums[i]);

            System.out.println("subset: " + subset);
            result.add(new ArrayList<>(subset));

            System.out.println("result:" + result);
            bk(i + 1, result, subset, nums);

            System.out.println("i:" + i);

            subset.remove(subset.size() - 1);
            System.out.println("subset(removed): " + subset);
        }
    }
}

public class Main {
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Solution().subsets(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}