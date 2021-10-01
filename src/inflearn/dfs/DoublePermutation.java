package inflearn.dfs;

import java.util.Scanner;

/**
 * 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력하세요.
 */
public class DoublePermutation {
    static int[] pm;
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        dfs(0);
    }
    public static void dfs(int level){
        if(level == m){
            for(int i : pm) System.out.print(i+" ");
            System.out.println();
        }else{
            for(int i = 1; i<= n; i++){
                pm[level] = i;
                dfs(level+1);
            }
        }
    }
}
