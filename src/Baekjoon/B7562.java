package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	68783	37071	27525	52.697%
문제
체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?



입력
입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

출력
각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {
    static int[][] moves = new int[][]{{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};
    static boolean[][] visited;
    static int[][] board;
    static int[] start;
    static int[] end;
    static int I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I];
            board = new int[I][I];

            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            start = new int[]{startX, startY};

            st = new StringTokenizer(br.readLine());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int result = 0;

            if (startX == endX && startY == endY) {
                sb.append(result).append("\n");
                continue;
            }

            bfs();

            result = board[endX][endY];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int[] move: moves) {
                if (isValid(move[0] + curX, move[1] + curY) && !visited[move[0] + curX][move[1] + curY]) {
                    queue.add(new int[]{move[0] + curX, move[1] + curY});
                    visited[move[0] + curX][move[1] + curY] = true;
                    board[move[0] + curX][move[1] + curY] = board[curX][curY] + 1;
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >=0 && x < I && y >= 0 && y < I;
    }
}
