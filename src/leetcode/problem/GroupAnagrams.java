package leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    /**
     * 49. 字母异位词分组
     * https://leetcode-cn.com/problems/group-anagrams/
     */
    int[] nums = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            long strn = toNumber(str);
            if (map.containsKey(strn)) {
                map.get(strn).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(strn, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (long k : map.keySet()) {
            ans.add(map.get(k));
        }
        return ans;
    }

    long toNumber(String str) {
        long ans = 1;
        for (char c : str.toCharArray()) {
            ans = (ans * nums[c - 'a']);
        }
        return ans;
    }
}

