package boj.class2.스택_수열_1874;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/스택_수열_1874/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int top = 0;
        int N = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int value = Integer.parseInt(stringTokenizer.nextToken());
            if (value > top) {
                for (int j = top + 1; j <= value; j++) {
                    stack.push(j);
                    stringBuilder.append("+").append("\n");
                }
                top = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            stringBuilder.append("-").append("\n");
        }
        System.out.println(stringBuilder);
    }
}
