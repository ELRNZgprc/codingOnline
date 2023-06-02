package leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. 查找和替换模式
 * https://leetcode.cn/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] mode = new int[pattern.length()];
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] pc = pattern.toCharArray();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pc[i])) {
                mode[i] = map.get(pc[i]);
            } else {
                count++;
                map.put(pc[i], count);
                mode[i] = count;
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            count = 0;
            map.clear();
            boolean match = true;
            char[] wc = word.toCharArray();
            for (int i = 0; i < wc.length; i++) {
                if (!map.containsKey(wc[i])) {
                    count++;
                    map.put(wc[i], count);
                }
                if (map.get(wc[i]) != mode[i]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                res.add(word);
            }
        }
        return res;
    }
}
