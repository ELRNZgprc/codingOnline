package leetcode.offer;

public class IsNumber {
    /**
     * 剑指 Offer 20. 表示数值的字符串
     * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
     */
    public boolean isNumber(String s) {
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            return false;
        }

        if ((s.indexOf("f") != -1 || s.indexOf("F") != -1 || s.indexOf("d") != -1 || s.indexOf("D") != -1)) {
            return false;
        }

        return true;
    }
}
