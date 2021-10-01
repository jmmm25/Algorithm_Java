package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브_15685 {
    static int N;
    static int[] dy = {0, -1, 0, 1}; // 우, 상, 좌, 하
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());

        boolean[][] isVisited = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            int g = Integer.parseInt(stringTokenizer.nextToken());

            dragonCurve(isVisited, x, y, d, g);
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (isVisited[i][j] && isVisited[i][j + 1] && isVisited[i + 1][j + 1] && isVisited[i + 1][j]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void dragonCurve(boolean[][] isVisited, int x, int y, int d, int g) {
        isVisited[y][x] = true;
        List<Integer> list = new ArrayList<>();
        list.add(d);
        for (int i = 1; i <= g; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            x += dx[list.get(i)];
            y += dy[list.get(i)];
            isVisited[y][x] = true;
        }
    }

}
