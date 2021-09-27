package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구_이동_16234 {
    static int N;
    static int L;
    static int R;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        L = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int result = 0;
        boolean isPossible = false;
        while (true) {
            boolean[][] isVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (bfs(map, i, j, isVisited)) {
                        isPossible = true;
                    }
                }
            }
            if (!isPossible) {
                break;
            }
            result++;
            isPossible = false;
        }
        System.out.println(result);
    }

    private static boolean bfs(int[][] map, int x, int y, boolean[][] isVisited) {
        Queue<Coordinate> queue = new LinkedList<>();
        List<Coordinate> availableBorders = new ArrayList<>();
        queue.add(new Coordinate(x, y));

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            if (isVisited[coordinate.x][coordinate.y]) continue;
            isVisited[coordinate.x][coordinate.y] = true;
            availableBorders.add(new Coordinate(coordinate.x, coordinate.y));
            for (int i = 0; i < 4; i++) {
                int nx = coordinate.x + dx[i];
                int ny = coordinate.y + dy[i];

                if (nx >= N || ny >= N || nx < 0 || ny < 0 || isVisited[nx][ny]) continue;

                int difference = Math.abs(map[coordinate.x][coordinate.y] - map[nx][ny]);
                if (L <= difference && R >= difference) {
                    queue.add(new Coordinate(nx, ny));
                }
            }
        }
        if (availableBorders.size() <= 1) {
            return false;
        }
        int sum = 0;
        for (Coordinate availableBorder : availableBorders) {
            sum += map[availableBorder.x][availableBorder.y];
        }
        sum /= availableBorders.size();
        for (Coordinate availableBorder : availableBorders) {
            map[availableBorder.x][availableBorder.y] = sum;
        }

        return true;
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
