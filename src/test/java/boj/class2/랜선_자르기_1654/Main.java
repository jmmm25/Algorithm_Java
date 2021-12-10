package boj.class2.랜선_자르기_1654;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/랜선_자르기_1654/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long max = Long.MIN_VALUE;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        max++;
        System.out.println(upperBound(N, M, max, arr));
    }

    private static long upperBound(int N, int M, long max, int[] arr) {
        long min = 0;
        while (min < max) {
            long mid = (min + max) / 2;
            int count = 0;
            for (int i = 0; i < N; i++) {
                count += (arr[i] / mid);
            }
            if (count < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min - 1;
    }
}
