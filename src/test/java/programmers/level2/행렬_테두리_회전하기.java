package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 행렬_테두리_회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = initMap(rows, columns);

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(map, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }

        return answer;
    }

    private int rotate(int[][] map, int x1, int y1, int x2, int y2) {
        int temp = map[x1][y1];
        int min = temp;

        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i][y1]);
        }
        for (int i = y1; i < y2; i++) {
            map[x2][i] = map[x2][i + 1];
            min = Math.min(min, map[x2][i]);
        }
        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);
        }
        for (int i = y2; i > y1; i--) {
            map[x1][i] = map[x1][i - 1];
            min = Math.min(min, map[x1][i]);
        }
        map[x1][y1 + 1] = temp;

        return min;
    }

    private int[][] initMap(int rows, int columns) {
        int[][] map = new int[rows + 1][columns + 1];
        int count = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = count++;
            }
        }

        return map;
    }

    @Test
    void init1() {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] result = solution(rows, columns, queries);
        int[] answer = {8, 10, 25};

        Assertions.assertArrayEquals(result, answer);
    }
}
