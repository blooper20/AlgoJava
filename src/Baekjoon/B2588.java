package Baekjoon;
/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	437863	203561	169425	46.501%
문제
(세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.

입력
첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.

출력
첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2588 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();

        for (int i = 3; i > 0; i--) {
            int n = Integer.parseInt(String.valueOf(b.charAt(i - 1)));
            // 입력 받은 b를 인덱싱 처리로 뒤에서 부터 한 값만 가져와 int로 형변환

            System.out.println(a * n);
        }

        System.out.println(a * Integer.parseInt(b));
    }
}
