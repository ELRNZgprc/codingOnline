package leetcode.problem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanVisitAllRooms {
    /**
     * 841. 钥匙和房间
     * https://leetcode-cn.com/problems/keys-and-rooms/
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() <= 1) {
            return true;
        }
        int n = rooms.size();
        boolean[] flags = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        flags[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            List<Integer> room = rooms.get(num);
            for (int i = 0; i < room.size(); i++) {
                if (!flags[room.get(i)]) {
                    flags[room.get(i)] = true;
                    queue.add(room.get(i));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!flags[i]) {
                return false;
            }
        }
        return true;
    }
}
