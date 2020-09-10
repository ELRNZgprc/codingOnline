package leetcode.problem;

public class CountSegments {
    /**
     * 434. 字符串中的单词数
     * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
     */
    public int countSegments(String s) {
        if (s.equals("")) {
            return 0;
        }
        String[] arr = s.split(" ");
        int len = 0;
        for (String t : arr) {
            if (!(t.equals(" ") || t.isEmpty())) {
                len++;
            }

        }
        return len;
    }
}
