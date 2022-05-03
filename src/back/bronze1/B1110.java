package back.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1110 {
    static int value = 0;
    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.valueOf(bf.readLine().trim());
        value = input;
        sb.append(solve(input));
        System.out.println(sb);
    }
    public static String solve(int input){

        dfs(0, input);

        return String.valueOf(result);
    }
    public static void dfs(int level, int input){
        if(value == input && level != 0){
            result = level;
            return;
        }

        char[] chars = null;
        if(input>9){
            chars = String.valueOf(input).toCharArray();
        }else{
            chars = new char[2];
            chars[0] = '0';
            chars[1] = (char)(input+'0');
        }

        String newSu1 = String.valueOf(chars[1]);
        String newSu2 = String.valueOf(((Integer.valueOf(String.valueOf(chars[0])) + Integer.valueOf(String.valueOf(chars[1]))) % 10));

        dfs(level+1, Integer.valueOf(newSu1+newSu2));
    }
}
