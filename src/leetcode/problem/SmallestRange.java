package leetcode.problem;

import java.util.List;

public class SmallestRange {
    /**
     * 632. 最小区间
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
}
