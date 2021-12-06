package boj.class2.영화감독_숌_1436;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/영화감독_숌_1436/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int number = 666;
        int count = 0;
        while (count < N) {
            if (String.valueOf(number).contains("666")) {
                count++;
            }
            number++;
        }
        System.out.println(--number);
    }
}
