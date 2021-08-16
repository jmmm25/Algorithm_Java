package programmers.level2;

import javafx.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북 {
    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] isVisited = new boolean[101][101];

    private int bfs(int i, int j, int m, int n, int[][] picture, int size) {
        isVisited[i][j] = true;
        queue.add(new Pair<>(i, j));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            size++;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || picture[x][y] != picture[nx][ny] || isVisited[nx][ny]) {
                    continue;
                }
                queue.add(new Pair<>(nx, ny));
                isVisited[nx][ny] = true;
            }
        }

        return size;
    }


    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                int size = 0;
                if (picture[i][j] == 0 || isVisited[i][j] == true) {
                    continue;
                }
                size = bfs(i, j, m, n, picture, size);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                numberOfArea++;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    @Test
    void init1() {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] answer = {4, 5};

        int[] result = solution(m, n, picture);
        Assertions.assertArrayEquals(result, answer);
    }

    @Test
    void init2() {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int[] answer = {2, 6};

        int[] result = solution(m, n, picture);
        Assertions.assertArrayEquals(result, answer);
    }
}
