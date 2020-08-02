package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 2;

        int[][] prerequisites = {{0,1}};

        System.out.println(solution.canFinish(n,prerequisites));
    }
}
