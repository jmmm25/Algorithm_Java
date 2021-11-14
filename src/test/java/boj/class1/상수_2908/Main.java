package boj.class1.상수_2908;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class1/상수_2908/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        String first = stringTokenizer.nextToken();
        String second = stringTokenizer.nextToken();

        String reverseFirst = "";
        String reverseSecond = "";
        for (int i = first.length() - 1; i >= 0; i--) {
            reverseFirst += first.charAt(i);
        }
        for (int i = second.length() - 1; i >= 0; i--) {
            reverseSecond += second.charAt(i);
        }

        System.out.println(Math.max(Integer.parseInt(reverseFirst), Integer.parseInt(reverseSecond)));

    }
}
