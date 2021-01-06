package leetcode.mst;

import java.util.ArrayList;
import java.util.Arrays;

public class PondSizes {
	/**
	 * 面试题 16.19. 水域大小
	 * https://leetcode-cn.com/problems/pond-sizes-lcci/
	 */
	public int[] pondSizes(int[][] land) {
        int count=0;
        ArrayList<Integer> resList=new ArrayList<>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==0){
                    count=dfs(land, i, j);
                    resList.add(count);
                }
            }
        }
        int[] res=new int[resList.size()];
        for(int i=0;i<resList.size();i++){
            res[i]=resList.get(i);
        }
        Arrays.sort(res);
        return res;
    }
    public int dfs(int[][] land, int i, int j){
        if(i<0 || i>=land.length || j<0 || j>=land[0].length || land[i][j]!=0){
            return 0;
        }
        land[i][j]=-1;
        int count=1;
        count+=dfs(land, i+1, j);
        count+=dfs(land, i-1, j);
        count+=dfs(land, i, j+1);
        count+=dfs(land, i, j-1);
        count+=dfs(land, i+1, j+1);
        count+=dfs(land, i-1, j+1);
        count+=dfs(land, i-1, j-1);
        count+=dfs(land, i+1, j-1);
        return count;
    }
}
