package boj.class2.스택_10828;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final String PUSH = "push";
    private static final String TOP = "top";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String POP = "pop";

    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/스택_10828/input.txt";
        System.setIn(new FileInputStream(PATH));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            switch (command) {
                case PUSH:
                    int number = Integer.parseInt(stringTokenizer.nextToken());
                    stack.push(number);
                    break;
                case TOP:
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
                case SIZE:
                    System.out.println(stack.size());
                    break;
                case EMPTY:
                    if (stack.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case POP:
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
