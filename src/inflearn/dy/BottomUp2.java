package inflearn.dy;

import java.util.Scanner;

/**
 * 철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.
 *
 * 철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
 *
 * 철수가 개울을 건너는 방법은 몇 가지일까요?
 */
public class BottomUp2 {
    static int[] dy;
    public static void main(String[] args){
        BottomUp2 bu = new BottomUp2();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        dy= new int[n+2];
        int solution = bu.solution(n);
        System.out.println(solution);
    }
    public int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n+1; i++){
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n+1];
    }
}
