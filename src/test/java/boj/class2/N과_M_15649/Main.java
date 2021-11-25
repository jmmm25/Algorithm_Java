package boj.class2.N과_M_15649;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/N과_M_15649/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();
        int[] arr = new int[N];
        int[] output = new int[N];
        boolean[] flag = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        permutation(arr, output, flag, N, M, 0);
    }

    private static void permutation(int[] arr, int[] output, boolean[] flag, int N, int M, int index) {
        if (index == M) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < M; i++) {
                stringBuilder.append(output[i]).append(" ");
            }
            System.out.println(stringBuilder);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (flag[i]) continue;
            flag[i] = true;
            output[index] = arr[i];
            permutation(arr, output, flag, N, M, index + 1);
            flag[i] = false;
        }
    }
}
