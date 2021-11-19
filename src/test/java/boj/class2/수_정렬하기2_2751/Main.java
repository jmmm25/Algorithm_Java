package boj.class2.수_정렬하기2_2751;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/수_정렬하기2_2751/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        Collections.sort(list);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); // 선언
        for (int i = 0; i < N; i++) {
            bufferedWriter.write(String.valueOf(list.get(i)) + "\n");
        }
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
