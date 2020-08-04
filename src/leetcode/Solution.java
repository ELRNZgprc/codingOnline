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
     * mianshiti 08.11
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
     * mianshiti 01.09
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
     * mianshiti 08.03
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
     * mianshiti 01.07
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
     * mianshiti 01.08
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
     * mianshiti 16.26
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
     * mianshiti 08.04
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
     * mianshiti 08.05
     * https://leetcode-cn.com/problems/recursive-mulitply-lcci/
     */
    public int multiply(int A, int B) {
        if (B == 0) {
            return 0;
        }
        return A+multiply(A,B-1);
    }

    /**
     * 1460
     * https://leetcode-cn.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length!=arr.length){
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0 ;i<target.length;i++){
            if (target[i]!=arr[i]){
                return false;
            }
        }
        return true;
    }
}

