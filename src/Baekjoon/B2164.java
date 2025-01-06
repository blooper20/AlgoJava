package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초 (추가 시간 없음)	128 MB	141677	73779	57293	50.980%
문제
N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.

이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.

N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.

출력
첫째 줄에 남게 되는 카드의 번호를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> cardDeck = new LinkedList<Integer>();

        for (int i = 1; i < N + 1; i++) {
            cardDeck.add(i);
        }

        while (cardDeck.size() > 1) { // 카드 덱의 개수가 1개일 때까지 반복
            solve(cardDeck);
        }
        System.out.println(cardDeck.poll());
    }

    private static void solve(Queue<Integer> cardDeck) {

        cardDeck.poll(); // 맨위 카드 버리기

        if (cardDeck.size() != 1) { // 카드를 버렸는데 카드 덱의 개수가 1개 이상일 때
            int shuffledCard = cardDeck.poll();
            cardDeck.add(shuffledCard); // 맨 위 카드를 맨 밑으로 넣어주기
        } else {
            return; // 카드를 버렸는데 카드 덱 수가 1개 일 때 스탑
        }
    }
}