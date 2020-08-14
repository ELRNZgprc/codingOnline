package leetcode;

import java.util.*;

public class Solution {
    /**
     * Mianshiti 60
     * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
     */
    public double[] twoSum(int n) {
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

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 111
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
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
     * https://leetcode-cn.com/problems/binary-search/
     */
    public int search704(int[] nums, int target) {
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

        ListNode() {
        }
    }

    /**
     * 2
     * https://leetcode-cn.com/problems/binary-search/
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
     * 面试题 08.11
     * https://leetcode-cn.com/problems/coin-lcci/
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
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 84
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
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
     */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    /**
     * 1431
     * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
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
     */
    public TreeNode lowestCommonAncestor235(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val - root.val) * (q.val - root.val) <= 0) {
            return root;
        }
        if ((q.val > root.val) && (p.val > root.val)) {
            return lowestCommonAncestor235(root.right, p, q);
        } else {
            return lowestCommonAncestor235(root.left, p, q);
        }
    }

    /**
     * 19
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
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
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int ans = 0;
        while (i < j) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, "", 0, 0, n);
        return ans;
    }

    /**
     * 22
     * https://leetcode-cn.com/problems/generate-parentheses/
     */
    public void generate(List<String> ans, String str, int left, int right, int n) {
        if ((left == n) && (right == n)) {
            ans.add(str);
        } else {
            if (left < n) {
                generate(ans, str + "(", left + 1, right, n);
            }
            if (right < left) {
                generate(ans, str + ")", left, right + 1, n);
            }
        }
    }

    /**
     * 45
     * https://leetcode-cn.com/problems/jump-game-ii/
     */
    public int jump(int[] nums) {
        int[] record = new int[nums.length];

        record[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            record[i] = -1;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    if ((record[i + j] == -1) || (record[i + j] > record[i] + 1)) {
                        record[i + j] = record[i] + 1;
                    }
                }
            }
        }

        return record[nums.length - 1];
    }

    /**
     * 1346
     * https://leetcode-cn.com/problems/check-if-n-and-its-double-exist/
     */
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[j] == 2 * arr[i]) || (arr[i] == 2 * arr[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 921
     * https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
     */
    public int minAddToMakeValid(String S) {
        int left = 0;
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    ans++;
                }
            }
        }
        ans += left;
        return ans;
    }

    /**
     * 837
     * https://leetcode-cn.com/problems/new-21-game/
     */
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        dp[0] = 1.0;
        double pos = 0;
        for (int i = 1; i <= K + W - 1; i++) {
            if (i - W - 1 >= 0) {
                pos -= dp[i - W - 1];
            }
            if (i - 1 < K) {
                pos += dp[i - 1];
            }
            dp[i] = pos * 1.0 / W;
        }
        double sum = 0;
        double usable = 0;
        for (int i = K; i <= N; i++) {
            if (i <= K + W - 1) {
                usable += dp[i];
            }
        }
        for (int i = K; i <= K + W - 1; i++) {
            sum += dp[i];
        }
        return usable / sum;
    }

    /**
     * 238
     * https://leetcode-cn.com/problems/product-of-array-except-self/
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    /**
     * 929
     * https://leetcode-cn.com/problems/unique-email-addresses/
     */
    public int numUniqueEmails(String[] emails) {
        if (emails.length < 1) return 0;

        Set<String> set = new HashSet<>();
        for (String str : emails) {
            String[] strs = str.split("@");
            strs[0] = strs[0].replace(".", "");
            if (strs[0].contains("+")) {
                strs[0] = strs[0].substring(0, strs[0].indexOf("+"));
            }
            set.add(strs[0] + "@" + strs[1]);
        }
        return set.size();
    }

    /**
     * 15
     * https://leetcode-cn.com/problems/3sum/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if ((i == 0) || ((i > 0) && (nums[i] != nums[i - 1]))) {
                int j = i + 1;
                int k = nums.length - 1;
                int target = 0 - nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        ans.add((Arrays.asList(nums[i], nums[j], nums[k])));
                        while ((j < k) && (nums[j + 1] == nums[j])) j++;
                        while ((j < k) && (nums[k - 1] == nums[k])) k--;
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < target) {
                        while ((j < k) && (nums[j + 1] == nums[j])) j++;
                        j++;
                    } else {
                        while ((j < k) && (nums[k - 1] == nums[k])) k--;
                        k--;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 9
     * https://leetcode-cn.com/problems/palindrome-number/
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int target = 0;

        while (y > 0) {
            int i = y % 10;
            target = target * 10 + i;
            y /= 10;
        }
        return (target == x);
    }

    /**
     * 739
     * https://leetcode-cn.com/problems/daily-temperatures/
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> z = new Stack<>();
        int[] ans = new int[T.length];
        z.push(T.length - 1);
        ans[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            while ((!z.isEmpty()) && (T[z.peek()] <= T[i])) {
                z.pop();
            }

            if (!z.isEmpty()) {
                ans[i] = z.peek() - i;
            } else
                ans[i] = 0;

            z.push(i);
        }
        return ans;
    }

    /**
     * 1014
     * https://leetcode-cn.com/problems/best-sightseeing-pair/
     */
    public int maxScoreSightseeingPair(int[] A) {
        int ans = -1;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            int mem = max + A[i] - i;
            if ((ans == -1) || (mem > ans)) {
                ans = mem;
            }
            if (A[i] + i > max) {
                max = A[i] + i;
            }
        }
        return ans;
    }

    /**
     * 1221
     * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
     */
    public int balancedStringSplit(String s) {
        int ans = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                l++;
            }
            if (s.charAt(i) == 'L') {
                l--;
            }
            if (l == 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 319
     * https://leetcode-cn.com/problems/bulb-switcher/
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    /**
     * 125
     * https://leetcode-cn.com/problems/valid-palindrome/
     */
    public boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        s = s.toLowerCase();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (((s.charAt(i) <= '9') && (s.charAt(i) >= '0')) || ((s.charAt(i) <= 'z') && ((s.charAt(i) >= 'a')))) {
                s1.append(s.charAt(i));
            }
        }
        return s1.toString().equals(s1.reverse().toString());
    }

    /**
     * 167
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     */
    public int[] twoSum167(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ans[0] = left;
                ans[1] = right;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else
                left++;
        }
        return ans;
    }

    /**
     * 209
     * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
     */
    public int minSubArrayLen(int s, int[] nums) {
        int i = -1;
        int j = -1;
        int sum = 0;
        int length = 0;
        while (i < nums.length - 1) {
            while ((i < nums.length - 1) && (sum < s)) {
                i++;
                sum += nums[i];
            }
            while (sum >= s) {
                if ((length == 0) || (i - j < length)) {
                    length = i - j;
                }
                j++;
                sum -= nums[j];
            }
        }
        return length;
    }

    /**
     * 1013
     * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int times = 0;
        sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == target) {
                times++;
                sum = 0;
            }
        }
        return (times == 3) || ((times > 3) && (target == 0));
    }

    /**
     * 1339
     * https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/
     */
    public int maxProduct(TreeNode root) {
        int sum = getSum(root);
        pre(root, sum);
        int k = 1000000007;
        long c = a % k;
        long d = b % k;
        return (int) ((a / k + b / k + a / k * d + b / k * c) % k + c * d % k) % k;
    }

    int getSum(TreeNode p) {
        if (p != null) {
            p.val = p.val + getSum(p.left) + getSum(p.right);
        } else {
            return 0;
        }
        return p.val;
    }

    long a = Integer.MAX_VALUE;
    long b = Integer.MIN_VALUE;

    void pre(TreeNode p, int sum) {
        if (p != null) {
            if (Math.abs(a - b) > Math.abs(sum - 2 * p.val)) {
                a = sum - p.val;
                b = p.val;
            }
            pre(p.left, sum);
            pre(p.right, sum);
        }
    }

    /**
     * 64
     * https://leetcode-cn.com/problems/minimum-path-sum/
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }

        int n = grid.length;
        int m = grid[n - 1].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }

    /**
     * 565
     * https://leetcode-cn.com/problems/array-nesting/
     */
    public int arrayNesting(int[] nums) {
        int length = nums.length;
        int[] nested = new int[length];
        int max = 0;
        int rings = 0;
        for (int i = 0; i < length; i++) {
            if (nested[i] == 0) {
                rings++;
                int curLength = 0;
                int p = i;
                while (nested[p] == 0) {
                    nested[p] = rings;
                    p = nums[p];
                    curLength++;
                }
                if (curLength > max) {
                    max = curLength;
                }
            }
        }
        return max;
    }

    /**
     * 915
     * https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals/
     */
    public int partitionDisjoint(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int length = A.length;
        int[] leftMax = new int[length];
        int[] rightMin = new int[length];

        leftMax[0] = A[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A[i]);
        }

        rightMin[length - 1] = A[length - 1];

        for (int i = length - 2; i > -1; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], A[i]);
        }

        int ans = 0;
        while (leftMax[ans] > rightMin[ans + 1]) {
            ans++;
        }
        return ans + 1;
    }

    /**
     * 面试题 01.09
     * https://leetcode-cn.com/problems/string-rotation-lcci/
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String ss = s2 + s2;
        return ss.contains(s1);
    }

    /**
     * 1046
     * https://leetcode-cn.com/problems/last-stone-weight/
     */
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int length = stones.length - 1;
        for (int i = length; i > 0; i--) {
            stones[length] -= stones[length - 1];
            stones[length - 1] = 0;
            Arrays.sort(stones);
        }
        return stones[length];
    }

    /**
     * 593
     * https://leetcode-cn.com/problems/valid-square/
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isStraight(p1, p2, p3) && isStraight(p1, p2, p4) && isStraight(p1, p3, p4) && isStraight(p3, p2, p4);
    }

    boolean isStraight(int[] p1, int[] p2, int[] p3) {
        int x = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int y = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        int z = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);

        return (((z > x) && (x == y) && (z == x + y)) || ((y > x) && (x == z) && (y == x + z)) || ((x > y) && (z == y) && (x == z + y)));
    }

    /**
     * 343
     * https://leetcode-cn.com/problems/integer-break/
     */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                ans[i] = Math.max(ans[i], ans[j] * (i - j));
            }
        }
        return ans[n];
    }

    /**
     * 335
     * https://leetcode-cn.com/problems/self-crossing/
     */
    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4) return false;
        boolean b = false;
        for (int i = 2; i < x.length; i++) {
            if (b && x[i] >= x[i - 2]) return true;
            if (!b && x[i] <= x[i - 2]) {
                b = true;
                if (i < x.length - 1 && x[i + 1] >= x[i - 1]) return true;
                if (i < x.length - 1 && i > 3 && x[i] + x[i - 4] >= x[i - 2] && x[i + 1] + x[i - 3] >= x[i - 1])
                    return true;
                if (i < x.length - 1 && i >= 3 && x[i] == x[i - 2] && x[i + 1] + x[i - 3] >= x[i - 1]) return true;
                i++;
            }
        }
        return false;
    }

    /**
     * 1338
     * https://leetcode-cn.com/problems/reduce-array-size-to-the-half/
     */
    public int minSetSize(int[] arr) {
        Arrays.sort(arr);

        List<Integer> nums = new ArrayList<>();

        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                nums.add(count);
                count = 1;
            }
        }
        nums.add(count);

        Collections.sort(nums);
        int ans = 0;
        int size = 0;
        int i = nums.size() - 1;
        while (size < (arr.length / 2)) {
            ans++;
            size += nums.get(i);
            i--;
        }
        return ans;
    }

    /**
     * 679
     * https://leetcode-cn.com/problems/24-game/
     */
    public boolean judgePoint24(int[] nums) {
        double a = nums[0];
        double b = nums[1];
        double c = nums[2];
        double d = nums[3];
        return judge3(a + b, c, d) ||
                judge3(a - b, c, d) ||
                judge3(b - a, c, d) ||
                judge3(a * b, c, d) ||
                judge3(a / b, c, d) ||
                judge3(b / a, c, d) ||
                judge3(a + c, b, d) ||
                judge3(a - c, b, d) ||
                judge3(c - a, b, d) ||
                judge3(a * c, b, d) ||
                judge3(a / c, b, d) ||
                judge3(c / a, b, d) ||
                judge3(a + d, b, c) ||
                judge3(a - d, b, c) ||
                judge3(d - a, b, c) ||
                judge3(a * d, b, c) ||
                judge3(a / d, b, c) ||
                judge3(d / a, b, c) ||
                judge3(b + c, a, d) ||
                judge3(b - c, a, d) ||
                judge3(c - b, a, d) ||
                judge3(b * c, a, d) ||
                judge3(b / c, a, d) ||
                judge3(c / b, a, d) ||
                judge3(b + d, a, c) ||
                judge3(b - d, a, c) ||
                judge3(d - b, a, c) ||
                judge3(b * d, a, c) ||
                judge3(b / d, a, c) ||
                judge3(d / b, a, c) ||
                judge3(c + d, a, b) ||
                judge3(c - d, a, b) ||
                judge3(d - c, a, b) ||
                judge3(c * d, a, b) ||
                judge3(c / d, a, b) ||
                judge3(d / c, a, b);
    }

    boolean judge3(double a, double b, double c) {
        return judge(a + b, c) ||
                judge(a - b, c) ||
                judge(b - a, c) ||
                judge(a * b, c) ||
                judge(a / b, c) ||
                judge(b / a, c) ||
                judge(a + c, b) ||
                judge(a - c, b) ||
                judge(c - a, b) ||
                judge(a * c, b) ||
                judge(a / c, b) ||
                judge(c / a, b) ||
                judge(b + c, a) ||
                judge(b - c, a) ||
                judge(c - b, a) ||
                judge(b * c, a) ||
                judge(b / c, a) ||
                judge(c / b, a);
    }

    boolean judge(double a, double b) {
        return (Math.abs(a + b - 24) < 0.01) ||
                (Math.abs(a - b - 24) < 0.01) ||
                (Math.abs(b - a - 24) < 0.01) ||
                (Math.abs(a * b - 24) < 0.01) ||
                (Math.abs(a / b - 24) < 0.01) ||
                (Math.abs(b / a - 24) < 0.01);
    }

    /**
     * 面试题 08.03
     * https://leetcode-cn.com/problems/magic-index-lcci/
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i)
                return i;
            i = Math.max(i + 1, nums[i]);
        }
        return -1;
    }

    /**
     * 98
     * https://leetcode-cn.com/problems/validate-binary-search-tree/
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValid(TreeNode p, long min, long max) {
        if (p == null) {
            return true;
        }
        if ((p.val <= min) || (p.val >= max)) {
            return false;
        }
        return (isValid(p.left, min, p.val) && isValid(p.right, p.val, max));
    }


    /**
     * 61
     * https://leetcode-cn.com/problems/rotate-list/
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        p = head;
        ListNode pre = head;
        for (int i = 0; i < length - k; i++) {
            pre = p;
            p = p.next;
        }
        ListNode q = p;
        while (q.next != null) {
            q = q.next;
        }

        q.next = head;
        head = p;
        pre.next = null;

        return head;
    }

    /**
     * 81
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
     */
    public boolean search81(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (target >= nums[0]) {
            int i = 0;
            if (nums[i] == target) return true;
            i++;
            while ((i < nums.length) && (nums[i] >= nums[i - 1])) {
                if (nums[i] == target) {
                    return true;
                }
                if (nums[i] > target) {
                    return false;
                }
                i++;
            }
            return false;
        } else {
            int i = 1;
            while ((i < nums.length) && (nums[i] >= nums[i - 1])) {
                i++;
            }
            while (i < nums.length) {
                if (nums[i] == target) {
                    return true;
                }
                if (nums[i] > target) {
                    return false;
                }
                i++;
            }
            return false;
        }
    }

    /**
     * 1375
     * https://leetcode-cn.com/problems/bulb-switcher-iii/
     */
    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if (i + 1 == max) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 面试题 01.07
     * https://leetcode-cn.com/problems/rotate-matrix-lcci/
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] newMatrix = new int[length + 1][length + 1];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                newMatrix[j][length - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }

    /**
     * 397
     * https://leetcode-cn.com/problems/integer-replacement/
     */
    public int integerReplacement(int n) {
        long ln = n;
        int ans = 0;
        while (ln != 1) {
            if (((ln & 3) == 3) && (ln != 3)) {
                ln++;
            } else if ((ln & 1) == 1) {
                ln--;
            } else {
                ln = ln >> 1;
            }
            ans++;
        }
        return ans;
    }

    /**
     * 1475
     * https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/
     */
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            while ((j < prices.length) && (prices[j] > prices[i])) {
                j++;
            }
            if (j < prices.length) {
                ans[i] = prices[i] - prices[j];
            } else {
                ans[i] = prices[i];
            }
        }

        return ans;
    }

    /**
     * 1480
     * https://leetcode-cn.com/problems/running-sum-of-1d-array/
     */
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    /**
     * 258
     * https://leetcode-cn.com/problems/add-digits/
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 594
     * https://leetcode-cn.com/problems/longest-harmonious-subsequence/
     */
    public int findLHS(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = left;
        int ans = 0;
        while (right < nums.length) {
            right = left + 1;
            while ((right < nums.length) && (nums[right] == nums[left])) {
                right++;
            }
            if ((right < nums.length) && (nums[right] == nums[left] + 1)) {
                int newright = right;
                while ((newright < nums.length) && (nums[newright] == nums[left] + 1)) {
                    newright++;
                }
                ans = Math.max(ans, newright - left);
            }
            left = right;
        }

        return ans;
    }

    /**
     * 860
     * https://leetcode-cn.com/problems/lemonade-change/
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i : bills) {
            switch (i) {
                case 5:
                    five++;
                    break;
                case 10:
                    if (five > 0) {
                        five--;
                        ten++;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if ((ten > 0) && (five > 0)) {
                        five--;
                        ten--;
                    } else if (five > 2) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    /**
     * 414
     * https://leetcode-cn.com/problems/third-maximum-number/
     */
    public int thirdMax(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int num = 0;
        boolean flag = true;

        for (int i : nums) {
            if (i > a) {
                c = b;
                b = a;
                a = i;
                num++;
            }
            if ((i < a) && (i > b)) {
                c = b;
                b = i;
                num++;
            }
            ;
            if ((i < b) && (i > c)) {
                c = i;
                num++;
            }
            if ((i == Integer.MIN_VALUE) && (flag)) {
                num++;
                flag = false;
            }
        }

        if (num >= 3) {
            return c;
        } else {
            return a;
        }
    }

    /**
     * 693
     * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
     */
    public boolean hasAlternatingBits(int n) {
        int last = n % 2;

        while (n > 1) {
            n = n >> 1;
            if (last == (n % 2)) {
                return false;
            }
            last = n % 2;
        }
        return true;
    }

    /**
     * 632
     * https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/
     */
    class node632 {
        int key;
        int groupNumber;
        node632 next;

        node632() {
        }

        node632(int key, int gn) {
            this.key = key;
            this.groupNumber = gn;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        node632 head = new node632();
        head.next = null;
        node632 p = head;

        for (int i = 0; i < nums.size(); i++) {
            p = head;
            for (Integer num : nums.get(i)) {
                while ((p.next != null) && (p.next.key < num)) {
                    p = p.next;
                }
                node632 q = new node632(num, i);
                q.next = p.next;
                p.next = q;
                p = q;
            }
        }

        p = head.next;
        node632 q = head;
        int count = 0;
        int[] list = new int[nums.size()];
        int begin = p.key;
        int length = -1;

        while (q.next != null) {
            while ((count < nums.size()) && (q.next != null)) {
                q = q.next;
                list[q.groupNumber]++;
                if (list[q.groupNumber] == 1) {
                    count++;
                }
            }

            while (count == nums.size()) {
                if (((q.key - p.key) < length) || (length == -1)) {
                    length = q.key - p.key;
                    begin = p.key;
                }
                list[p.groupNumber]--;
                if (list[p.groupNumber] == 0) {
                    count--;
                }
                p = p.next;
            }
        }

        int[] ans = {begin, begin + length};
        return ans;
    }

    /**
     * 4
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        int a = 0;
        int b = 0;
        int length = 0;
        while ((a < nums1.length) || (b < nums2.length)) {
            if (a >= nums1.length) {
                nums[length++] = nums2[b++];
            } else if (b >= nums2.length) {
                nums[length++] = nums1[a++];
            } else {
                nums[length++] = (nums1[a] < nums2[b]) ? nums1[a++] : nums2[b++];
            }
        }
        return (length % 2 == 1) ? nums[(length - 1) / 2] : ((nums[length / 2] + nums[length / 2 - 1]) / 2.0);
    }

    /**
     * 88
     * https://leetcode-cn.com/problems/merge-sorted-array/
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];

        int a = 0;
        int b = 0;
        int length = 0;
        while ((a < m) || (b < n)) {
            if (a >= m) {
                nums[length++] = nums2[b++];
            } else if (b >= n) {
                nums[length++] = nums1[a++];
            } else {
                nums[length++] = (nums1[a] < nums2[b]) ? nums1[a++] : nums2[b++];
            }
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums[i];
        }
    }

    /**
     * 114
     * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode treeNode = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = treeNode;
    }

    /**
     * 70
     * https://leetcode-cn.com/problems/climbing-stairs/
     */
    public int climbStairs(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
    }

    /**
     * 207
     * https://leetcode-cn.com/problems/course-schedule/
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        Queue<Integer> safety = new LinkedList<>();
        for (int[] i : prerequisites) {
            counts[i[0]]++;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                safety.offer(i);
            }
        }

        while (safety.size() != 0) {
            int poll = safety.poll();
            for (int[] i : prerequisites) {
                if (i[1] == poll) {
                    counts[i[0]]--;
                    if (counts[i[0]] == 0) {
                        safety.offer(i[0]);
                    }
                }
            }
        }

        for (int c : counts) {
            if (c != 0) return false;
        }
        return true;
    }

    /**
     * 951
     * https://leetcode-cn.com/problems/flip-equivalent-binary-trees/
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if ((root1 == null) && (root2 == null)) {
            return true;
        }
        if ((root1 == null) || (root2 == null)) {
            return false;
        }
        if (root1.val == root2.val) {
            return (flipEquiv(root1.left, root2.left) && (flipEquiv(root1.right, root2.right))) || (flipEquiv(root1.left, root2.right) && (flipEquiv(root1.right, root2.left)));
        }
        return false;
    }

    /**
     * 744
     * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
     */
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int ans = 0;
        while (letters[ans] <= target) {
            ans++;
        }
        return letters[ans];
    }

    /**
     * 1526
     * https://leetcode-cn.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
     */
    public int minNumberOperations(int[] target) {
        int ans = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                ans += target[i] - target[i - 1];
            }
        }
        return ans;
    }

    /**
     * 228
     * https://leetcode-cn.com/problems/summary-ranges/
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while ((j + 1 < nums.length) && ((nums[j + 1] - nums[i]) == (j + 1 - i))) {
                j++;
            }
            if (j == i) {
                list.add(nums[i] + "");
            } else {
                list.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return list;
    }

    /**
     * 面试题 01.08
     * https://leetcode-cn.com/problems/zero-matrix-lcci/
     */
    public void setZeroes(int[][] matrix) {
        boolean[] m = new boolean[matrix.length];
        boolean[] n = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            m[i] = false;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            n[j] = false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    m[i] = true;
                    n[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (m[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (n[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 1
     * https://leetcode-cn.com/problems/two-sum/
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    /**
     * 415
     * https://leetcode-cn.com/problems/add-strings/
     */
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int target = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while ((target != 0) || (i >= 0) || (j >= 0)) {
            if (i >= 0) {
                target += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                target += num2.charAt(j--) - '0';
            }
            ans.append(target % 10);
            target /= 10;
        }
        return ans.reverse().toString();
    }

    /**
     * 1260
     * https://leetcode-cn.com/problems/shift-2d-grid/
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] nums = new int[m * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                k = k % (m * n);
                nums[k++] = grid[i][j];
            }
        }

        k = 0;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(nums[k++]);
            }
            ans.add(list);
        }
        return ans;
    }

    /**
     * 236
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if ((root == p) || (root == q)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

    /**
     * 925
     * https://leetcode-cn.com/problems/long-pressed-name/
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while ((i < name.length()) && (j < typed.length())) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if ((j > 0) && (typed.charAt(j) == typed.charAt(j - 1))) {
                j++;
            } else {
                return false;
            }
        }
        if (i == name.length()) {
            while (j < typed.length() - 1) {
                j++;
                if (typed.charAt(j) != typed.charAt(j - 1)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 1359
     * https://leetcode-cn.com/problems/count-all-valid-pickup-and-delivery-options/
     */
    public int countOrders(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = ans * i * (2 * i - 1);
            if (ans > 1000000007) {
                ans %= 1000000007;
            }
        }
        return (int) ans;
    }

    /**
     * 69
     * https://leetcode-cn.com/problems/sqrtx/
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int i = 1;
        while ((long) i * i <= x) {
            i++;
        }
        return i - 1;
    }

    /**
     * 227
     * https://leetcode-cn.com/problems/basic-calculator-ii/
     * <p>
     * 面试题 16.26
     * https://leetcode-cn.com/problems/calculator-lcci/
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char opt = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && (ch != ' ')) || (i == s.length() - 1)) {
                switch (opt) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                }
                opt = ch;
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.empty()) {
            ans += stack.pop();
        }
        return ans;
    }

    /**
     * 112
     * https://leetcode-cn.com/problems/path-sum/
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if ((root.right == null) && (root.left == null)) {
            return (sum == root.val);
        }

        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }

    /**
     * 838
     * https://leetcode-cn.com/problems/push-dominoes/
     */
    public String pushDominoes(String dominoes) {
        int[] left = new int[dominoes.length()];
        int[] right = new int[dominoes.length()];
        int force = 0;
        for (int i = 0; i < dominoes.length(); i++) {
            if (force != 0) {
                force++;
            }
            if (dominoes.charAt(i) == 'R') {
                force = 1;
            }
            if (dominoes.charAt(i) == 'L') {
                force = 0;
            }
            right[i] = force;
        }
        force = 0;
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            if (force != 0) {
                force++;
            }
            if (dominoes.charAt(i) == 'L') {
                force = 1;
            }
            if (dominoes.charAt(i) == 'R') {
                force = 0;
            }
            left[i] = force;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < dominoes.length(); i++) {
            if ((right[i] != 0) && (left[i] != 0)) {
                ans.append((right[i] < left[i]) ? 'R' : ((right[i] == left[i]) ? '.' : 'L'));
            }
            if ((right[i] != 0) && (left[i] == 0)) {
                ans.append('R');
            }
            if ((right[i] == 0) && (left[i] != 0)) {
                ans.append('L');
            }
            if ((right[i] == 0) && (left[i] == 0)) {
                ans.append('.');
            }
        }
        return ans.toString();
    }

    /**
     * 121
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     */
    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return ans;
    }

    /**
     * 122
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     */
    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    /**
     * 210
     * https://leetcode-cn.com/problems/course-schedule-ii/
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        Queue<Integer> safety = new LinkedList<>();
        Queue<Integer> record = new LinkedList<>();
        for (int[] i : prerequisites) {
            counts[i[0]]++;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                safety.offer(i);
            }
        }

        while (safety.size() != 0) {
            int poll = safety.poll();
            record.offer(poll);
            for (int[] i : prerequisites) {
                if (i[1] == poll) {
                    counts[i[0]]--;
                    if (counts[i[0]] == 0) {
                        safety.offer(i[0]);
                    }
                }
            }
        }

        if (record.size() == numCourses) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = record.poll();
            }
            return ans;
        } else {
            return new int[0];
        }
    }

    /**
     * 面试题 08.04
     * https://leetcode-cn.com/problems/power-set-lcci/
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        work0804(nums, 0, list, ans);
        return ans;
    }

    void work0804(int[] nums, int i, List<Integer> list, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
        }
        if (i < nums.length) {
            work0804(nums, i + 1, new ArrayList<>(list), ans);
            list.add(nums[i]);
            work0804(nums, i + 1, new ArrayList<>(list), ans);
        }
    }

    /**
     * 32
     * https://ldeetcode-cn.com/problems/longest-valid-parentheses/
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] mark = new int[s.length()];
        int len = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    mark[i] = 1;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.empty()) {
            mark[stack.pop()] = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (mark[i] == 1) {
                len = 0;
            } else {
                len++;
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    /**
     * 1262
     * https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/comments/
     */
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int i : nums) {
            int[] dp0 = new int[3];
            for (int j = 0; j < 3; j++) {
                dp0[j] = dp[j];
            }
            for (int j : dp0) {
                switch ((j + i) % 3) {
                    case 0:
                        dp[0] = Math.max(dp[0], i + j);
                        break;
                    case 1:
                        dp[1] = Math.max(dp[1], i + j);
                        break;
                    case 2:
                        dp[2] = Math.max(dp[2], i + j);
                        break;
                }
            }
        }
        return dp[0];
    }

    /**
     * 59
     * https://leetcode-cn.com/problems/spiral-matrix-ii/
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i < n * n; i++) {
            ans[x][y] = i;
            while (!((x + directions[dir][0] < n) && (x + directions[dir][0] >= 0) && (y + directions[dir][1] < n) && (y + directions[dir][1] >= 0) && (ans[x + directions[dir][0]][y + directions[dir][1]] == 0))) {
                dir = (dir + 1) % 4;
            }
            x += directions[dir][0];
            y += directions[dir][1];
        }
        ans[x][y] = n * n;
        return ans;
    }

    /**
     * 1496
     * https://leetcode-cn.com/problems/path-crossing/
     */
    public boolean isPathCrossing(String path) {
        if (path.contains("NS") || path.contains("SN") || path.contains("WE") || path.contains("EW")) {
            return true;
        }
        int n = 0;
        int s = 0;
        int w = 0;
        int e = 0;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    n++;
                    break;
                case 'S':
                    s++;
                    break;
                case 'W':
                    w++;
                    break;
                case 'E':
                    e++;
                    break;
            }
            if ((n == s) && (w == e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1025
     * https://leetcode-cn.com/problems/divisor-game/
     */
    public boolean divisorGame(int N) {
        return (N % 2 == 0);
    }

    /**
     * 7
     * https://leetcode-cn.com/problems/reverse-integer/
     */
    public int reverse(int x) {
        int max = 0x7fffffff, min = 0x80000000;
        long rs = 0;
        for (; x != 0; rs = rs * 10 + x % 10, x /= 10) ;
        return ((rs > max) || (rs < min)) ? 0 : (int) rs;
    }

    /**
     * 面试题 08.05
     * https://leetcode-cn.com/problems/recursive-mulitply-lcci/
     */
    public int multiply(int A, int B) {
        if (B == 0) {
            return 0;
        }
        return A + multiply(A, B - 1);
    }

    /**
     * 1460
     * https://leetcode-cn.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 179
     * https://leetcode-cn.com/problems/largest-number/
     */
    public String largestNumber(int[] nums) {
        if (nums.length < 1) {
            return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder ans = new StringBuilder();

        for (String s : str) {
            ans.append(s);
        }

        String result = ans.toString();

        if (result.charAt(0) == '0') {
            return "0";
        }

        return result;
    }

    /**
     * 337
     * https://leetcode-cn.com/problems/house-robber-iii/
     */
    public int rob(TreeNode root) {
        return Math.max(work337(root, false), work337(root, true));
    }

    int work337(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (flag) {
            return work337(root.left, false) + work337(root.right, false) + root.val;
        }
        return Math.max(work337(root.left, false), work337(root.left, true)) + Math.max(work337(root.right, false), work337(root.right, true));
    }

    /**
     * 213
     * https://leetcode-cn.com/problems/house-robber-ii/
     */
    public int rob2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }

        int[] memory = new int[length];

        memory[0] = 0;
        memory[1] = nums[1];

        for (int i = 2; i < length; i++) {
            memory[i] = Math.max(memory[i - 2] + nums[i], memory[i - 1]);
        }

        int ans = memory[length - 1];

        memory[length - 1] = 0;
        memory[length - 2] = nums[length - 2];

        for (int j = length - 3; j > -1; j--) {
            memory[j] = Math.max(memory[j + 2] + nums[j], memory[j + 1]);
        }

        return Math.max(ans, memory[0]);
    }

    /**
     * 96
     * https://leetcode-cn.com/problems/unique-binary-search-trees/
     */
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    /**
     * 1464
     * https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
     */
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    /**
     * 1470
     * https://leetcode-cn.com/problems/shuffle-the-array/
     */
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                ans[i] = nums[i / 2];
            } else {
                ans[i] = nums[n + i / 2];
            }
        }
        return ans;
    }

    /**
     * 867
     * https://leetcode-cn.com/problems/transpose-matrix/
     */
    public int[][] transpose(int[][] A) {
        int[][] ans = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                ans[j][i] = A[i][j];
        return ans;
    }

    /**
     * 27
     * https://leetcode-cn.com/problems/remove-element/
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }

    /**
     * 1161
     * https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/
     */
    public int maxLevelSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        work1161(root, 1, list);
        int ans = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(ans)) {
                ans = i;
            }
        }
        return ans + 1;
    }

    void work1161(TreeNode root, int n, List<Integer> list) {
        if (root != null) {
            if (list.size() < n) {
                int a = 0;
                list.add(a);
            }
            list.set(n - 1, list.get(n - 1) + root.val);
            work1161(root.left, n + 1, list);
            work1161(root.right, n + 1, list);
        }
    }

    /**
     * 1165
     * https://leetcode-cn.com/problems/single-row-keyboard/
     */
    public int calculateTime(String keyboard, String word) {
        int[] position = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            position[keyboard.charAt(i) - 'a'] = i;
        }
        int now = 0;
        int ans = 0;
        for (int i = 0; i < word.length(); i++) {
            ans += Math.abs(position[word.charAt(i) - 'a'] - now);
            now = position[word.charAt(i) - 'a'];
        }
        return ans;
    }

    /**
     * 1047
     * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
     */
    public String removeDuplicates(String S) {
        if (S.length() <= 1) {
            return S;
        }
        boolean[] flag = new boolean[S.length()];
        for (int i = 0; i < S.length(); i++) {
            flag[i] = true;
        }
        for (int i = 0; i < S.length() - 1; i++) {
            if (flag[i]) {
                int j = i + 1;
                while (j < S.length() && !flag[j]) {
                    j++;
                }
                if (j < S.length() && (S.charAt(i) == S.charAt(j))) {
                    flag[i] = false;
                    flag[j] = false;
                    i = -1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (flag[i]) {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 651
     * https://leetcode-cn.com/problems/4-keys-keyboard/
     */
    public int maxA(int N) {
        if (N <= 3) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[N];
    }

    /**
     * 289
     * https://leetcode-cn.com/problems/game-of-life/
     */
    public void gameOfLife(int[][] board) {
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int n = board.length;
        int m = board[0].length;
        int[][] partner = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    if ((i + directions[k][0] >= 0) && (i + directions[k][0] < n) && (j + directions[k][1] >= 0) && (j + directions[k][1] < m)) {
                        partner[i][j] += board[i + directions[k][0]][j + directions[k][1]];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    if (partner[i][j] == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    if ((partner[i][j] < 2) || (partner[i][j] > 3)) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    /**
     * 696
     * https://leetcode-cn.com/problems/count-binary-substrings/
     */
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int[] num = {0, 0};
        num[s.charAt(0) - '0']++;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                num[s.charAt(i) - '0']++;
            } else {
                ans += Math.min(num[0], num[1]);
                num[s.charAt(i) - '0'] = 1;
            }
            if (i == s.length() - 1) {
                ans += Math.min(num[0], num[1]);
            }
        }
        return ans;
    }

    /**
     * offer 34
     * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
     */
    List<List<Integer>> ans34 = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            work34(root, list, sum, 0);
        }
        return ans34;
    }

    void work34(TreeNode root, List<Integer> list, int sum, int i) {
        if ((root.right == null) && (root.left == null) && (root.val == sum)) {
            list.add(root.val);
            ans34.add(new ArrayList<>(list));
            list.remove(i);
        } else {
            list.add(root.val);
            if (root.left != null) {
                work34(root.left, list, sum - root.val, i + 1);
            }
            if (root.right != null) {
                work34(root.right, list, sum - root.val, i + 1);
            }
            list.remove(i);
        }
    }

    /**
     * 1545
     * https://leetcode-cn.com/problems/find-kth-bit-in-nth-binary-string/
     */
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int mid = (1 << (n - 1));
        if (k == mid) {
            return '1';
        }
        if (k < mid) {
            return findKthBit(n - 1, k);
        }
        return findKthBit(n - 1, mid * 2 - k) == '0' ? '1' : '0';
    }

    /**
     * 130
     * https://leetcode-cn.com/problems/surrounded-regions/
     */
    public void solve(char[][] board) {
        int n = board.length;
        if (n <= 2) {
            return;
        }
        int m = board[0].length;
        if (m <= 2) {
            return;
        }

        int[][] dest = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int[][] target = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                int[] node = {i, 0};
                target[i][0] = 1;
                queue.add(node);
            }
            if (board[i][m - 1] == 'O') {
                int[] node = {i, m - 1};
                target[i][m - 1] = 1;
                queue.add(node);
            }
        }
        for (int j = 1; j < m - 1; j++) {
            if (board[0][j] == 'O') {
                int[] node = {0, j};
                target[0][j] = 1;
                queue.add(node);
            }
            if (board[n - 1][j] == 'O') {
                int[] node = {n - 1, j};
                target[n - 1][j] = 1;
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            int[] node1 = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node1[0] + dest[i][0];
                int y = node1[1] + dest[i][1];
                if ((x > -1) && (x < n) && (y > -1) && (y < m)) {
                    if ((board[x][y] == 'O') && (target[x][y] != 1)) {
                        int[] node = {x, y};
                        target[x][y] = 1;
                        queue.add(node);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((board[i][j] == 'O') && (target[i][j] != 1)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 面试题 01.01
     * https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum/
     */
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            if (astr.lastIndexOf(astr.charAt(i)) != i) {
                return false;
            }
        }
        return true;
    }

    /**
     * 624
     * https://leetcode-cn.com/problems/maximum-distance-in-arrays/
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int min = 10001;
        int max = -10001;
        int ans = 0;
        for (List<Integer> list : arrays) {
            if (min == 10001) {
                min = list.get(0);
                max = list.get(list.size() - 1);
            } else {
                ans = Math.max(ans, max - list.get(0));
                ans = Math.max(ans, list.get(list.size() - 1) - min);
                max = Math.max(max, list.get(list.size() - 1));
                min = Math.min(min, list.get(0));
            }
        }
        return ans;
    }

    /**
     * 455
     * https://leetcode-cn.com/problems/assign-cookies/
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        while ((gi < g.length) && (si < s.length)) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    /**
     * 845
     * https://leetcode-cn.com/problems/longest-mountain-in-array/
     */
    public int longestMountain(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if ((A[i - 1] < A[i]) && (A[i + 1] < A[i])) {
                int l = i - 1;
                int r = i + 1;
                while ((l > 0) && (A[l - 1] < A[l])) {
                    l--;
                }
                while ((r < A.length - 1) && (A[r + 1] < A[r])) {
                    r++;
                }
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }

    /**
     * 747
     * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
     */
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int max;
        int maxp;
        if (nums[0] > nums[1]) {
            max = 0;
            maxp = 1;
        } else {
            maxp = 0;
            max = 1;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                maxp = max;
                max = i;
            } else if (nums[i] > nums[maxp]) {
                maxp = i;
            }
        }
        return (nums[max] >= (nums[maxp] * 2)) ? max : -1;
    }

    /**
     * 1119
     * https://leetcode-cn.com/problems/remove-vowels-from-a-string/
     */
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if ((S.charAt(i) != 'a') && (S.charAt(i) != 'e') && (S.charAt(i) != 'o') && (S.charAt(i) != 'i') && (S.charAt(i) != 'u')) {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 面试题 17.09
     * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
     */
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int num3 = 0;
        int num5 = 0;
        int num7 = 0;

        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(dp[num3] * 3, dp[num5] * 5);
            dp[i] = Math.min(dp[i], dp[num7] * 7);
            if (dp[i] % 3 == 0) {
                num3++;
            }
            if (dp[i] % 5 == 0) {
                num5++;
            }
            if (dp[i] % 7 == 0) {
                num7++;
            }
        }
        return dp[k - 1];
    }

    /**
     * 242
     * https://leetcode-cn.com/problems/valid-anagram/
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 899
     * https://leetcode-cn.com/problems/orderly-queue/
     */
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            return sb.toString();
        }
        String ss = S + S;
        String ans = S;
        for (int i = 0; i < S.length(); i++) {
            if (ans.compareTo(ss.substring(i, i + S.length())) > 0) {
                ans = ss.substring(i, i + S.length());
            }
        }
        return ans;
    }

    /**
     * 1544
     * https://leetcode-cn.com/problems/make-the-string-great/
     */
    public String makeGood(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[] flag = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            flag[i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (flag[i]) {
                int j = i + 1;
                while (j < s.length() && !flag[j]) {
                    j++;
                }
                if (j < s.length() && (Math.abs(s.charAt(i) - s.charAt(j)) == 'a' - 'A')) {
                    flag[i] = false;
                    flag[j] = false;
                    i = -1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (flag[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 1402
     * https://leetcode-cn.com/problems/reducing-dishes/
     */
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0;
        int sum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum > 0) {
                ans += sum;
            }
        }
        return ans;
    }

    /**
     * 1085
     * https://leetcode-cn.com/problems/sum-of-digits-in-the-minimum-number/
     */
    public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            min = Math.min(min, A[i]);
        }
        int ans = 0;
        while (min > 0) {
            ans += min % 10;
            min /= 10;
        }
        return (ans % 2 == 1) ? 0 : 1;
    }

    /**
     * 1394
     * https://leetcode-cn.com/problems/find-lucky-integer-in-an-array/
     */
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int i : arr) {
            count[i]++;
        }
        int ans = -1;
        for (int i = 1; i < 501; i++) {
            if (count[i] == i) {
                ans = i;
            }
        }
        return ans;
    }

    /**
     * 518
     * https://leetcode-cn.com/problems/coin-change-2/
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < amount + 1; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

    /**
     * 面试题 05.03
     * https://leetcode-cn.com/problems/reverse-bits-lcci/
     */
    public int reverseBits(int num) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                count++;
            } else {
                list.add(count);
                count = 0;
            }
            num /= 2;
        }
        list.add(count);
        if (list.size() == 1) {
            return list.get(0) + 1;
        }
        int ans = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            ans = Math.max(ans, list.get(i) + list.get(i + 1));
        }
        return ans + 1;
    }

    /**
     * 754
     * https://leetcode-cn.com/problems/reach-a-number/
     */
    public int reachNumber(int target) {
        int t = Math.abs(target);
        int time = 0;
        int dis = 0;
        while (dis < t) {
            time++;
            dis += time;

        }
        int dt = dis - t;
        if (dt % 2 == 0)
            return time;
        else {
            if (time % 2 == 0)
                return time + 1;
            else
                return time + 2;
        }
    }

    /**
     * 1004
     * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
     */
    public int longestOnes(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int num : A) {
            if (num == 1) {
                count++;
            } else {
                list.add(count);
                count = 0;
            }
        }
        list.add(count);
        if (list.size() <= K) {
            return A.length;
        }
        int ans = 0;
        for (int i = 0; i < K + 1; i++) {
            ans += list.get(i);
        }
        int sum = ans;
        for (int i = 1; i < list.size() - K; i++) {
            sum = sum - list.get(i - 1) + list.get(i + K);
            ans = Math.max(ans, sum);
        }
        return ans + K;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 133
     * https://leetcode-cn.com/problems/clone-graph/
     */
    HashMap<Node, Node> visited = new HashMap();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node copy = new Node(node.val, new ArrayList<Node>());
        visited.put(node, copy);
        for (Node next : node.neighbors) {
            copy.neighbors.add(dfs(next));
        }
        return copy;
    }

    /**
     * 453
     * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
     */
    public int minMoves(int[] nums) {
        int sum = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(nums[i], min);
        }
        return sum - min * nums.length;
    }

    /**
     * 462
     * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int target = (nums.length % 2 == 0) ? nums.length / 2 : (nums.length - 1) / 2;
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - nums[target]);
        }
        return ans;
    }

    /**
     * 296
     * https://leetcode-cn.com/problems/best-meeting-point/
     */
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        int ans = 0;
        int targetx = x.get(x.size() / 2);
        int targety = y.get(y.size() / 2);
        for (int i = 0; i < x.size(); i++) {
            ans += Math.abs(x.get(i) - targetx) + Math.abs(y.get(i) - targety);
        }
        return ans;
    }

    /**
     * 442
     * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
     */
    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % nums.length] += nums.length;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 2 * nums.length) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    /**
     * 1427
     * https://leetcode-cn.com/problems/perform-string-shifts/
     */
    public String stringShift(String s, int[][] shift) {
        int length = s.length();
        int move = 0;
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                move += shift[i][1];
            } else {
                move -= shift[i][1];
            }
        }

        move %= length;
        move = (move < 0) ? move + length : move;

        s = s + s;
        return s.substring(move, move + length);
    }

    /**
     * 313
     * https://leetcode-cn.com/problems/super-ugly-number/
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] nums = new int[primes.length];

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[nums[j]] * primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] % primes[j] == 0) {
                    nums[j]++;
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 263
     * https://leetcode-cn.com/problems/ugly-number/
     */
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num < 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    /**
     * 404
     * https://leetcode-cn.com/problems/sum-of-left-leaves/
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + ans;
    }

    /**
     * 1103
     * https://leetcode-cn.com/problems/distribute-candies-to-people/
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int n = 0;
        while (candies > 0) {
            n++;
            ans[(n - 1) % num_people] += Math.min(candies, n);
            candies -= n;
        }
        return ans;
    }

    /**
     * 168
     * https://leetcode-cn.com/problems/excel-sheet-column-title/
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    /**
     * 171
     * https://leetcode-cn.com/problems/excel-sheet-column-number/
     */
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans *= 26;
            ans += s.charAt(i) - 'A' + 1;
        }
        return ans;
    }

    /**
     * 718
     * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
     */
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    if ((i != 0) && (j != 0)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    /**
     * 413
     * https://leetcode-cn.com/problems/arithmetic-slices/
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if ((2 * A[i - 1]) == (A[i] + A[i - 2])) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += dp[i];
        }
        return ans;
    }

    /**
     * 63
     * https://leetcode-cn.com/problems/unique-paths-ii/
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            dp[j] = (obstacleGrid[0][j] == 1) ? 0 : dp[j - 1];
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            dp[0] = (obstacleGrid[i][0] == 1) ? 0 : dp[0];
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[j] = (obstacleGrid[i][j] == 1) ? 0 : dp[j - 1] + dp[j];
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }

    /**
     * 43
     * https://leetcode-cn.com/problems/multiply-strings/
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] multi = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                multi[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = n + m - 1; i > 0; i--) {
            if (multi[i] >= 10) {
                multi[i - 1] += multi[i] / 10;
                multi[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (multi[i] == 0) {
            i++;
        }
        while (i < n + m) {
            sb.append(multi[i]);
            i++;
        }
        return sb.toString();
    }

    /**
     * 23
     * https://leetcode-cn.com/problems/merge-k-sorted-lists/
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    /**
     * 222
     * https://leetcode-cn.com/problems/count-complete-tree-nodes/
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * 361
     * https://leetcode-cn.com/problems/bomb-enemy/
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] es = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'E') {
                    int ii = i - 1;
                    while ((ii >= 0) && (grid[ii][j] != 'W')) {
                        if (grid[ii][j] == '0') {
                            es[ii][j]++;
                        }
                        ii--;
                    }
                    ii = i + 1;
                    while ((ii < n) && (grid[ii][j] != 'W')) {
                        if (grid[ii][j] == '0') {
                            es[ii][j]++;
                        }
                        ii++;
                    }
                    int jj = j - 1;
                    while ((jj >= 0) && (grid[i][jj] != 'W')) {
                        if (grid[i][jj] == '0') {
                            es[i][jj]++;
                        }
                        jj--;
                    }
                    jj = j + 1;
                    while ((jj < m) && (grid[i][jj] != 'W')) {
                        if (grid[i][jj] == '0') {
                            es[i][jj]++;
                        }
                        jj++;
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, es[i][j]);
            }
        }
        return ans;
    }

    /**
     * 781
     * https://leetcode-cn.com/problems/rabbits-in-forest/
     */
    public int numRabbits(int[] answers) {
        if (answers.length == 0) {
            return 0;
        }
        if (answers.length == 1) {
            return answers[0] + 1;
        }
        int ans = 0;
        Arrays.sort(answers);
        int i = 0;
        while (i < answers.length) {
            int count = 1;
            while ((i + 1 < answers.length) && (answers[i + 1] == answers[i])) {
                i++;
                count++;
            }
            while (count % (answers[i] + 1) != 0) {
                count++;
            }
            ans += count;
            i++;
        }
        return ans;
    }

    /**
     * 1066
     * https://leetcode-cn.com/problems/campus-bikes-ii/
     */
    int min1066;

    public int assignBikes(int[][] workers, int[][] bikes) {
        min1066 = Integer.MAX_VALUE;
        int n = workers.length;
        int m = bikes.length;
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
            }
        }
        work1066(distance, new boolean[m], 0, 0);
        return min1066;
    }

    void work1066(int[][] distance, boolean[] flags, int n, int sum) {
        if (sum > min1066) {
            return;
        }
        if (n >= distance.length) {
            min1066 = sum;
        } else {
            for (int i = 0; i < flags.length; i++) {
                if (!flags[i]) {
                    flags[i] = true;
                    work1066(distance, flags, n + 1, sum + distance[n][i]);
                    flags[i] = false;
                }
            }
        }
    }

    /**
     * 20
     * https://leetcode-cn.com/problems/valid-parentheses/
     */
    public boolean isValid20(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((c == '(') || (c == '[') || (c == '{')) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (c) {
                    case ')':
                        if (stack.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.pop() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.pop() != '{') {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 1003
     * https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/
     */
    public boolean isValid1003(String S) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            if (S.charAt(i) == 'a') {
                if (i >= S.length() - 2) {
                    return false;
                }
                if (S.charAt(i + 1) != 'b') {
                    stack.push(1);
                    i++;
                } else if (S.charAt(i + 2) != 'c') {
                    stack.push(2);
                    i += 2;
                } else {
                    i += 3;
                }
            } else if (S.charAt(i) == 'b') {
                if (i >= S.length() - 1) {
                    return false;
                }
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != 1) {
                    return false;
                }
                if (S.charAt(i + 1) != 'c') {
                    stack.push(2);
                    i++;
                } else {
                    i += 2;
                }
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != 2) {
                    return false;
                }
                i++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 461
     * https://leetcode-cn.com/problems/hamming-distance/
     */
    public int hammingDistance(int x, int y) {
        int ans = 0;
        while ((x != 0) || (y != 0)) {
            if ((x % 2) != (y % 2)) {
                ans++;
            }
            x /= 2;
            y /= 2;
        }
        return ans;
    }

    /**
     * 275
     * https://leetcode-cn.com/problems/h-index-ii/
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0;
        int end = len - 1;
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) >> 1;
            int paperCnt = len - mid;
            if (paperCnt <= citations[mid]) {
                ans = paperCnt;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;
    }

    /**
     * 21
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    /**
     * 1342
     * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
     */
    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0) {
            ans++;
            if ((num % 2 != 0) && (num != 1)) {
                ans++;
            }
            num /= 2;
        }
        return ans;
    }

    /**
     * 477
     * https://leetcode-cn.com/problems/total-hamming-distance/
     */
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int[] count = new int[2];
            for (int j = 0; j < nums.length; j++) {
                count[nums[j] % 2]++;
                nums[j] /= 2;
            }
            ans += count[0] * count[1];
        }
        return ans;
    }

    /**
     * 1344
     * https://leetcode-cn.com/problems/angle-between-hands-of-a-clock/
     */
    public double angleClock(int hour, int minutes) {
        double c = Math.abs(minutes * 6 - (hour % 12 * 30 + minutes / 2.0));
        return Math.min(c, 360 - c);
    }

    /**
     * 1079
     * https://leetcode-cn.com/problems/letter-tile-possibilities/
     */
    int ans1079;

    public int numTilePossibilities(String tiles) {
        int[] chars = new int[26];
        ans1079 = 0;
        for (int i = 0; i < tiles.length(); i++) {
            chars[tiles.charAt(i) - 'A']++;
        }
        work1079(chars);
        return ans1079;
    }

    void work1079(int[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                ans1079++;
                chars[i]--;
                work1079(chars);
                chars[i]++;
            }
        }
    }

    /**
     * 82
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     */
    public ListNode deleteDuplicates82(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode next = head.next;
        if (head.val == next.val) {
            while ((next != null) && (next.val == head.val)) {
                next = next.next;
            }
            head = deleteDuplicates82(next);
        } else {
            head.next = deleteDuplicates82(next);
        }
        return head;
    }

    /**
     * 83
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     */
    public ListNode deleteDuplicates(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) head = head.next;
        return head;
    }

    /**
     * 1063
     * https://leetcode-cn.com/problems/number-of-valid-subarrays/
     */
    public int validSubarrays(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 945
     * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
     */
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                ans += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return ans;
    }

    /**
     * 面试题 02.04
     * https://leetcode-cn.com/problems/partition-list-lcci/
     */
    public ListNode partition(ListNode head, int x) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode small = new ListNode();
        ListNode big = new ListNode();
        ListNode p = head;
        ListNode sp = small;
        ListNode bp = big;
        while (p != null) {
            if (p.val < x) {
                sp.next = p;
                sp = sp.next;
            } else {
                bp.next = p;
                bp = bp.next;
            }
            p = p.next;
        }
        sp.next = big.next;
        bp.next = null;
        return small.next;
    }

    /**
     * 935
     * https://leetcode-cn.com/problems/knight-dialer/
     */
    public int knightDialer(int N) {
        if (N == 1) {
            return 10;
        }
        int[] record = new int[10];
        int[] cache = new int[10];
        for (int i = 0; i < 10; i++) {
            record[i] = 1;
        }
        for (int k = 1; k < N; k++) {
            cache[0] = record[4] + record[6];
            cache[1] = record[8] + record[6];
            cache[2] = record[7] + record[9];
            cache[3] = record[4] + record[8];
            cache[4] = (record[3] + record[9]) % 1000000007 + record[0];
            cache[5] = 0;
            cache[6] = (record[1] + record[7]) % 1000000007 + record[0];
            cache[7] = record[2] + record[6];
            cache[8] = record[1] + record[3];
            cache[9] = record[4] + record[2];
            for (int i = 0; i < 10; i++) {
                record[i] = cache[i] % 1000000007;
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + record[i]) % 1000000007;
        }
        return ans;
    }

    /**
     * 1363
     * https://leetcode-cn.com/problems/largest-multiple-of-three/
     */
    public String largestMultipleOfThree(int[] digits) {
        if (digits.length == 0) return "";
        Arrays.sort(digits);
        if (digits[digits.length - 1] == 0) {
            return "0";
        }
        int sum = 0;
        boolean[] flag = new boolean[digits.length];
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
            flag[i] = true;
        }
        if (sum % 3 == 1) {
            int i = 0;
            while ((sum % 3 != 0) && (i < digits.length)) {
                if (digits[i] % 3 == 1) {
                    sum -= digits[i];
                    flag[i] = false;
                }
                i++;
            }
            i = 0;
            while ((sum % 3 != 0) && (i < digits.length)) {
                if (digits[i] % 3 == 2) {
                    sum -= digits[i];
                    flag[i] = false;
                }
                i++;
            }
        }
        if (sum % 3 == 2) {
            int i = 0;
            while ((sum % 3 != 0) && (i < digits.length)) {
                if (digits[i] % 3 == 2) {
                    sum -= digits[i];
                    flag[i] = false;
                }
                i++;
            }
            i = 0;
            while ((sum % 3 != 0) && (i < digits.length)) {
                if (digits[i] % 3 == 1) {
                    sum -= digits[i];
                    flag[i] = false;
                }
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (flag[i]) {
                sb.append(digits[i]);
            }
        }
        return sb.toString();
    }
}
