package boj.class2.나무_자르기_2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/나무_자르기_2805/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long max = Long.MIN_VALUE;
        long[] arr = new long[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        long min = 0;
        System.out.println(upperBound(N, M, max, arr, min));

    }

    private static long upperBound(int N, int M, long max, long[] arr, long min) {
        while (min < max) {
            long mid = (min + max) / 2;
            long length = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0) {
                    length += (arr[i] - mid);
                }
            }

            if (length < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min - 1;
    }
}
