package back.bronze3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10818 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.valueOf(bf.readLine().trim());
        int[] list = new int[input];
        String str = bf.readLine().trim();
        String[] split = str.split(" ");
        for(int i=0; i<input; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        sb.append(solve(list));
        System.out.println(sb);
    }

    public static String solve(int[] list){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i : list){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        return String.format("%d %d", min, max);
    }
}
