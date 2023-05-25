package leetcode.problem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1377. T 秒后青蛙的位置
 * https://leetcode.cn/problems/frog-position-after-t-seconds/
 */
public class FrogPosition {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Deque<int[]> q = new LinkedList<>();
        boolean[][] f = new boolean[n+1][n+1];
        int[] let = new int[n+1];
        for(int[] edge : edges){
            f[edge[0]][edge[1]] = true;
            f[edge[1]][edge[0]] = true;
            let[edge[0]]++;
            let[edge[1]]++;
        }
        q.add(new int[]{1,1});
        int size = 1;
        while(!q.isEmpty() && t >= 0) {
            int[] res = q.poll();
            if(res[0] == target) {
                return let[target] > 0 && t > 0 ? 0.0 : 1.0/res[1];
            }
            for(int i=1; i<=n; i++){
                if(f[res[0]][i]){
                    q.add(new int[]{i,res[1]*let[res[0]]});
                    f[res[0]][i] = false;
                    f[i][res[0]] = false;
                    let[i]--;
                }
            }
            if(--size <= 0){
                size = q.size();
                t--;
            }
        }
        return 0.0;
    }
}
