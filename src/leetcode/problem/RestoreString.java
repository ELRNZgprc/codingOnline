package leetcode.problem;

public class RestoreString {
    /**
     * 1528. 重新排列字符串
     * https://leetcode-cn.com/problems/shuffle-string/
     */
    public String restoreString(String s, int[] indices) {

        char[] ans = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            ans[indices[i]] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
