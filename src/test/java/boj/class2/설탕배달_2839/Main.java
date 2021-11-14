package boj.class2.설탕배달_2839;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/설탕배달_2839/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] dp = new int[5001];
        Arrays.fill(dp, -1);

        dp[3] = 1;
        dp[5] = 1;
        int N = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 6; i <= N; i++) {
            int dp3 = Integer.MAX_VALUE, dp5 = Integer.MAX_VALUE;
            if (dp[i - 5] != -1) {
                dp5 = dp[i - 5] + dp[5];
            }
            if (dp[i - 3] != -1) {
                dp3 = dp[i - 3] + dp[3];
            }
            dp[i] = Math.min(dp3, dp5) != Integer.MAX_VALUE ? Math.min(dp3, dp5) : -1;
        }

        System.out.println(dp[N]);
    }
}
