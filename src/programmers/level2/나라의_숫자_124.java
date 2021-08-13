package programmers.level2;

public class 나라의_숫자_124 {

    public String solution(int n) {
        int[] arr = new int[]{4, 1, 2};
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int nam = n % 3;
            if (nam == 0) {
                n = n / 3 - 1;
            } else {
                n = n / 3;
            }
            sb.insert(0, arr[nam]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 8;
        나라의_숫자_124 s = new 나라의_숫자_124();

        System.out.println(s.solution(n));
    }

}
