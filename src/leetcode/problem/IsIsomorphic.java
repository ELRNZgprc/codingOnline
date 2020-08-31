package leetcode.problem;

public class IsIsomorphic {
    /**
     * 205. 同构字符串
     * https://leetcode-cn.com/problems/isomorphic-strings/
     */
    public boolean isIsomorphic(String s, String t) {
        char[] sFlag = new char[260];
        char[] tFlag = new char[260];
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((sFlag[s.charAt(i)] == 0) && (tFlag[t.charAt(i)] == 0)) {
                sFlag[s.charAt(i)] = t.charAt(i);
                tFlag[t.charAt(i)] = s.charAt(i);
            } else if ((sFlag[s.charAt(i) ] != t.charAt(i)) || (tFlag[t.charAt(i)] != s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
