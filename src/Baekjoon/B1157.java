package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	318063	128152	100627	39.938%
문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String uppercaseStr = input.toUpperCase();

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : uppercaseStr.toCharArray()) {
            if (ch != ' ') {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }

        char mostFrequentChar = ' ';
        int maxFrequency = 0;
        boolean isDupe = false;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentChar = entry.getKey();
                maxFrequency = entry.getValue();
                isDupe = false;
            } else if (entry.getValue() == maxFrequency) {
                isDupe = true;
            }
        }

        if (isDupe) {
            System.out.println("?");
        } else {
            System.out.println(mostFrequentChar);
        }
    }
}
