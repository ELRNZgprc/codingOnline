package leetcode.problem;

/**
 * 482. 密钥格式化
 * https://leetcode-cn.com/problems/license-key-formatting/
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (((c >= '0') && (c <= '9')) || ((c >= 'A') && (c <= 'Z'))) {
                sb.append(c);
            } else if ((c >= 'a') && (c <= 'z')) {
                sb.append((char) (c - 'a' + 'A'));
            }
        }
        for (int i = sb.length() - K; i > 0; i -= K) {
            sb.insert(i, '-');
        }
        return sb.toString();
    }
}
