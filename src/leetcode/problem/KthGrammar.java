package leetcode.problem;

public class KthGrammar {
    /**
     * 779. 第K个语法符号
     * https://leetcode-cn.com/problems/k-th-symbol-in-grammar/
     */
    public int kthGrammar(int N, int K) {
        if (N == 1 && K == 1)
            return 0;
        int a = kthGrammar(N - 1, (K + 1) / 2);
        int b = 1 - a;
        if (K % 2 == 1)
            return a;
        else
            return b;
    }
}
