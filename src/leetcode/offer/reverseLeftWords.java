package leetcode.offer;

public class reverseLeftWords {
    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
