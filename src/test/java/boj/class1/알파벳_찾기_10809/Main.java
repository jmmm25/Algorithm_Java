package boj.class1.알파벳_찾기_10809;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class1/알파벳_찾기_10809/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        String str = stringTokenizer.nextToken();
        for (char ch : str.toCharArray()) {
            int index = str.indexOf(ch);
            if (arr[ch - 97] == -1) {
                arr[ch - 97] = index;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
