package boj.N과_M_3_15651;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/N과_M_3_15651/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();
        int[] arr = new int[N];

        dfs(N, M, arr, 1, 0);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void dfs(int N, int M, int[] arr, int index, int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bufferedWriter.write(String.valueOf(arr[i]) + ' ');
            }
            bufferedWriter.newLine();
            return;
        }
        for (int i = index; i <= N; i++) {
            arr[depth] = i;
            dfs(N, M, arr, 1, depth + 1);
        }
    }
}
