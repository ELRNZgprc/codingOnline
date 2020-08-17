package leetcode.problem;

import java.util.HashSet;
import java.util.Set;

public class numUniqueEmails {
    /**
     * 929
     * https://leetcode-cn.com/problems/unique-email-addresses/
     */
    public int numUniqueEmails(String[] emails) {
        if (emails.length < 1) return 0;

        Set<String> set = new HashSet<>();
        for (String str : emails) {
            String[] strs = str.split("@");
            strs[0] = strs[0].replace(".", "");
            if (strs[0].contains("+")) {
                strs[0] = strs[0].substring(0, strs[0].indexOf("+"));
            }
            set.add(strs[0] + "@" + strs[1]);
        }
        return set.size();
    }
}
