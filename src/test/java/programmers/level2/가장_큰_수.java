package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = (String.valueOf(numbers[i]));
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (str[0].equals("0")) return "0";
        for (String s : str) answer += s;

        return answer;
    }

    @Test
    void init1() {
        int[] numbers = {6, 2, 10};
        String answer = "6210";

        Assertions.assertEquals(solution(numbers), answer);
    }

    @Test
    void init2() {
        int[] numbers = {3, 30, 34, 5, 9};
        String answer = "9534330";

        Assertions.assertEquals(solution(numbers), answer);
    }

    @Test
    void init3() {
        int[] numbers = {0, 0, 0};
        String answer = "0";

        Assertions.assertEquals(solution(numbers), answer);
    }
}
