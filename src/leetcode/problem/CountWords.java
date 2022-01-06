package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2085. 统计出现过一次的公共字符串
 * https://leetcode-cn.com/problems/count-common-words-with-one-occurrence/
 */
public class CountWords {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String word : words1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }

        int ans = 0;
        for (String key : map1.keySet()) {
            if ((map1.get(key) == 1) && ((map2.containsKey(key)) && (map2.get(key) == 1))) {
                ans++;
            }
        }
        return ans;
    }
}
