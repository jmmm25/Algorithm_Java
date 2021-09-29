package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1차_뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;

        // 대소문자 구분 X
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str1.length() - 1; i++) {
            if (Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i + 1))) {
                stringBuilder.append(str1.charAt(i));
                stringBuilder.append(str1.charAt(i + 1));
                str1List.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i + 1))) {
                stringBuilder.append(str2.charAt(i));
                stringBuilder.append(str2.charAt(i + 1));
                str2List.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }

        Collections.sort(str1List);
        Collections.sort(str2List);

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        // 교집합 구하기
        for (String str : str1List) {
            if (str2List.remove(str)) {
                intersection.add(str);
            }
            union.add(str);
        }

        // 합집합 구하기
        for (String str : str2List) {
            union.add(str);
        }

        double jakard = 0.0;
        if (union.size() == 0) {
            jakard = 1;
        } else {
            jakard = (double) intersection.size() / (double) union.size();
        }
        answer = (int) (jakard * 65536);

        return answer;
    }


    @Test
    void init1() {
        String str1 = "FRANCE";
        String str2 = "french";
        int answer = 16384;

        Assertions.assertEquals(solution(str1, str2), answer);
    }

    @Test
    void init2() {
        String str1 = "handshake";
        String str2 = "shake hands";
        int answer = 65536;

        Assertions.assertEquals(solution(str1, str2), answer);
    }

    @Test
    void init3() {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        int answer = 43690;

        Assertions.assertEquals(solution(str1, str2), answer);
    }

    @Test
    void init4() {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        int answer = 65536;

        Assertions.assertEquals(solution(str1, str2), answer);
    }

    @Test
    void init5() {
        String str1 = "aa1+aa2";
        String str2 = "AA12";
        int answer = 32768;

        Assertions.assertEquals(solution(str1, str2), answer);
    }
}
