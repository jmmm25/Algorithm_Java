package boj.class2.분해합_2231;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/분해합_2231/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 1; i <= 1000000; i++) {
            int sum = i;
            int num = i;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum == N) {
                System.out.println(i);
                break;
            }
            if (i + 1 > 1000000) {
                System.out.println(0);
                break;
            }
        }
    }
}
