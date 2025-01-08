package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	130339	47716	35979	34.824%

입력
첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 내가 맞춰야 하는 문제의 개수 M이 주어져. N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수인데,
자연수가 뭔지는 알지? 모르면 물어봐도 괜찮아. 나는 언제든지 질문에 답해줄 준비가 되어있어.

둘째 줄부터 N개의 줄에 포켓몬의 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한 줄에 하나씩 입력으로 들어와. 포켓몬의 이름은 모두 영어로만 이루어져있고, 또, 음... 첫 글자만 대문자이고, 나머지 문자는 소문자로만 이루어져 있어.
아참! 일부 포켓몬은 마지막 문자만 대문자일 수도 있어. 포켓몬 이름의 최대 길이는 20, 최소 길이는 2야. 그 다음 줄부터 총 M개의 줄에 내가 맞춰야하는 문제가 입력으로 들어와.
문제가 알파벳으로만 들어오면 포켓몬 번호를 말해야 하고, 숫자로만 들어오면, 포켓몬 번호에 해당하는 문자를 출력해야해.
입력으로 들어오는 숫자는 반드시 1보다 크거나 같고, N보다 작거나 같고, 입력으로 들어오는 문자는 반드시 도감에 있는 포켓몬의 이름만 주어져. 그럼 화이팅!!!

출력
첫째 줄부터 차례대로 M개의 줄에 각각의 문제에 대한 답을 말해줬으면 좋겠어!!!.
입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을, 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력하면 돼. 그럼 땡큐~
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> idToPokemon = new HashMap<>();
        HashMap<String, Integer> pokemonToId = new HashMap<>();

        for (int i = 1; i < N + 1; i++) { // 키값에는 번호, value엔 포켓몬 이름이 오는 map
            String pokemon = br.readLine();
            idToPokemon.put(i, pokemon);
            pokemonToId.put(pokemon, i);
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 1; i < M + 1; i++) {
            String pokemonOrNum = br.readLine();

            if (IsInteger(pokemonOrNum)) { // 키 값에 입력값이 포함될 때(숫자 값이 주어졌을 때)
                int no = Integer.parseInt(pokemonOrNum);
                ans.append(idToPokemon.get(no)).append('\n');

            } else { // 키 값에 입력값이 없을 때(포켓몬 이름이 주어졌을 때)
                ans.append(pokemonToId.get(pokemonOrNum)).append('\n');
            }
        }

        System.out.println(ans);
    }

    private static boolean IsInteger(String str) {
        /// String 값을 매개변수로 받아와서 형변환이 가능한 지 판별 해주는 함수
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
