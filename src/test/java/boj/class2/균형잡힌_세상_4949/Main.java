package boj.class2.균형잡힌_세상_4949;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/균형잡힌_세상_4949/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = null;
        String str = null;
        while (true) {
            Stack<Character> stack = new Stack();
            boolean fail = false;
            str = bufferedReader.readLine();
            if (".".equals(str)) break;
            stringTokenizer = new StringTokenizer(str);
            while (stringTokenizer.hasMoreTokens() && !fail) {
                char[] wordToCharsArray = stringTokenizer.nextToken().toCharArray();
                for (int i = 0; i < wordToCharsArray.length; i++) {
                    if (stack.isEmpty() && wordToCharsArray[i] == ')' || stack.isEmpty() && wordToCharsArray[i] == ']') {
                        fail = true;
                        break;
                    }
                    switch (wordToCharsArray[i]) {
                        case '(':
                            stack.push('(');
                            break;
                        case ')':
                            if (stack.peek() == '(') {
                                stack.pop();
                            } else {
                                stack.push(')');
                            }
                            break;
                        case '[':
                            stack.push('[');
                            break;
                        case ']':
                            if (stack.peek() == '[') {
                                stack.pop();
                            } else {
                                stack.push(']');
                            }
                            break;
                    }
                }
            }
            if (fail) {
                System.out.println("no");
                continue;
            } else if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }
}
