package boj.class1.검증수_2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        final String PATH = "C:\\Users\\jmkim\\Algorithm_Java\\src\\test\\java\\boj\\class1\\검증수\\input.txt";
//        System.setIn(new FileInputStream(PATH));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N1 = Integer.parseInt(stringTokenizer.nextToken());
        int N2 = Integer.parseInt(stringTokenizer.nextToken());
        int N3 = Integer.parseInt(stringTokenizer.nextToken());
        int N4 = Integer.parseInt(stringTokenizer.nextToken());
        int N5 = Integer.parseInt(stringTokenizer.nextToken());
        int sum = (N1 * N1) + (N2 * N2) + (N3 * N3) + (N4 * N4) + (N5 * N5);

        System.out.println(sum % 10);
    }
}
