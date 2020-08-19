package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isSelfDividingNumber(int i) {
        if (i == 0) {
            return false;
        }
        int n = i;
        while (n != 0) {
            if ((n % 10 == 0) || (i % (n % 10) != 0)) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
