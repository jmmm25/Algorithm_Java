package boj.class1.음계_2920;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class1/음계_2920/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i <= 8; i++) {
            if (arr[0] == 1) {
                if (i == 8) {
                    System.out.println("ascending");
                    break;
                }
                if (arr[i] != i + 1) {
                    System.out.println("mixed");
                    break;
                }
            } else if (arr[0] == 8) {
                if (i == 8) {
                    System.out.println("descending");
                    break;
                }
                if (arr[i] != 8 - i) {
                    System.out.println("mixed");
                    break;
                }
            } else {
                System.out.println("mixed");
                break;
            }
        }

    }
}
