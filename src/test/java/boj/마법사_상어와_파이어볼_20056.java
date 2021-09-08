package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 마법사_상어와_파이어볼_20056 {
    static int N, M, K;
    static List<FireBall> map[][];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private static void moveFireballs() {
        List<FireBall> nextMap[][] = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nextMap[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() < 1) continue;
                else {
                    for (int k = 0; k < map[i][j].size(); k++) {
                        int distance = map[i][j].get(k).s % N;
                        int nr = i + (dx[map[i][j].get(k).d] * distance);
                        int nc = j + (dy[map[i][j].get(k).d] * distance);
                        if (nr < 0) {
                            nr += N;
                        } else if (nr >= N) {
                            nr -= N;
                        }
                        if (nc < 0) {
                            nc += N;
                        } else if (nc >= N) {
                            nc -= N;
                        }
                        nextMap[nr][nc].add(new FireBall(map[i][j].get(k).m, map[i][j].get(k).s, map[i][j].get(k).d));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nextMap[i][j].size() >= 2) {
                    int sumM = 0;
                    int sumS = 0;
                    boolean even = true, odd = true;

                    for (FireBall fireBall : nextMap[i][j]) {
                        sumM += fireBall.m;
                        sumS += fireBall.s;
                        if (fireBall.d % 2 == 0) odd = false;
                        else even = false;
                    }
                    int m = sumM / 5;
                    int s = sumS / nextMap[i][j].size();
                    nextMap[i][j].clear();

                    if (m > 0) {
                        if (even || odd) {
                            nextMap[i][j].add(new FireBall(m, s, 0));
                            nextMap[i][j].add(new FireBall(m, s, 2));
                            nextMap[i][j].add(new FireBall(m, s, 4));
                            nextMap[i][j].add(new FireBall(m, s, 6));
                        } else {
                            nextMap[i][j].add(new FireBall(m, s, 1));
                            nextMap[i][j].add(new FireBall(m, s, 3));
                            nextMap[i][j].add(new FireBall(m, s, 5));
                            nextMap[i][j].add(new FireBall(m, s, 7));
                        }
                    }
                }
            }
        }
        map = nextMap;
    }

    private static int solution() {
        int result = 0;
        for (int i = 0; i < K; i++) {
            moveFireballs();
        }
        result = sumMassive();

        return result;
    }

    private static int sumMassive() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() > 0) {
                    for (FireBall fireBall : map[i][j]) {
                        result += fireBall.m;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        map = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int c = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            map[r][c].add(new FireBall(m, s, d));
        }

        int result = solution();
        System.out.println(result);

    }

    public static class FireBall {
        int m;
        int s;
        int d;

        public FireBall(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
