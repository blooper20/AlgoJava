package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> firstQ = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            firstQ.add(i);
        }

        sb.append("<");

        while (firstQ.size() != 0) {
            int josephus = KillK(firstQ, K);

            sb.append(josephus);
            if (firstQ.size() != 0) sb.append(", ");
        }

        sb.append(">");

        System.out.println(sb);
    }

    private static int KillK(Queue<Integer> firstQ, int K) {
        for (int i = 1; i <= K + 1; i++) {
            if (K != i) {
                firstQ.add(firstQ.poll());
            } else {
                return firstQ.poll();
            }
        }
        return -1;
    }
}
