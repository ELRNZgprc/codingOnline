package leetcode.problem;

/**
 * 357. 统计各位数字都不同的数字个数
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        int []dp=new int [n+1];
        dp[0]=1;
        dp[1]=10;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+(dp[i-1]-dp[i-2])*(10-(i-1));
        }
        return dp[n];
    }
}
