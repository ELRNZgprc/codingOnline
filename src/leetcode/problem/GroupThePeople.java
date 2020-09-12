package leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {
    /**
     * 1282. 用户分组
     * https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to/
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                map.get(groupSizes[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while (i < map.get(key).size()) {
                list.add(map.get(key).get(i));
                i++;
                if (i % key == 0) {
                    ans.add(list);
                    list = new ArrayList<>();
                }
            }
        }
        return ans;
    }
}
