package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 거리두기_확인하기 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean isDisable = false;

    static class Coordinate {
        int x;
        int y;
        int distance;

        public Coordinate(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            isDisable = false;
            List<Coordinate> players = new LinkedList<>();

            // Char[][] 을 통해 map을 만들어준다.
            char[][] map = new char[5][5];
            for (int j = 0; j < places[i].length; j++) {
                String place = places[i][j];
                for (int k = 0; k < place.length(); k++) {
                    map[j][k] = place.charAt(k);
                    // Player 목록 List에 add
                    if (map[j][k] == 'P') {
                        players.add(new Coordinate(j, k, 0));
                    }
                }
            }
            for (Coordinate coordinate : players) {
                if (bfs(map, coordinate)) {
                } else {
                    isDisable = true;
                }
                // 거리두기 실패
                if (isDisable) {
                    answer[i] = 0;
                    break;
                }
            }
            // 거리두기 성공
            if (!isDisable) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    private boolean bfs(char[][] map, Coordinate coordinate) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[5][5];
        queue.add(coordinate);

        while (!queue.isEmpty()) {
            Coordinate info = queue.poll();
            int x = info.x;
            int y = info.y;
            int distance = info.distance;
            isVisited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 좌표 밖이면 Continue
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                // 이미 방문했거나, X인 경우 Continue
                if (isVisited[nx][ny] || map[nx][ny] == 'X') continue;

                // Player를 발견했을 때 distance가 2이하인 경우, 거리두기 실패
                if (map[nx][ny] == 'P') {
                    if (distance + 1 <= 2) {
                        isDisable = true;
                        break;
                    }
                } else {
                    // distance가 2를 넘어가는 경우에는 이미 Player가 서로 거리두기를 하고 있음
                    if (distance + 1 < 2) {
                        queue.add(new Coordinate(nx, ny, distance + 1));
                    }
                }
            }

            if (isDisable) {
                return false;
            }
        }

        return true;
    }

    @Test
    void init1() {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = {1, 0, 1, 1, 1};

        Assertions.assertArrayEquals(solution(places), answer);
    }

}
