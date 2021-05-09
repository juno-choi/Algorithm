package back.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /**
     * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
     */
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input1 = bf.readLine().trim();

        solve(input1);
    }
    public static void solve(String input1){
        //a~b까지 소수를 구하기
        //소수는 2의 배수, 3의 배수를 제외한 수

        //structure
        int[] input = Arrays.asList(input1.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int a = input[0];
        int b = input[1];

        //for while
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=a; i<=b; i++){
            if(i==1)continue;
            if(i <= 3 || i==5 || i==7){
                result.add(i);
                continue;
            }
            if(i%2 != 0 && i%3 != 0 && i%5 != 0 && i%7 != 0){
                result.add(i);
            }
        }

        result.forEach(item->{
            System.out.println(item);
        });

    }
}
