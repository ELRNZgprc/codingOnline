package leetcode.lcp;

public class NumWays {
	/**
	 * LCP 07. ´«µÝÐÅÏ¢
	 * https://leetcode-cn.com/problems/chuan-di-xin-xi/
	 */
	private int plans = 0;

    public int numWays(int n, int[][] relation, int k) {
    	pass(0, 1, n, relation, k);
    	return plans;
    }   

    public void pass(int start, int times, int n, int[][] relation, int k) {
    	for (int i = 0; i < relation.length; i++) {
			if (relation[i][0] == start) {
				if (times == k) {
					if (relation[i][1] == n - 1) {
						plans++;
					}
				} else {
					pass(relation[i][1], times + 1, n, relation, k);					
				}
			}
    	}
    }
}
