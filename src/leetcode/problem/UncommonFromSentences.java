package leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884. 两句话中的不常见单词
 * https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 */
public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] total = (s1 + " " + s2).split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String s : total) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> ansList = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                ansList.add(s);
            }
        }

        return ansList.toArray(new String[0]);
    }
}
