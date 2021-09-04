package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소3_17142 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static int[][] map;
    static Queue<Info> queue;
    static List<Virus> virusList;
    static boolean[] isVirusVisited;
    static int result = Integer.MAX_VALUE;
    static int zeroCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][N];
        virusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                }
                if (map[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        isVirusVisited = new boolean[virusList.size()];
        dfs(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void dfs(int start, int count) {
        if (count == M) {
            result = Math.min(result, bfs());
        } else {
            for (int i = start; i < virusList.size(); i++) {
                if (!isVirusVisited[i]) {
                    isVirusVisited[i] = true;
                    dfs(i + 1, count + 1);
                    isVirusVisited[i] = false;
                }
            }
        }

    }

    private static int bfs() {
        int result = 0;
        int spreadVirusCount = 0;
        boolean[][] isVisited = new boolean[N][N];

        queue = new LinkedList<>();
        for (int i = 0; i < virusList.size(); i++) {
            if (isVirusVisited[i] == true) {
                queue.add(new Info(virusList.get(i).x, virusList.get(i).y, 0));
                isVisited[virusList.get(i).x][virusList.get(i).y] = true;
            }
        }

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = info.x + dx[i];
                int ny = info.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 1 && !isVisited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] != 1 && !isVisited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        spreadVirusCount++;
                        result = info.time + 1;
                    }
                    queue.add(new Info(nx, ny, info.time + 1));
                    isVisited[nx][ny] = true;
                }

            }
        }

        if (zeroCount != spreadVirusCount) {
            return Integer.MAX_VALUE;
        }

        return result;
    }

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Info {
        int x;
        int y;
        int time;

        public Info(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}
