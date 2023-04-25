package leetcode.problem;

/**
 * 2079. 给植物浇水
 * https://leetcode.cn/problems/watering-plants/
 */
public class WateringPlants {
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int ans = 0, cur = capacity, i = 0;
        while (i < n) {
            cur -= plants[i++];
            if (i < n && cur < plants[i]) {
                ans += 2 * i;
                cur = capacity;
            }
            ans++;
        }
        return ans;
    }
}
