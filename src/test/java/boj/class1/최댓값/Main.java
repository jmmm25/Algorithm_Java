package boj.class1.최댓값;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class Info {
        int order;
        int number;

        public Info(int order, int number) {
            this.order = order;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class1/최댓값/input.txt";
        System.setIn(new FileInputStream(PATH));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Info> infoList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            infoList.add(new Info(i, Integer.parseInt(stringTokenizer.nextToken())));
        }

        Collections.sort(infoList, (a, b) -> a.number > b.number ? -1 : 1);
        System.out.println(infoList.get(0).number);
        System.out.println(infoList.get(0).order);
    }
}
