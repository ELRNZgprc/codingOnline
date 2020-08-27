package leetcode.problem;

import java.util.*;

public class FindItinerary {
    /**
     * 332. 重新安排行程
     * https://leetcode-cn.com/problems/reconstruct-itinerary/
     */
    private Map<String, PriorityQueue<String>> map = new HashMap<>();

    private List<String> resList = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!map.containsKey(src)) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(src, pq);
            }
            map.get(src).add(dst);
        }
        dfs("JFK");
        return resList;
    }

    private void dfs(String src) {
        PriorityQueue<String> pq = map.get(src);
        while (pq != null && !pq.isEmpty())
            dfs(pq.poll());
        ((LinkedList<String>) resList).addFirst(src);
    }
}
