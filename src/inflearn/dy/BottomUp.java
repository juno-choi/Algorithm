package inflearn.dy;

import java.util.Scanner;

/**
 *
 */
public class BottomUp {
    static int[] dy;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        dy = new int[n+1];
        int solution = solution(n);
        System.out.println(solution);
    }
    public static int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n; i++){
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n];
    }
}
