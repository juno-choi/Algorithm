package inflearn.hash_set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 *
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
 *
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
 *
 * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
 */
public class ClassPresident {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        String str = in.next();
        char[] chars = str.toCharArray();

        String solution = solution(chars);
        System.out.println(solution);
    }
    public static String solution(char[] arr){
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for(char s : arr){
            map.put(String.valueOf(s), map.getOrDefault(String.valueOf(s), 0)+1);
        }

        for(String key : map.keySet()){
            int value = map.get(key);
            if(value > max){
                max = value;
                answer = key;
            }
        }

        return answer;
    }
}
