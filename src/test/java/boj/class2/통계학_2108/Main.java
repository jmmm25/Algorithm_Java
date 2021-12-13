package boj.class2.통계학_2108;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/통계학_2108/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N];
        int[] countArray = new int[8001];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            countArray[arr[i] + 4000]++;
        }
        Arrays.sort(arr);
        // 1. 산술 평균
        System.out.println(Math.round(Arrays.stream(arr).average().getAsDouble()));
        // 2. 중앙 값
        System.out.println(arr[N / 2]);
        // 3. 최빈 값
        int max = 0;
        for (int i = 0; i < 8001; i++) {
            if (countArray[i] >= max) {
                max = countArray[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (countArray[i] == max) {
                list.add(i - 4000);
            }
        }
        System.out.println(list.size() == 1 ? list.get(0) : list.stream().sorted().collect(Collectors.toList()).get(1));
        // 4. 범위
        System.out.println(arr[arr.length - 1] - arr[0]);
    }
}
