package leetcode.problem;

/**
 * 2109. 向字符串添加空格
 * https://leetcode.cn/problems/adding-spaces-to-a-string/s
 */
public class AddSpaces {
    public String addSpaces(String s, int[] spaces) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length + spaces.length];
        for (int i = 0; i < spaces.length; i++) {
            newChars[spaces[i] + i] = ' ';
        }
        int index = 0;
        for (int i = 0; i < newChars.length; i++) {
            if (newChars[i] != ' ') {
                newChars[i] = chars[index];
                index++;
            }
        }
        return new String(newChars);
    }
}
