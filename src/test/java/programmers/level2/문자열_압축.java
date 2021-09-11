package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 문자열_압축 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int sLength = s.length();

        for (int i = 1; i <= sLength / 2; i++) {
            int count = 1;
            String substringStr = s.substring(0, i);
            String result = "";
            for (int j = i; j <= sLength; j += i) {
                String compareStr = "";
                if (j + i > sLength) {
                    compareStr = s.substring(j);
                } else {
                    compareStr = s.substring(j, j + i);
                }
                if (substringStr.equals(compareStr)) {
                    count++;
                } else {
                    if (count == 1) {
                        result += substringStr;
                    } else {
                        result += count + substringStr;
                    }
                    substringStr = compareStr;
                    count = 1;
                }
                if (j + i > sLength) {
                    result += substringStr;
                }
            }

            answer = Math.min(answer, result.length());
        }

        return answer == Integer.MAX_VALUE ? 1 : answer;
    }

    @Test
    void init1() {
        String s = "abcabcdede";
        int answer = 8;
        int result = solution(s);
        Assertions.assertEquals(result, answer);
    }

    @Test
    void init2() {
        String s = "aabbaccc";
        int answer = 7;
        int result = solution(s);
        Assertions.assertEquals(result, answer);
    }

    @Test
    void init3() {
        String s = "ababcdcdababcdcd";
        int answer = 9;
        int result = solution(s);
        Assertions.assertEquals(result, answer);
    }

    @Test
    void init4() {
        String s = "abcabcdede";
        int answer = 8;
        int result = solution(s);
        Assertions.assertEquals(result, answer);
    }

    @Test
    void init5() {
        String s = "abcabcabcabcdededededede";
        int answer = 14;
        int result = solution(s);
        Assertions.assertEquals(result, answer);
    }

    @Test
    void init6() {
        String s = "xababcdcdababcdcd";
        int answer = 17;
        int result = solution(s);
        Assertions.assertEquals(result, answer);
    }

    @Test
    void init7() {
        String s = "a";
        int answer = 1;
        int result = solution(s);
        Assertions.assertEquals(result, answer);
    }
}
