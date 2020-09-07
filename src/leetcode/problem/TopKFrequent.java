package leetcode.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    /**
     * 347. 前 K 个高频元素
     * https://leetcode-cn.com/problems/top-k-frequent-elements/
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->map.get(x)-map.get(y));
        int cnt = 0;
        for(int key: map.keySet()){
            if(cnt > k)
                pq.poll();
            pq.offer(key);
            cnt++;
        }

        int[] ans = new int[k];
        if(cnt > k)
            pq.poll();
        for(int i = k-1; i >= 0; i--){
            ans[i] = pq.poll();
        }

        return ans;
    }
}
