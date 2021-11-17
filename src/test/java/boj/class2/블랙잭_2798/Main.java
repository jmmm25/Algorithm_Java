package boj.class2.블랙잭_2798;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int range = Integer.MAX_VALUE;
    static int result = 0;

    static void permutation(int[] arr, boolean[] flag, int index) {
        if (index == 3) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (flag[i]) {
                    sum += arr[i];
                }
            }
            if (M >= sum && range > Math.abs(M - sum)) {
                range = Math.abs(M - sum);
                result = sum;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (flag[i]) continue;
            flag[i] = true;
            permutation(arr, flag, index + 1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/블랙잭_2798/input2.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N];
        boolean[] flag = new boolean[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        permutation(arr, flag, 0);
        System.out.println(result);

    }
}
