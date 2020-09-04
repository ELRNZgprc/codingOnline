package leetcode.problem;

public class GcdOfStrings {
    /**
     * 1071. 字符串的最大公因子
     * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    int gcd(int i, int j) {
        return (j == 0) ? i : gcd(j, i % j);
    }
}
