package boj.class2.이항_계수_1_11050;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/이항_계수_1_11050/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));
    }

    static int factorial(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = n * factorial(n - 1);
    }
}
