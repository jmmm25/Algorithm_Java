package boj.class2.좌표_정렬하기_11651;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/좌표_정렬하기_11651/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        List<Coordinate> coordinateList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            coordinateList.add(new Coordinate(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }
        Collections.sort(coordinateList, (o1, o2) -> {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            } else {
                return o1.y - o2.y;
            }
        });
        for (Coordinate coordinate : coordinateList) {
            System.out.println(coordinate.x + " " + coordinate.y);
        }
    }
}
