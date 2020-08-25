package leetcode.problem;

public class KthFactor {
    /**
     * 1492. n 的第 k 个因子
     * https://leetcode-cn.com/problems/the-kth-factor-of-n/
     */
    public int kthFactor(int n, int k) {
        int count =0;
        for (int i =1;i<=n;i++){
            if (n%i==0){
                count++;
                if (count == k){
                    return i;
                }
            }
        }
        return -1;
    }
}
