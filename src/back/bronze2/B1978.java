package back.bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1978 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.parseInt(bf.readLine().trim());
        String str = bf.readLine();
        String[] split = str.split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<input; i++){
            list.add(Integer.parseInt(split[i]));
        }

        sb.append(solve(list));
        System.out.println(sb);
    }

    public static String solve(List<Integer> list){
        int result = 0;
        int max = Integer.MIN_VALUE;
        for(int i : list){
            max = Math.max(max, i);
        }

        boolean[] isPrime = new boolean[max+1];
        isPrime [0] = true; //true일 경우 소수가 아님
        isPrime [1] = true;

        for(int i=2; i<max; i++){
            for(int j=2; i*j<=max; j++){
                isPrime[i*j] = true;
            }
        }

        for(int i : list){
            if(!isPrime[i]){
                result++;
            }
        }

        return String.format("%d", result);
    }
}
