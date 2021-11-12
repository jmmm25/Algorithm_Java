package boj.class1.숫자의_개수_2577;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class1/숫자의_개수_2577/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int value = 1;
        for (int i = 0; i < 3; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            value *= Integer.parseInt(stringTokenizer.nextToken());
        }

        String str = Integer.toString(value);
        int[] result = new int[10];
        for (char ch : str.toCharArray()) {
            result[ch - '0']++;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
