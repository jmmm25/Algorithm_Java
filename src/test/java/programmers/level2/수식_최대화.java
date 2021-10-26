package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 수식_최대화 {
    static List<String> operators;
    static List<Long> numbers;
    static long answer;

    public long solution(String expression) {
        answer = 0;
        operators = new ArrayList<>();
        numbers = new ArrayList<>();

        splitExpression(expression);
        String[] charOperators = operators.stream().distinct().toArray(String[]::new);
        String[] outputOperators = new String[charOperators.length];
        boolean[] isVisited = new boolean[charOperators.length];
        dfs(charOperators, outputOperators, isVisited, 0);

        return answer;
    }

    private void dfs(String[] charOperators, String[] outputOperators, boolean[] isVisited, int depth) {
        if (depth == charOperators.length) {
            answer = Math.max(answer, getMaxSum(outputOperators));
            return;
        }

        for (int i = 0; i < charOperators.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                outputOperators[depth] = charOperators[i];
                dfs(charOperators, outputOperators, isVisited, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private long getMaxSum(String[] outputOperators) {
        List<Long> copyNumbers = new ArrayList<>(numbers);
        List<String> copyOperators = new ArrayList<>(operators);

        for (int i = 0; i < outputOperators.length; i++) {
            String currentOperator = outputOperators[i];
            for (int j = 0; j < copyOperators.size(); j++) {
                if (currentOperator.equals(copyOperators.get(j))) {
                    copyOperators.remove(j);
                    long value = calculate(currentOperator, copyNumbers.get(j), copyNumbers.get(j + 1));
                    copyNumbers.remove(j + 1);
                    copyNumbers.remove(j);
                    copyNumbers.add(j, value);
                    j--;
                }
            }
        }
        return Math.abs(copyNumbers.get(0));
    }

    private long calculate(String currentOperator, long a, long b) {
        switch (currentOperator) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
        }
        return 0;
    }

    private void splitExpression(String expression) {
        char[] expressionToChars = expression.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < expressionToChars.length; i++) {
            if (expressionToChars[i] == '*' || expressionToChars[i] == '+' || expressionToChars[i] == '-') {
                numbers.add(Long.parseLong(stringBuilder.toString()));
                stringBuilder.setLength(0);
                operators.add(String.valueOf(expressionToChars[i]));
            } else {
                stringBuilder.append(expressionToChars[i]);
            }
        }
        numbers.add(Long.valueOf(stringBuilder.toString()));
    }

    @Test
    void init1() {
        String expression = "100-200*300-500+20";
        Assertions.assertEquals(60420, solution(expression));
    }

    @Test
    void init2() {
        String expression = "50*6-3*2";
        Assertions.assertEquals(300, solution(expression));
    }
}

