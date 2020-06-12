package leetcode;

public class Run {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums = {89,62,70,58,47,47,46,76,100,70};
        int[] ans = solution.dailyTemperatures(nums);
        for (int i = 0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}
