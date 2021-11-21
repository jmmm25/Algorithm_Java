package boj.class2.달팽이는_올라가고_싶다_2869;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/달팽이는_올라가고_싶다_2869/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Double A = Double.valueOf(stringTokenizer.nextToken());
        Double B = Double.valueOf(stringTokenizer.nextToken());
        Double V = Double.valueOf(stringTokenizer.nextToken());
        int day = (int) (Math.ceil((V - A) / (A - B)) + 1);
        bufferedWriter.write(String.valueOf(day));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
