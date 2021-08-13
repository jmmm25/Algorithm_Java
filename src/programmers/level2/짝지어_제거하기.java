package programmers.level2;

import java.util.Stack;

public class 짝지어_제거하기 {
    public int solution(String str) {
        int answer = -1;
        Stack<Character> s = new Stack<>();
        int currentIndex = 0;
        s.push(str.charAt(currentIndex));
        while (currentIndex != str.length() - 1) {
            if (!s.isEmpty() && s.peek() == str.charAt(currentIndex + 1)) {
                s.pop();
                currentIndex++;
            } else {
                s.push(str.charAt(++currentIndex));
            }
        }
        if (s.isEmpty()) answer = 1;
        else answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        짝지어_제거하기 m = new 짝지어_제거하기();
        String s = "cdcd";

        System.out.println(m.solution(s));
    }
}
