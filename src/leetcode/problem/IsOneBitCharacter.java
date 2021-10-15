package leetcode.problem;

/**
 * 717. 1比特与2比特字符
 * https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 */
public class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length - 2;
        int count = 0;
        while ((n >= 0) && (bits[n] == 1)) {
            n--;
            count++;
        }
        return (count % 2 == 0);
    }
}
