package boj.class1.OX퀴즈_8958;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class1/OX퀴즈_8958/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int T = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < T; i++) {
            int result = 0;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String testCase = stringTokenizer.nextToken();
            int count = 0;
            for (int j = 0; j < testCase.length(); j++) {
                if (testCase.charAt(j) == 'O') {
                    count++;
                    result += count;
                } else {
                    count = 0;
                }
            }
            System.out.println(result);
        }
    }

}
