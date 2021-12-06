package boj.class2.덩치_7568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Member {
        int weight;
        int height;

        public Member(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/덩치_7568/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            members.add(new Member(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        int[] result = new int[N];
        for (int i = 0; i < members.size(); i++) {
            solution(members, i, N, result);
        }
        for (int rank : result) {
            System.out.println(rank + 1);
        }
    }

    private static void solution(List<Member> members, int i, int N, int[] result) {
        for (int j = 0; j < N; j++) {
            if (i == j) continue;
            if (members.get(i).weight < members.get(j).weight && members.get(i).height < members.get(j).height) {
                result[i]++;
            }
        }
    }
}
