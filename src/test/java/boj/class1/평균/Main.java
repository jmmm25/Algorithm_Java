package boj.class1.평균;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        final String PATH = "C:\\Users\\jmkim\\Algorithm_Java\\src\\test\\java\\boj\\class1\\평균\\input.txt";
//        System.setIn(new FileInputStream(PATH));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        Double[] scores = new Double[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            scores[i] = Double.parseDouble(stringTokenizer.nextToken());
        }
        Arrays.sort(scores, Collections.reverseOrder());
        double maxValue = scores[0];
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += (scores[i] / maxValue * 100);
        }


        System.out.println((double) (sum / N));
    }
}
