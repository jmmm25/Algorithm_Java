package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 메뉴_리뉴얼 {
    static Map<String, Integer> map;

    void combination(String str, StringBuilder stringBuilder, int idx, int cnt, int n) {
        if (cnt == n) {
            map.put(stringBuilder.toString(), map.getOrDefault(stringBuilder.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            combination(str, stringBuilder, i + 1, cnt + 1, n);
            stringBuilder.delete(cnt, cnt + 1);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        String[] answer = {};

        // 1. Orders의 String 정렬 (오름차순)
        for (int i = 0; i < orders.length; i++) {
            char[] ordersCharArray = orders[i].toCharArray();
            Arrays.sort(ordersCharArray);
            orders[i] = String.valueOf(ordersCharArray);
        }

        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;

            // Orders의 조합 및 갯수 카운팅
            for (int j = 0; j < orders.length; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                if (course[i] <= orders[j].length()) {
                    combination(orders[j], stringBuilder, 0, 0, course[i]);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max) {
                    list.add(entry.getKey());
                }
            }

            Collections.sort(list);
        }

        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    @Test
    void init1() {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] answer = {"AC", "ACDE", "BCFG", "CDE"};

        Assertions.assertArrayEquals(solution(orders, course), answer);
    }

    @Test
    void init2() {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 4};
        String[] answer = {"ACD", "AD", "ADE", "CD", "XYZ"};

        Assertions.assertArrayEquals(solution(orders, course), answer);
    }

    @Test
    void init3() {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] answer = {"WX", "XY"};

        Assertions.assertArrayEquals(solution(orders, course), answer);
    }
}
