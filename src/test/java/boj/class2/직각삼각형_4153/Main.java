package boj.class2.직각삼각형_4153;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/직각삼각형_4153/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = null;
        while (true) {
            int[] array = new int[3];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            array[0] = Integer.parseInt(stringTokenizer.nextToken());
            array[1] = Integer.parseInt(stringTokenizer.nextToken());
            array[2] = Integer.parseInt(stringTokenizer.nextToken());
            Arrays.sort(array);
            if (array[0] == 0 && array[1] == 0 && array[2] == 0) break;
            if (Math.pow(array[2], 2) == (Math.pow(array[0], 2) + Math.pow(array[1], 2))) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
