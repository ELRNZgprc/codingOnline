package leetcode.problem;

/**
 * 2546. 执行逐位运算使字符串相等
 * https://leetcode.cn/problems/apply-bitwise-operations-to-make-strings-equal/
 */
public class MakeStringsEqual {
    public boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1");
    }
}
