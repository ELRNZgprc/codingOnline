package leetcode.offer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class TranslateNum {
    public int translateNum(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] dp = new int[nums.length];

        dp[0]=1;
        for (int i =1;i<dp.length;i++){
            if (i==1){
                dp[i]=((nums[0]=='1')||((nums[0]=='2')&&(nums[1]<='5')))?2:1;
            } else {
                dp[i]=((nums[i-1]=='1')||((nums[i-1]=='2')&&(nums[i]<='5')))?dp[i-1]+dp[i-2]:dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
