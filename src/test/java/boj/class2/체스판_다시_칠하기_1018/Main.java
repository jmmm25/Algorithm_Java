package boj.class2.체스판_다시_칠하기_1018;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/체스판_다시_칠하기_1018/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String row = stringTokenizer.nextToken();
            for (int j = 0; j < M; j++) {
                char[] rowToCharArray = row.toCharArray();
                board[i][j] = rowToCharArray[j];
            }
        }
        char[][] whiteBoard = new char[8][8];
        char[][] blackBoard = new char[8][8];
        int flag = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                whiteBoard[i][j] = flag == 1 ? 'W' : 'B';
                flag *= -1;
                blackBoard[i][j] = flag == 1 ? 'W' : 'B';
            }
            flag *= -1;
        }

        int answer = Integer.MAX_VALUE;
        int x = 0, y = 0;
        while (true) {
            int whiteResult = 0;
            int blackResult = 0;
            for (int i = x; i < x + 8; i++) {
                for (int j = y; j < y + 8; j++) {
                    if (board[i][j] != whiteBoard[i - x][j - y]) {
                        whiteResult++;
                    }
                    if (board[i][j] != blackBoard[i - x][j - y]) {
                        blackResult++;
                    }
                }
            }
            int resultMinValue = Math.min(whiteResult, blackResult);
            answer = Math.min(answer, resultMinValue);
            if ((y + 1) + 8 <= M) {
                y++;
            } else {
                if ((x + 1) + 8 <= N) {
                    x++;
                    y = 0;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
