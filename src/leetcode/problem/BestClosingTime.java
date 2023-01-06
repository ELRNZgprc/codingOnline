package leetcode.problem;

/**
 * 2483. 商店的最少代价
 * https://leetcode.cn/problems/minimum-penalty-for-a-shop/
 */
public class BestClosingTime {
    public int bestClosingTime(String customers) {
        int nNum = 0, yNum = 0;
        char[] charArray = customers.toCharArray();
        for (char ch : charArray) {
            if (ch == 'Y') {
                yNum++;
            } else {
                nNum++;
            }
        }
        int preNNum = 0, preYNum = 0, res = 0;
        int minCost = yNum;
        for (int j = 0; j <= charArray.length; j++) {
            int cost = yNum - preYNum + preNNum;
            ;
            if (j != charArray.length && charArray[j] == 'Y') {
                preYNum++;
            } else if (j != charArray.length && charArray[j] == 'N') {
                preNNum++;
            }
            if (cost < minCost) {
                res = j;
                minCost = cost;
            }
        }
        return res;
    }
}
