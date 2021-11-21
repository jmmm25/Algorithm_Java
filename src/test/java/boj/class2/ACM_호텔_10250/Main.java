package boj.class2.ACM_호텔_10250;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/ACM_호텔_10250/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        while (T-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int H = Integer.parseInt(stringTokenizer.nextToken());
            int W = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            solution(H, W, N);
        }
    }

    private static void solution(int H, int W, int N) {
        for (int j = 1; j <= W; j++) {
            for (int k = 1; k <= H; k++) {
                if (--N == 0) {
                    System.out.format("%d" + "%02d%n", k, j);
                }
            }
        }
    }
}
