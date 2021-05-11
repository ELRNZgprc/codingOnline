package leetcode.problem;

/**
 * 1734. 解码异或后的排列
 * https://leetcode-cn.com/problems/decode-xored-permutation/
 */
public class Decode {
    public int[] decode(int[] encoded) {
        int x = 0;
        for (int i = 1; i <= encoded.length + 1; i++) {
            x ^= i;
        }
        int y = 0;
        for (int i = 0; i < encoded.length; i++) {
            if ((i % 2) == 1) {
                y ^= encoded[i];
            }
        }
        int a = x ^ y;

        int[] result = new int[encoded.length + 1];
        result[0] = a;

        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = encoded[i] ^ result[i];
        }
        return result;
    }
}
