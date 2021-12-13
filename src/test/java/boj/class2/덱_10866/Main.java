package boj.class2.덱_10866;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/덱_10866/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            int value = 0;
            switch (command) {
                case "push_front":
                    value = Integer.parseInt(stringTokenizer.nextToken());
                    deque.addFirst(value);
                    break;
                case "push_back":
                    value = Integer.parseInt(stringTokenizer.nextToken());
                    deque.addLast(value);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.pollFirst());
                    break;
                case "pop_back":
                    if (deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.pollLast());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if (deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.getFirst());
                    break;
                case "back":
                    if (deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.getLast());
                    break;
            }
        }
    }
}
