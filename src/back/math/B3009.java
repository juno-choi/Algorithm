package back.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B3009 {
    /**
     * 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input1 = bf.readLine().trim();
        String input2 = bf.readLine().trim();
        String input3 = bf.readLine().trim();

        sb.append(solve(input1,input2,input3));
        System.out.print(sb);
    }
    public static String solve(String input1, String input2, String input3){

        int[] a = Arrays.asList(input1.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.asList(input2.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int[] c = Arrays.asList(input3.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        int[] result = new int[2];

        if(a[0]==b[0]){
            result[0] = c[0];
        }else if(a[0]==c[0]){
            result[0] = b[0];
        }else{
            result[0] = a[0];
        }

        if(a[1]==b[1]){
            result[1] = c[1];
        }else if(a[1]==c[1]){
            result[1] = b[1];
        }else{
            result[1] = a[1];
        }

        return result[0]+" "+result[1];
    }
}
