package back.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2839 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.valueOf(bf.readLine().trim());

        sb.append(solve(input));
        System.out.println(sb);
    }
    public static String solve(int input){
        int result = 0;
        while(true){
            if(input%5 == 0){
                result += input/5;
                break;
            }else{
                input -= 3;
                result++;
            }

            if(input<0){
                result = -1;
                break;
            }
        }
        return String.valueOf(result);
    }
}
