package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class NumOfBurgers {
	/**
	 * 1276. 不浪费原料的汉堡制作方案
	 * https://leetcode-cn.com/problems/number-of-burgers-with-no-waste-of-ingredients/
	 */
	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		List<Integer> result = new ArrayList<>();
        if (tomatoSlices<2*cheeseSlices || tomatoSlices>4*cheeseSlices || tomatoSlices%2!=0) {
            return result;
        }
        int num = (tomatoSlices-(cheeseSlices<<1))>>1;
        result.add(num);
        result.add(cheeseSlices-num);
        return result;
    }
}
