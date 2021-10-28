package boj.class1.단어공부;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "C:\\Users\\jmkim\\Algorithm_Java\\src\\test\\java\\boj\\class1\\단어공부\\input.txt";
        System.setIn(new FileInputStream(PATH));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        String str = stringTokenizer.nextToken().toUpperCase();
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(String.valueOf(str.charAt(i)), map.getOrDefault(String.valueOf(str.charAt(i)), 0) + 1);
        }

        int maxValue = Integer.MIN_VALUE;
        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                result = entry.getKey();
            } else if (entry.getValue() == maxValue) {
                result = "?";
            }
        }

        System.out.println(result);
    }
}
