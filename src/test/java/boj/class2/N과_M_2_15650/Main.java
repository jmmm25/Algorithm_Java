package boj.class2.N과_M_2_15650;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/N과_M_2_15650/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();
        int[] arr = new int[N];

        dfs(N, M, arr, 1, 0);
    }

    private static void dfs(int N, int M, int[] arr, int index, int depth) {
        if (depth == M) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < M; i++) {
                stringBuilder.append(arr[i]).append(" ");
            }
            System.out.println(stringBuilder);
            return;
        }

        for (int i = index; i <= N; i++) {
            arr[depth] = i;
            dfs(N, M, arr, i + 1, depth + 1);
        }
    }

}
