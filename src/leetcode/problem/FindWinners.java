package leetcode.problem;

import java.util.*;

/**
 * 2225. 找出输掉零场或一场比赛的玩家
 * https://leetcode.cn/problems/find-players-with-zero-or-one-losses/
 */
public class FindWinners {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
            if (!map.containsKey(match[0])) {
                map.put(match[0], 0);
            }
        }
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == 0) {
                list0.add(key);
            }
            if (map.get(key) == 1) {
                list1.add(key);
            }
        }
        Collections.sort(list0);
        Collections.sort(list1);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(list0);
        ans.add(list1);
        return ans;
    }
}
