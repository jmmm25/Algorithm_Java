package boj.class2.요세푸스_문제_0_11866;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/요세푸스_문제_0_11866/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        List<Integer> answerList = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            if (count % K != 0) {
                int number = queue.poll();
                queue.add(number);
            } else {
                answerList.add(queue.poll());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int value : answerList) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(value);
        }
        System.out.println("<" + stringBuilder + ">");

    }
}
