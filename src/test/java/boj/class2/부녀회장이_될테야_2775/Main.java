package boj.class2.부녀회장이_될테야_2775;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/부녀회장이_될테야_2775/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < T; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(solution(k, n));
        }
    }

    private static int solution(int k, int n) {
        int[][] arr = new int[15][15];
        for (int i = 1; i <= n; i++) {
            arr[0][i] = i;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= j; l++) {
                    arr[i][j] += arr[i - 1][l];
                }
            }
        }

        return arr[k][n];
    }
}
