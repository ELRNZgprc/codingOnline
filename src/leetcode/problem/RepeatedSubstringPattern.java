package leetcode.problem;

public class RepeatedSubstringPattern {
    /**
     * 459. 重复的子字符串
     * https://leetcode-cn.com/problems/repeated-substring-pattern/
     */
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).substring(1,s.length()*2-2).contains(s);
    }
}
