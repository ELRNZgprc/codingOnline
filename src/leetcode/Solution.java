package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * Mianshiti 60
     * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
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
     * https://leetcode-cn.com/problems/decode-string/
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
     * https://leetcode-cn.com/problems/sudoku-solver/
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
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
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
     * https://leetcode-cn.com/problems/binary-search/
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
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] hash = new int[128];
        for (int i = 0; i < 128; i++) {
            hash[i] = -1;
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i);
            start = Math.max(start, hash[num] + 1);
            ans = Math.max(ans, i - start + 1);
            hash[num] = i;
        }
        return ans;
    }

    /**
     * 198
     * https://leetcode-cn.com/problems/house-robber/comments/
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        } else {
            int[] memory = new int[length];

            memory[0] = nums[0];
            memory[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < length; i++) {
                memory[i] = Math.max(memory[i - 2] + nums[i], memory[i - 1]);
            }

            return memory[length - 1];
        }
    }

    /**
     * mianshiti 08.11
     * https://leetcode-cn.com/problems/coin-lcci/
     *
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        int[] memory = new int[n + 1];
        int[] icons = {25, 10, 5, 1};
        memory[0] = 1;
        for (int icon :
                icons) {
            for (int i = 1; i <= n; i++) {
                if (i - icon >= 0) {
                    memory[i] = (memory[i] + memory[i - icon]) % 1000000007;
                }
            }
        }
        return memory[n];
    }

    /**
     * 974
     * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        int[] hash = new int[K];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = (sum + A[i]) % K;
            if (sum < 0)
                sum += K;
            hash[sum]++;
        }

        int ans = hash[0];
        for (int i = 0; i < K; i++) {
            if (hash[i] >= 2) {
                ans += (hash[i] * (hash[i] - 1)) / 2;
            }
        }
        return ans;
    }

    /**
     * mainshiti58
     * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 84
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
     *
     * @param heights
     * @return
     */

    public int largestRectangleArea(int[] heights) {
        if (heights.length > 0) {
            int max = heights[0];

            for (int i = 0; i < heights.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (heights[j] > heights[i]) {
                        heights[j] = heights[i];
                    }
                }
                for (int j = 0; j <= i; j++) {
                    if ((heights[j] * (i - j + 1)) > max) {
                        max = heights[j] * (i - j + 1);
                    }
                }
            }
            return max;
        } else {
            return 0;
        }
    }

    /**
     * 14
     * https://leetcode-cn.com/problems/longest-common-prefix/
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length > 0) {
            int len = strs[0].length();
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < len) {
                    len = strs[i].length();
                }
            }

            if (len > 0) {
                StringBuffer sb = new StringBuffer();
                boolean flag = true;
                int i = 0;
                while ((i < len) && (flag)) {
                    char c = strs[0].charAt(i);

                    int j = 1;
                    while ((j < strs.length) && flag) {
                        if (strs[j].charAt(i) != c) {
                            flag = false;
                        }
                        j++;
                    }
                    if (flag) {
                        sb.append(c);
                    }
                    i++;
                }
                return sb.toString();
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    /**
     * 1108
     * https://leetcode-cn.com/problems/defanging-an-ip-address/
     *
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    /**
     * 1431
     * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
     *
     * @param candies      int[]
     * @param extraCandies int
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();

        int max = 0;
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > candies[max]) {
                max = i;
            }
        }

        for (int i = 0; i < candies.length; i++) {
            ans.add(candies[max] - candies[i] <= extraCandies);
        }

        return ans;
    }

    /**
     * 56
     * https://leetcode-cn.com/problems/merge-intervals/
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> ans = new ArrayList<>();

        int[] pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= pre[1]) {
                pre[1] = Math.max(intervals[i][1], pre[1]);
            } else {
                ans.add(pre);
                pre = intervals[i];
            }
        }
        ans.add(pre);
        return ans.toArray(new int[ans.size()][2]);
    }

    /**
     * 235
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val - root.val) * (q.val - root.val) <= 0) {
            return root;
        }
        if ((q.val > root.val) && (p.val > root.val)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }

    /**
     * 19
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if ((head == null) || (head.next == null)) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        if (q == null) {
            return head.next;
        }
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }

    /**
     * 11
     * https://leetcode-cn.com/problems/container-with-most-water/
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j= height.length-1;
        int ans = 0;
        while (i<j){
            ans= Math.max (ans,Math.min(height[i],height[j])*(j-i));
            if (height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return ans;
    }
}



