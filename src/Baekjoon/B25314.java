package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초 (추가 시간 없음)	1024 MB (추가 메모리 없음)	105947	66912	60116	63.748%
문제
오늘은 혜아의 면접 날이다. 면접 준비를 열심히 해서 앞선 질문들을 잘 대답한 혜아는 이제 마지막으로 칠판에 직접 코딩하는 문제를 받았다. 혜아가 받은 문제는 두 수를 더하는 문제였다. C++ 책을 열심히 읽었던 혜아는 간단히 두 수를 더하는 코드를 칠판에 적었다. 코드를 본 면접관은 다음 질문을 했다. “만약, 입출력이
$N$바이트 크기의 정수라면 프로그램을 어떻게 구현해야 할까요?”

혜아는 책에 있는 정수 자료형과 관련된 내용을 기억해 냈다. 책에는 long int는
$4$바이트 정수까지 저장할 수 있는 정수 자료형이고 long long int는
$8$바이트 정수까지 저장할 수 있는 정수 자료형이라고 적혀 있었다. 혜아는 이런 생각이 들었다. “int 앞에 long을 하나씩 더 붙일 때마다
$4$바이트씩 저장할 수 있는 공간이 늘어나는 걸까? 분명 long long long int는
$12$바이트, long long long long int는
$16$바이트까지 저장할 수 있는 정수 자료형일 거야!” 그렇게 혜아는 당황하는 면접관의 얼굴을 뒤로한 채 칠판에 정수 자료형을 써 내려가기 시작했다.

혜아가
$N$바이트 정수까지 저장할 수 있다고 생각해서 칠판에 쓴 정수 자료형의 이름은 무엇일까?

입력
첫 번째 줄에는 문제의 정수
$N$이 주어진다.

출력
혜아가
$N$바이트 정수까지 저장할 수 있다고 생각하는 정수 자료형의 이름을 출력하여라.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = "";

        for (int i = 0; i < n / 4; i++) {
            s += "long ";
        }
        System.out.println(s + "int");
    }
}
