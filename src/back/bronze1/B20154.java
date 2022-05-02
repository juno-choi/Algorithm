package back.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/20154
 *
 * ABCDE
 */
public class B20154 {
    static final Map<String, Integer> MAP = new HashMap<>();

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine().trim();

        //map에 획수 정보 넣기
        MAP.put("A",3);
        MAP.put("B",2);
        MAP.put("C",1);
        MAP.put("D",2);
        MAP.put("E",3);
        MAP.put("F",3);
        MAP.put("G",3);
        MAP.put("H",3);
        MAP.put("I",1);
        MAP.put("J",1);
        MAP.put("K",3);
        MAP.put("L",1);
        MAP.put("M",3);
        MAP.put("N",3);
        MAP.put("O",1);
        MAP.put("P",2);
        MAP.put("Q",2);
        MAP.put("R",2);
        MAP.put("S",1);
        MAP.put("T",2);
        MAP.put("U",1);
        MAP.put("V",1);
        MAP.put("W",2);
        MAP.put("X",2);
        MAP.put("Y",2);
        MAP.put("Z",1);

        sb.append(solve(input));
        System.out.print(sb);
    }
    public static String solve(String str){

        char[] chars = str.toCharArray();
        int su = 0;
        //모든 알파벳을 획수 숫자로 치환
        int i = 0;
        for(char c : chars){
            su += MAP.get(String.valueOf(c));
        }
        su = su%10;

        //홀수면 I'm a winner!
        //짝수면 You're the winner?
        return su%2 == 0 ? "You're the winner?" : "I'm a winner!";
    }
}
