package leetcode.offer;

public class FindNthDigit {
    /**
     * 剑指 Offer 44. 数字序列中某一位的数字
     * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
     */
    public int findNthDigit(int n) {
        long begin = 1;
        int k = 1;
        long length = 9;
        while (n > length) {
            n -= length;
            begin *= 10;
            k++;
            length = length / (k - 1) * k * 10;
        }
        begin += ((n - 1) / k);
        return Long.toString(begin).charAt((n - 1) % k) - '0';
    }
}
