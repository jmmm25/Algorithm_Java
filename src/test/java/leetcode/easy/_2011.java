package leetcode.easy;

public class _2011 {
    public int finalValueAfterOperations(String[] operations) {
        int answer = 0;
        for (String operation : operations) {
            if (operation.startsWith("--") || operation.endsWith("--")) {
                answer--;
            } else {
                answer++;
            }
        }

        return answer;
    }
}
