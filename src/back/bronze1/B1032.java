package back.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1032 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.valueOf(bf.readLine().trim());
        String[] strs = new String[input];
        for(int i=0; i<input; i++){
            strs[i] = bf.readLine().trim();
        }

        sb.append(solve(strs));
        System.out.println(sb);
    }
    public static String solve(String[] strs){
        int length = strs[0].length();
        char[] chars = new char[length];

        Arrays.stream(strs).forEach(s -> {
            char[] chars1 = s.toCharArray();
            for(int i=0; i<length; i++){
                if(chars[i] == 0){  //char가 비었을 땐 0으로 체크
                    chars[i] = chars1[i];
                    continue;
                }
                else if(chars[i] == '?') continue;
                else if(chars[i] != chars1[i]){
                    chars[i] = '?';
                    continue;
                }
            }
        });

        return String.valueOf(chars);
    }
}
