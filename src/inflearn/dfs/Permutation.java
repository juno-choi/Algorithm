package inflearn.dfs;

import java.util.Scanner;

/**
 * 지정된 수들의 수열을 출력하세요.
 */
public class Permutation {
    static int m,n = 0;
    static int[] ch;
    static int[] pm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[m];
        ch = new int[m];
        pm = new int[n];
        for(int i=0; i<m; i++){
            arr[i] = sc.nextInt();
        }

        solution(arr);
    }
    public static void solution(int[] arr){
        dfs(0, arr);
    }
    public static void dfs(int level, int[] arr){
        if(level == n){ //2단계 일때
            for(int i : pm){
                System.out.print(i+" ");
            }
            System.out.println();
        }else{
            for(int i=0; i<m; i++){
                if(ch[i] != 1){
                    pm[level] = arr[i];
                    ch[i] = 1;
                    dfs(level+1, arr);
                    ch[i] = 0;
                }
            }
        }
    }
}
