package boj.class2.숫자_카드_10815;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/숫자_카드_10815/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(arr, Integer.parseInt(stringTokenizer.nextToken())) >= 0) {
                stringBuilder.append(1).append(" ");
            } else {
                stringBuilder.append(0).append(" ");
            }
        }
        System.out.println(stringBuilder);
    }
}
