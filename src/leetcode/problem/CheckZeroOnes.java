package leetcode.problem;

/**
 * 1869. 哪种连续子字符串更长
 * https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros/
 */
public class CheckZeroOnes {
    public boolean checkZeroOnes(String s) {
        int length1 = 0;
        int length0 = 0;
        char flag = s.charAt(0);
        int length = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == flag) {
                length++;
            } else {
                if (flag == '1') {
                    length1 = Math.max(length, length1);
                } else {
                    length0 = Math.max(length, length0);
                }
                flag = s.charAt(i);
                length = 1;
            }
        }
        if (flag == '1') {
            length1 = Math.max(length, length1);
        } else {
            length0 = Math.max(length, length0);
        }
        return length1 > length0;
    }
}
