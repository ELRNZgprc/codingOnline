package leetcode;

public class Run {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] numbers = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(solution.minSubArrayLen(target,numbers));
    }
}
