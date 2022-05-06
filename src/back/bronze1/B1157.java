package back.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

public class B1157 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine().trim();

        solve(input.toUpperCase(Locale.ROOT));
    }
    public static void solve(String input){
        //알파벳 체크 배열
        int[] alphabet = new int[26];
        char[] chars = input.toCharArray();
        for(char c : chars){
            //배열의 값 증가
            alphabet[(c-'A')]++;
        }
        //4번찍힌 알파벳이 최고
        int max = Arrays.stream(alphabet).max().getAsInt();
        //2개 이상일 경우 체크
        long count = Arrays.stream(alphabet).filter(p -> p == max).count();

        if(count>1) {
            System.out.println("?");
            return ;
        }

        int index = 0;
        for(int a : alphabet){
            if(a == max) break;
            index++;
        }
        char maxAlphabet = (char)('A'+index);
        System.out.println(maxAlphabet);
    }
}
