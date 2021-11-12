package boj.class1.숫자의_개수_2577;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class1/숫자의_개수_2577/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int value = 1;
        for (int i = 0; i < 3; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            value *= Integer.parseInt(stringTokenizer.nextToken());
        }

        Map<Character, Integer> map = new HashMap<>();
        String valueStr = String.valueOf(value);
        for (int i = 0; i < valueStr.length(); i++) {
            map.put(valueStr.charAt(i), map.getOrDefault(valueStr.charAt(i), 0) + 1);
        }

        int[] result = new int[10];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int index = Integer.parseInt(String.valueOf(entry.getKey()));
            result[index] = entry.getValue();
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
