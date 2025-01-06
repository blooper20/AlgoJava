package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	1024 MB	17586	8651	7705	50.000%
문제
정수를 저장하는 덱을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
5: 덱에 들어있는 정수의 개수를 출력한다.
6: 덱이 비어있으면 1, 아니면 0을 출력한다.
7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
입력
첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)

둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.

출력을 요구하는 명령은 하나 이상 주어진다.

출력
출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class B28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            String[] inputCommand = command.split(" ");
            int result = 0;

            result = DoCommand(inputCommand, deque);
            if (result != -2) {
                sb.append(result);
                if (i != N - 1) sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int DoCommand(String[] command, Deque<Integer> deque) {
        int output = -2;
        if (command.length == 2) {
            if (command[0].equals("1")) {
                deque.addFirst(Integer.parseInt(command[1]));
            } else if (command[0].equals("2")) {
                deque.addLast(Integer.parseInt(command[1]));
            }
        } else {
            if (command[0].equals("3")) {
                output = Optional.ofNullable(deque.pollFirst()).orElse(-1);
            } else if (command[0].equals("4")) {
                output = Optional.ofNullable(deque.pollLast()).orElse(-1);
            } else if (command[0].equals("5")) {
                output = deque.size();
            } else if (command[0].equals("6")) {
                output = (deque.isEmpty()) ? 1 : 0;
            } else if (command[0].equals("7")) {
                output = Optional.ofNullable(deque.peekFirst()).orElse(-1);
            } else if (command[0].equals("8")) {
                output = Optional.ofNullable(deque.peekLast()).orElse(-1);
            }
        }
        return output;
    }
}
