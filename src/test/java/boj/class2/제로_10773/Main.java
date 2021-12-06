package boj.class2.제로_10773;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/제로_10773/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        List<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int value = Integer.parseInt(stringTokenizer.nextToken());
            if (value == 0){
                list.remove(list.size() - 1);
            } else{
                list.add(value);
            }
        }

        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        System.out.println(sum);
    }
}
