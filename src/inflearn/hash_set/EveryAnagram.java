package inflearn.hash_set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 *
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 */
public class EveryAnagram {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        int solution = solution(input1, input2);
        System.out.println(solution);
    }
    public static int solution(String input1, String input2){
        int answer = 0;
        char[] chars1 = input1.toCharArray();
        char[] chars2 = input2.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for(char c : chars2){
            map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c),0)+1);
        }

        int n = chars1.length;
        int k = chars2.length;
        Map<String, Integer> map2 = new HashMap<>();
        int lp = 0;
        for(int i = 0; i<k-1; i++){
            map2.put(String.valueOf(chars1[lp]),map2.getOrDefault(String.valueOf(chars1[lp]),0)+1);
            lp++;
        }
        lp = 0;
        for(int rp=k-1; rp<n; rp++){
            map2.put(String.valueOf(chars1[rp]),map2.getOrDefault(String.valueOf(chars1[rp]),0)+1);
            String key = String.valueOf(chars1[lp]);

            if(map.equals(map2)){
                answer++;
            }
            map2.put(key,map2.getOrDefault(key,0)-1);

            if(map2.get(key) == 0){
                map2.remove(key);
            }
            lp++;
        }
        return answer;
    }
}
