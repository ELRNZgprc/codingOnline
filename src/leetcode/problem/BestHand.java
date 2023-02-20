package leetcode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2347. 最好的扑克手牌
 * https://leetcode.cn/problems/best-poker-hand/
 */
public class BestHand {
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> set = new HashSet<>();
        int[] hash = new int[14];
        for (char suit : suits) {
            set.add(suit);
        }
        int cnt = 0;
        if (set.size() == 1) {
            return "Flush";
        }
        for (int rank : ranks) {
            hash[rank]++;
        }
        for (int i = 1; i < 14; i++) {
            if (hash[i] >= 3) return "Three of a Kind";
            if (hash[i] >= 1) cnt++;
        }
        for (int i = 1; i < 14; i++) {
            if (hash[i] >= 2) return "Pair";
        }
        if (cnt >= 5) {
            return "High Card";
        }
        return "";
    }
}
