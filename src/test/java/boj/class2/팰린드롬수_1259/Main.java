package boj.class2.팰린드롬수_1259;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/팰린드롬수_1259/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            if ("0".equals(str)) break;
            int size = str.length();
            boolean isPalindrome = true;
            for (int i = 0; i < (size / 2); i++) {
                if (str.charAt(i) != str.charAt(size - i - 1)) {
                    isPalindrome = false;
                    break;
                }
            }
            System.out.println(isPalindrome ? "yes" : "no");
        }
    }

}
