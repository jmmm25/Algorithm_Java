package boj.class2.프린터_큐_1966;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Data {
        int number;
        int order;

        public Data(int number, int order) {
            this.number = number;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/프린터_큐_1966/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        while (T-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            Queue<Data> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                queue.add(new Data(i, value));
                priorityQueue.add(value);
            }
            int count = 0;
            while (!queue.isEmpty()) {
                Data data = queue.poll();
                if (priorityQueue.peek() == data.order) {
                    priorityQueue.poll();
                    count++;
                    if (data.number == M) {
                        System.out.println(count);
                    }
                } else {
                    queue.add(data);
                }
            }
        }
    }
}
