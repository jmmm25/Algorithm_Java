package leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1773. Count Items Matching a Rule

public class _1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int answer = 0;
        int index = 0;
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
        }
        for (int i = 0; i < items.size(); i++) {
            if (ruleValue.equals(items.get(i).get(index))) {
                answer++;
            }
        }

        return answer;
    }

    @Test
    void init() {
        List<List<String>> items = new ArrayList<>();
        List<String> item1 = Arrays.asList("phone", "blue", "pixel");
        List<String> item2 = Arrays.asList("computer", "silver", "lenovo");
        List<String> item3 = Arrays.asList("phone", "gold", "iphone");
        items.add(item1);
        items.add(item2);
        items.add(item3);

        String ruleKey = "color";
        String ruleValue = "silver";

        Assertions.assertEquals(countMatches(items, ruleKey, ruleValue), 1);
    }
}
