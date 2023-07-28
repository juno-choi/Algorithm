package back.bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B8958 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.parseInt(bf.readLine().trim());
        String[] list = new String[input];
        for(int i=0; i<input; i++){
            list[i] = bf.readLine().trim();
        }

        sb.append(solve(input, list));
        System.out.println(sb);
    }

    public static String solve(int input, String[] list){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<input; i++){
            int score = 0;
            int totalScore = 0;
            String str = list[i];
            char[] charArray = str.toCharArray();
            for(char c : charArray){
                if(c == 'X'){
                    score = 0;
                }else{
                    totalScore += ++score;
                }
            }
            sb.append(totalScore);
            sb.append("\n");
        }
        return sb.toString();
    }
}
