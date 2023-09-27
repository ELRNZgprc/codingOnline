package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1333. 餐厅过滤器
 * https://leetcode.cn/problems/filter-restaurants-by-vegan-friendly-price-and-distance/description/
 */
public class FilterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> filtered = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance && !(veganFriendly == 1 && restaurant[2] == 0)) {
                filtered.add(restaurant);
            }
        }
        filtered.sort((a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int[] v : filtered) {
            res.add(v[0]);
        }
        return res;
    }
}
