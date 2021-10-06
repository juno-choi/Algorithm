package inflearn.dfs;

import java.util.Scanner;

/**
 * 조합수
 * ex) 2C1, 5C3 등...
 * 의 값을 구하세요.
 *
 * 조합수란
 * 5C3일 경우 1,2,3,4,5 중 3개의 숫자를 뽑아서 조합할 수 있는 개수를 의미한다.
 * 5C3 = 4C2+ 4C3
 * nCr = (n-1)C(r-1) + (n-1)C(r)
 * 또한 1C0 or 3C3은 조합의 수가 1개이므로 1이 반환된다.
 *
 * nCr의 조합수를 구하세요.
 */
public class CombinationNumber {
    static int[][] memo = new int[35][35];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        memo = new int[n+1][n+1];
        System.out.println(dfs(n,r));
    }
    public static int dfs(int n, int r){
        if(n==r || r==0){
            return 1;
        }else{
            if(memo[n][r] != 0) return memo[n][r];
            return memo[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
        }
    }
}
