package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;
            ArrayList<Integer> numArray = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int sum = 0;

            sb.append(n).append(" =");
            for (int i = 1; i <= n; i++) {
                if (n % i == 0 && n != i) {
                    numArray.add(i);
                    sum += i;
                    sb.append(" ").append(i).append(" +");
                }
            }

            if (sum == n) {
                System.out.println(sb.delete(sb.length() - 2, sb.length()));
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}
