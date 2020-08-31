package leetcode.mst;

public class CompressString {
    /**
     * 面试题 01.06. 字符串压缩
     * https://leetcode-cn.com/problems/compress-string-lcci/
     */
    public String compressString(String S) {
        int len = S.length();
        if (len == 0) {
            return "";
        }

        char[] chars = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(chars[0]);

        int index = 0;
        int cnt = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] == chars[index]) {
                cnt++;
            } else {
                stringBuilder.append(chars[index]);
                stringBuilder.append(cnt);
                index = i;
                cnt = 1;
            }
        }

        stringBuilder.append(chars[len - 1]);
        stringBuilder.append(cnt);

        String res = stringBuilder.toString();
        if (res.length() >= len) {
            return S;
        }
        return res;
    }
}
