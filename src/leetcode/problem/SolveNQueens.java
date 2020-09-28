package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
	/**
	 * 51. N 皇后
	 * https://leetcode-cn.com/problems/n-queens/
	 */
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n==0)
            return res;
        int[][] read = new int[n][n];
        getRes(n,0,res,read);
        return res;
    }

    private void getRes(int n,int cur,List<List<String>> res,int[][] read){
        if (cur==n){
            ArrayList<String> temp = new ArrayList<>();
            for (int[] ints : read) {
                StringBuilder sb = new StringBuilder();
                for (int i : ints) {
                    if (i==-1)
                        sb.append('Q');
                    else sb.append('.');
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (read[cur][i] == 0){
                change(cur,i,n,read,1);
                read[cur][i] = -1;

                getRes(n,cur+1,res,read);
                change(cur,i,n,read,-1);
                read[cur][i] = 0;
            }
        }
    }

    private void change(int row,int col,int n,int[][] read,int flag){
        for (int j = 0; j < n; j++) {
            read[row][j]+=flag;
            read[j][col]+=flag;
        }

        int cha;
        if (row>col){
            cha = row-col;
            for (int j = cha; j <n ; j++) {
                read[j][j-cha]+=flag;
            }
        }else {
            cha = col-row;
            for (int j = cha; j <n ; j++) {
                read[j-cha][j]+=flag;
            }
        }
        
        int add= row+col;
        if (add>n-1){
            add = row+col;
            for (int j = n-1; j >add-n ; j--) {
                read[j][add-j]+=flag;
            }
        }else {
            for (int j = add; j >=0 ; j--) {
                read[j][add-j]+=flag;
            }
        }
    }
}
