package boj.class2.벌집_2292;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/벌집_2292/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int count = 1;
        int number = 1;
        while (true) {
            if (N == 1) {
                System.out.println(1);
                return;
            }
            number += 6 * count;
            if (N <= number) {
                break;
            }
            count++;
        }
        System.out.println(++count);
    }
}
