package leetcode.problem;

/**
 * 1791. 找出星型图的中心节点
 * https://leetcode-cn.com/problems/find-center-of-star-graph/
 */
public class FindCenter {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
