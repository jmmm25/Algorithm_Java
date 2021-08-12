package programmers.level2;

public class 타겟넘버 {
    static int answer;

    private void dfs(int[] numbers, int target, int idx, int sum) {
        if (numbers.length == idx) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        sum += numbers[idx];
        dfs(numbers, target, idx + 1, sum);

        sum -= numbers[idx];
        sum += (-1) * numbers[idx];
        dfs(numbers, target, idx + 1, sum);

    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);

        return answer;
    }

}
