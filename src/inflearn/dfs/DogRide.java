package inflearn.dfs;

import java.util.Scanner;

/**
 * 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
 *
 * 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
 *
 * N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
 */
public class DogRide {
    static int n,m,sum,max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        dfs(0,0, arr);
        System.out.println(max);
    }
    public static void dfs(int level, int sum, int[] arr){
        if(level == n){
            if(sum<m){
                max = Math.max(sum, max);
            }
        }else{
            dfs(level+1, sum+arr[level], arr);
            dfs(level+1, sum, arr);
        }
    }
}
