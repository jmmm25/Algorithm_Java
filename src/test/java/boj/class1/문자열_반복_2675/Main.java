package boj.class1.문자열_반복_2675;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class1/문자열_반복_2675/input.txt";
        System.setIn(new FileInputStream(PATH));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < T; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int R = Integer.parseInt(stringTokenizer.nextToken());
            String S = stringTokenizer.nextToken();
            for (char ch : S.toCharArray()) {
                for (int j = 0; j < R; j++) {
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
}
