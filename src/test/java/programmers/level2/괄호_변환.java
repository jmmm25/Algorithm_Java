package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 괄호_변환 {
    private String getNormalString(String u, String v) {
        String answer = "";
        boolean isNormalStringU = checkNormalString(u);

        // u가 올바른 문자열일 경우
        if (isNormalStringU) {
            if (v.length() == 0) {
                return u;
            } else {
                int subStringIndex = getSubStringIndex(v);
                answer = u + getNormalString(v.substring(0, subStringIndex + 1), v.substring(subStringIndex + 1));
            }
        }
        // u가 올바른 문자열이 아닐 경우
        else {
            String ans = "";
            if (v.length() == 0) {
            } else {
                int subStringIndex = getSubStringIndex(v);
                ans = getNormalString(v.substring(0, subStringIndex + 1), v.substring(subStringIndex + 1));
            }
            answer = "(" + ans + ")" + convertUString(u);
        }

        return answer;
    }

    private String convertUString(String u) {
        String result = "";
        u = u.substring(1, u.length() - 1);
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                result += ")";
            } else {
                result += "(";
            }
        }

        return result;
    }

    private int getSubStringIndex(String p) {
        int left = 0, right = 0;
        int index = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                index = i;
                break;
            }
        }

        return index;
    }

    // 올바른 문자열인지를 체크
    private boolean checkNormalString(String p) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            if (stack.isEmpty()) {
                if (p.charAt(i) == ')') {
                    return false;
                } else {
                    stack.push(p.charAt(i));
                }
            } else {
                if (p.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(p.charAt(i));
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    public String solution(String p) {
        String answer = "";
        if (p.length() == 0) {
            return "";
        }
        boolean isNormal = checkNormalString(p);
        //올바른 문자열이면 answer에 p 대입
        if (isNormal) {
            answer = p;
        }
        // 올바른 문자열이 아니라면 u, v 분리 작업 진행
        else {
            int subStringIndex = getSubStringIndex(p);
            answer = getNormalString(p.substring(0, subStringIndex + 1), p.substring(subStringIndex + 1));
        }

        return answer;
    }


    @Test
    void init1() {
        String p = "(()())()";
        Assertions.assertEquals(solution(p), "(()())()");
    }

    @Test
    void init2() {
        String p = ")(";
        Assertions.assertEquals(solution(p), "()");
    }

    @Test
    void init3() {
        String p = "()))((()";
        Assertions.assertEquals(solution(p), "()(())()");
    }
}
