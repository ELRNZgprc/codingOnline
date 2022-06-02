package leetcode.problem;

/**
 * 2129. 将标题首字母大写
 * https://leetcode.cn/problems/capitalize-the-title/
 */
public class CapitalizeTitle {
    public String capitalizeTitle(String title) {
        StringBuffer res = new StringBuffer();
        String[] strs = title.split(" ");
        for (String str : strs) {
            if (str.length() > 2) {
                res.append(str.substring(0, 1).toUpperCase());
                res.append(str.substring(1, str.length()).toLowerCase());
            } else {
                res.append(str.toLowerCase());
            }
            res.append(" ");
        }
        return res.toString().trim();
    }
}
