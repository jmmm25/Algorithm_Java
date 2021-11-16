package boj.class2.괄호_9012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/괄호_9012/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String vps = stringTokenizer.nextToken();
            Stack<Character> stack = new Stack<>();
            char[] vpsToCharArray = vps.toCharArray();
            if (vpsToCharArray[0] == ')') {
                System.out.println("NO");
                continue;
            }
            for (char ch : vpsToCharArray) {
                if (stack.isEmpty()) {
                    stack.push(ch);
                    continue;
                }
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            System.out.println(stack.isEmpty() ? "YES" : "NO");
        }
    }
}
