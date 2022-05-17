package leetcode.problem;

/**
 * 2042. 检查句子中的数字是否递增
 * https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
 */
public class AreNumbersAscending {
    public boolean areNumbersAscending(String s) {
        String[] strs = s.split(" ");
        int num = -1;
        for (String str : strs) {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                if (Integer.parseInt(str) > num)
                    num = Integer.parseInt(str);
                else
                    return false;
            }
        }
        return true;
    }
}
