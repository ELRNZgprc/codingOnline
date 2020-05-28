package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * Mianshiti 60
     *
     * @param n int
     * @return a double[]
     */
    public double[] twoSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        double[] ans = new double[5 * n + 1];

        int[][] sum = new int[n + 1][6 * n + 1];
        int i, j;

        for (j = 1; j <= 6; j++)
            sum[1][j] = 1;

        for (i = 2; i <= n; i++) {
            for (j = i; j <= 6 * i; j++) {
                int left = ((j - 6) > (i - 1)) ? j - 6 : i - 1;
                int right = ((j - 1) > (6 * i - 6)) ? 6 * i - 6 : j - 1;
                sum[i][j] = 0;
                for (int k = left; k <= right; k++) {
                    sum[i][j] += sum[i - 1][k] * sum[1][j - k];
                }
            }
        }

        int total = 0;
        for (j = n; j <= 6 * n; j++) {
            total += sum[n][j];
        }


        for (j = n; j <= 6 * n; j++) {
            ans[j - n] = ((double) sum[n][j]) / total;
        }


        return ans;
    }

    /**
     * 394
     *
     * @param s String
     * @return String
     */
    public String decodeString(String s) {
        return work(s, 0, s.length());
    }

    static String work(String s, int begin, int end) {
        String ans = "";
        int i = begin;
        int times;
        while (i < end) {
            if ((s.charAt(i) < '0') || (s.charAt(i) > '9')) {
                ans = ans + s.charAt(i);
                i++;
            } else {
                times = 0;
                while ((s.charAt(i) != '[')) {
                    times *= 10;
                    times += s.charAt(i) - '0';
                    i++;
                }
                int l = 1;
                int j = i + 1;
                do {
                    if (s.charAt(j) == '[') l++;
                    if (s.charAt(j) == ']') l--;
                    j++;
                } while (l > 0);
                String newans = work(s, i + 1, j - 1);
                for (int k = 0; k < times; k++) {
                    ans = ans + newans;
                }
                i = j;
            }
        }
        return ans;
    }


    /**
     * 37
     *
     * @param board char[][]
     */

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                row[i][j] = true;
                col[i][j] = true;
                block[i][j] = true;
            }
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = false;
                    col[j][num] = false;
                    block[i / 3 * 3 + j / 3][num] = false;
                }
            }
        }
        work(board, row, col, block, 0, 0);
    }

    private boolean work(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int n, int m) {
        while (board[n][m] != '.') {
            m++;
            if (m >= 9) {
                m = 0;
                n++;
            }
            if (n >= 9) {
                return true;
            }
        }
        int blockNumber = n / 3 * 3 + m / 3;
        for (int num = 1; num <= 9; num++) {
            if (row[n][num - 1] && col[m][num - 1] && block[blockNumber][num - 1]) {
                board[n][m] = (char) (num + '0');
                row[n][num - 1] = false;
                col[m][num - 1] = false;
                block[blockNumber][num - 1] = false;
                if (work(board, row, col, block, n, m)) {
                    return true;
                } else {
                    board[n][m] = '.';
                    row[n][num - 1] = true;
                    col[m][num - 1] = true;
                    block[blockNumber][num - 1] = true;
                }
            }
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 111
     *
     * @param root TreeNode
     * @return int
     */

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * 704
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int half = (i + j) / 2;
            if (nums[half] == target) {
                return half;
            } else if (nums[half] > target) {
                j = half - 1;
            } else {
                i = half + 1;
            }
        }
        return -1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 2
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode p = root;
        int flag = 0;
        while ((l1 != null) || (l2 != null) || (flag > 0)) {
            int ans = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + flag;
            flag = ans / 10;
            ans = ans % 10;
            ListNode q = new ListNode(ans);
            p.next = q;
            p = q;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }

    /**
     * 3
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] hash = new int[128];
        for(int i= 0;i<128;i++){
            hash[i]=-1;
        }
        int start= 0;
        for (int i = 0;i<s.length();i++){
            int num = s.charAt(i);
            start = Math.max(start,hash[num]+1);
            ans = Math.max(ans,i-start+1);
            hash[num] = i;
        }
        return ans;
    }
}


