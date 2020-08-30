package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /**
     * 412. Fizz Buzz
     * https://leetcode-cn.com/problems/fizz-buzz/
     */
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
