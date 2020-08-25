package leetcode.problem;

public class MissingNumber {
    /**
     * 268. 缺失数字
     * https://leetcode-cn.com/problems/missing-number/
     */
    public int missingNumber(int[] nums) {
        int[] hash = new int[nums.length+1];
        for (int num:nums){
            hash[num]++;
        }
        for (int i = 0;i<hash.length;i++){
            if (hash[i]==0){
                return i;
            }
        }
        return 0;
    }
}
