package boj.class2.소수_찾기_1978;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/소수_찾기_1978/input.txt";
        System.setIn(new FileInputStream(PATH));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            if (number == 1) continue;
            boolean isPrimeNumber = true;
            for (int j = 2; j <= Math.sqrt(number); j++) {
                if (number % j == 0) {
                    isPrimeNumber = false;
                }
            }
            if (isPrimeNumber) result++;
            else continue;
        }
        System.out.println(result);
    }

}
