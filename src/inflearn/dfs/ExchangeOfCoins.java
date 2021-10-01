package inflearn.dfs;

import java.util.Scanner;

/**
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 *
 * 각 단위의 동전은 무한정 쓸 수 있다.
 */
public class ExchangeOfCoins {
    static int n,m=0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        m = sc.nextInt();

        dfs(0, 0, coins);

        System.out.println(min);
    }
    public static void dfs(int level, int sum, int[] coins){
        if(level>=min) return;
        if(sum>m) return;
        if(sum == m){
            min = Math.min(min, level);
        }else{
            for(int i=n-1; i>=0; i--){
                dfs(level+1, sum+coins[i], coins);
            }
        }
    }
}
