package leetcode.problem;

/**
 * 990. 等式方程的可满足性
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 */
public class EquationsPossible {
    public boolean equationsPossible(String[] equations) {
        int[] a = new int[26];
        for (int i = 0; i < 26; i++) {
            a[i] = i;
        }

        for (String e : equations) {
            if (e.charAt(1) == '=') {
                union(a, e.charAt(0), e.charAt(3));
            }
        }

        for (String e : equations) {
            if (e.charAt(1) == '!') {
                if (find(a, e.charAt(0) - 'a') == find(a, e.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    void union(int[] a, char x, char y) {
        int a1 = x - 'a';
        int b1 = y - 'a';
        a[find(a, b1)] = find(a, a1);
    }

    int find(int[] a, int x) {
        if (a[x] == x) {
            return x;
        }
        return find(a, a[x]);
    }
}
