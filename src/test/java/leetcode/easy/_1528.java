package leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _1528 {
    public String restoreString(String s, int[] indices) {
        String answer = "";
        char[] str = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            str[indices[i]] = s.charAt(i);
        }
        answer = String.valueOf(str);

        return answer;
    }

    @Test
    void init() {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};

        Assertions.assertEquals(restoreString(s, indices), "leetcode");
    }
}
