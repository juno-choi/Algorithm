package inflearn.string;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 6. 중복문자제거
 * 설명
 *
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 *
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 */
public class RemoveDuplicateCharacter {
    //1. set을 활용한 방법
    /*public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.next();
        char[] chars = input.toCharArray();
        Set<Character> set = new LinkedHashSet<>();
        for(char c : chars){
            set.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : set){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }*/

    //2. 문자열 체크를 통해 직접 확인하는 방법
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.next();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char target = input.charAt(i);  //i 위치의 문자 확인
            int index = input.indexOf(target);  //target 문자의 문자열에서의 위치
            if(i==index){   //i와 index가 같다면 해당 문자는 문자열에서 처음 나온 문자, 그렇지 않다면 중복되는 문자
                sb.append(target);
            }
        }
        System.out.println(sb.toString());
    }
}
