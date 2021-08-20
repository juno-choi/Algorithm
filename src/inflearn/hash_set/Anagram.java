package inflearn.hash_set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
 *
 * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
 *
 * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
 *
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
 */
public class Anagram {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        String solution = solution2(input1, input2);
        System.out.println(solution);
    }
    public static String solution(String input1, String input2){
        char[] chars1 = input1.toCharArray();
        char[] chars2 = input2.toCharArray();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(char c : chars1){
            map1.put(String.valueOf(c), map1.getOrDefault(String.valueOf(c),0)+1);
        }
        for(char c : chars2){
            map2.put(String.valueOf(c), map2.getOrDefault(String.valueOf(c),0)+1);
        }
        if(map1.equals(map2)) return "YES";
        else return "NO";
    }

    public static String solution2(String input1, String input2){
        char[] chars1 = input1.toCharArray();
        char[] chars2 = input2.toCharArray();

        Map<String, Integer> map = new HashMap<>();

        for(char c : chars1){
            map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c),0)+1);
        }
        for(char c : chars2){
            if(!map.containsKey(String.valueOf(c)) || map.get(String.valueOf(c))==0) return "NO";    //key값이 존재하지 않거나 key값이 0일 경우
            map.put(String.valueOf(c),map.get(String.valueOf(c))-1);    //그 외의 경우 map에서 값을 1씩 감소시켜 모두 0이 되면 됨! 하지만 이 위의 조건에 걸릴 경우 이미 결과가 나오기 때문에 종료
        }

        return "YES";
    }
}
