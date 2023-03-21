package leetcode.problem;

/**
 * 1016. 子串能表示从 1 到 N 数字的二进制串
 * https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/
 */
public class QueryString {
    public boolean queryString(String s, int n) {
        int m = (n>>1)+1;
        for (int i =m;i<=n;i++){
            if (!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }
}
