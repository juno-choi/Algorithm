package back.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1292 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine().trim();
        String[] split = input.split(" ");

        sb.append(solve(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        System.out.println(sb);
    }

    public static String solve(int start, int end){
        int result = 0;
        // 최대 1000
        int num = 1;
        int index = 0;
        int[] array = new int[end * (end+1) /2];
        for(int i=1; i<=end; i++){
            for(int j=1; j<= i; j++){
                array[index++] = num;
            }
            num++;
        }

        for(int i = start-1; i<end; i++){
            result += array[i];
        }

        return String.format("%d", result);
    }
}
