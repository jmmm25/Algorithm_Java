package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answers = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            int day = (100 - progress) / speed;
            if ((100 - progress) % speed > 0) {
                day++;
            }
            queue.add(day);
        }
        while (!queue.isEmpty()) {
            int cnt = 0;
            int day = queue.poll();
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (day >= queue.peek()) {
                    cnt++;
                    queue.poll();
                } else {
                    break;
                }
            }
            answers.add(cnt);
        }
        int[] answer = new int[answers.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answers.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        기능개발 s = new 기능개발();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = s.solution(progresses, speeds);

    }
}
