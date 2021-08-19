package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    private static final String CHANGE = "Change";
    private static final String ENTER = "Enter";
    private static final String LEAVE = "Leave";

    public String[] solution(String[] records) {
        String[] answer = {};
        String type, id, name = null;
        Map<String, String> map = new HashMap<>();
        for (String record : records) {
            String[] splitRecord = record.split(" ");
            type = splitRecord[0];
            id = splitRecord[1];
            if (CHANGE.equals(type)) {
                name = splitRecord[2];
                map.replace(id, name);
            } else if (ENTER.equals(type)) {
                name = splitRecord[2];
                if (map.get(id) == null) {
                    map.put(id, name);
                } else {
                    map.replace(id, name);
                }
            } else {
                continue;
            }
        }

        List<String> answers = new ArrayList<>();
        for (String record : records) {
            String[] splitRecord = record.split(" ");
            type = splitRecord[0];
            id = splitRecord[1];
            if (ENTER.equals(type)) {
                answers.add(map.get(id) + "님이 들어왔습니다.");
            } else if (LEAVE.equals(type)) {
                answers.add(map.get(id) + "님이 나갔습니다.");
            } else {
                continue;
            }
        }

        answer = new String[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }

        return answer;
    }


    @Test
    void init1() {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};
        String[] answer = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        String[] result = solution(record);

        Assertions.assertArrayEquals(result, answer);
    }
}
