package leetcode.problem;

public class Encode {
    /**
     * 1256. 加密数字
     * https://leetcode-cn.com/problems/encode-number/
     */
    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
