package leetcode.easy;

public class _771 {
    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (stones.charAt(j) == jewels.charAt(i)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
