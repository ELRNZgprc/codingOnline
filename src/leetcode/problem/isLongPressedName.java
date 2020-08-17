package leetcode.problem;

public class isLongPressedName {
    /**
     * 925
     * https://leetcode-cn.com/problems/long-pressed-name/
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while ((i < name.length()) && (j < typed.length())) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if ((j > 0) && (typed.charAt(j) == typed.charAt(j - 1))) {
                j++;
            } else {
                return false;
            }
        }
        if (i == name.length()) {
            while (j < typed.length() - 1) {
                j++;
                if (typed.charAt(j) != typed.charAt(j - 1)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
