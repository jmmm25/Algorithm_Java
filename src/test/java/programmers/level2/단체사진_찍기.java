package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 단체사진_찍기 {
    static String[] characters = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static boolean[] isVisited = new boolean[8];
    int answer = 0;

    public void permutation(int idx, String line, String[] data) {
        if (idx == 8) {
            if (checkData(line, data)) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 8; ++i) {
            if (isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            permutation(idx + 1, line + characters[i], data);
            isVisited[i] = false;
        }
    }

    private boolean checkData(String line, String[] data) {
        for (int i = 0; i < data.length; i++) {
            String rule = data[i];
            char characterIndexOne = rule.charAt(0);
            char characterIndexTwo = rule.charAt(2);
            char cmp = rule.substring(3, 4).charAt(0);
            int number = Integer.valueOf(rule.substring(4));
            int length = Math.abs(line.indexOf(characterIndexOne) - line.indexOf(characterIndexTwo)) - 1;
            if (!checkLineLength(length, cmp, number)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLineLength(int length, char cmp, int number) {
        if (cmp == '=') {
            if (length == number) return true;
            else return false;
        } else if (cmp == '>') {
            if (length > number) return true;
            else return false;
        } else if (cmp == '<') {
            if (length < number) return true;
            else return false;
        } else {
            return false;
        }
    }


    public int solution(int n, String[] data) {
        String line = "";
        permutation(0, line, data);

        return answer;
    }

    @Test
    void init1() {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        int answer = 3648;
        int result = solution(n, data);

        Assertions.assertEquals(result, answer);
    }
}
