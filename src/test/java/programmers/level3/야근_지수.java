package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근_지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
        Arrays.stream(works).forEach(work -> priorityQueue.add(work));
        for (int i = 0; i < n; i++) {
            int value = priorityQueue.poll();
            if (value == 0) {
                break;
            }
            priorityQueue.add(--value);
        }

        while (!priorityQueue.isEmpty()) {
            int value = priorityQueue.poll();
            answer += Math.pow(value, 2);
        }

        return answer;
    }

    @Test
    void init() {
        int n = 4;
        int[] works = {4, 3, 3};
        Assertions.assertEquals(12, solution(n, works));
    }

    @Test
    void init2() {
        int n = 3;
        int[] works = {1, 1};
        Assertions.assertEquals(0, solution(n, works));
    }

}
