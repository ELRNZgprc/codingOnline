package leetcode.offer;

public class NumWays {
    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
     */
    public int numWays(int n) {
        if (n==0) return 1;
        if (n==1) return 1;
        int a= 1;
        int b =1;
        int ans =2;
        for (int i = 3;i<=n;i++){
            b=a;
            a=ans;
            ans = (a+b)%(1000000007);
        }
        return ans;
    }
}
