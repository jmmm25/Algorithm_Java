package boj.class2.Hashing_15829;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH = "src/test/java/boj/class2/Hashing_15829/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String str = stringTokenizer.nextToken();
        BigInteger hashValue = new BigInteger("0");
        BigInteger r = new BigInteger("31");
        BigInteger M = new BigInteger("1234567891");

        for (int i = 0; i < L; i++) {
            hashValue = hashValue.add(BigInteger.valueOf(str.charAt(i) - 96).multiply(r.pow(i)).mod(M));
        }
        System.out.println(hashValue.mod(M));
    }
}
