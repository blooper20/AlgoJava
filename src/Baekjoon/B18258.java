package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초 (하단 참고)	512 MB	114737	37621	30423	32.885%
문제
정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class B18258 {
    static int lastPush; // 큐에 마지막에 넣은 값을 저장하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            String[] inputCommand = command.split(" ");

            int output = DoCommand(inputCommand, queue);

            if (!(output < -1)) {
                sb.append(output);
                if (i != N - 1) sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int DoCommand(String[] inputCommand, Queue<Integer> queue) {
        if (inputCommand.length == 2) {
            int pushNum = Integer.parseInt(inputCommand[1]);
            queue.add(pushNum);

            lastPush = pushNum;
            return -2;
        } else {
            int someNum = -2;

            if (inputCommand[0].equals("pop")) {
                someNum = queue.isEmpty() ? -1 : Integer.parseInt(String.valueOf(queue.poll()));
            } else if (inputCommand[0].equals("size")) {
                someNum = queue.size();
            } else if (inputCommand[0].equals("empty")) {
                someNum = queue.isEmpty()? 1 : 0;
            } else if (inputCommand[0].equals("front")) {
                someNum = Optional.ofNullable(queue.peek()).orElse(-1); // 값이 null일 경우 default 값 대입
            } else if (inputCommand[0].equals("back")) {
                someNum = queue.isEmpty()? -1 : lastPush;
            }

            return someNum;
        }
    }
}
