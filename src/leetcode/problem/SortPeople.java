package leetcode.problem;

/**
 * 2418. 按身高排序
 * https://leetcode.cn/problems/sort-the-people/
 */
public class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] < heights[j]) {
                    int h = heights[i];
                    heights[i] = heights[j];
                    heights[j] = h;
                    String s = names[i];
                    names[i] = names[j];
                    names[j] = s;
                }
            }
        }
        return names;
    }
}
