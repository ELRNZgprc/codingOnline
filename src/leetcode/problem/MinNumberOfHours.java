package leetcode.problem;

/**
 * 2383. 赢得比赛需要的最少训练时长
 * https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/
 */
public class MinNumberOfHours {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        for (int i = 0; i < energy.length; i++) {
            if (energy[i] >= initialEnergy) {
                ans += energy[i] - initialEnergy + 1;
                initialEnergy = energy[i] + 1;
            }
            if (experience[i] >= initialExperience) {
                ans += experience[i] - initialExperience + 1;
                initialExperience = experience[i] + 1;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return ans;
    }
}
