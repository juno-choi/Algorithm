package inflearn.tree;

import java.util.Scanner;

/**
 * 경로탐색 DFS 인접 행렬 탐색
 */
public class AdjacencyMatrix {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][m+1];
        ch = new int[n+1];
        for(int i=0; i<m; i++){
            int su1 = sc.nextInt();
            int su2 = sc.nextInt();
            graph[su1][su2] = 1;
        }
        ch[1] = 1;
        dfs(1);
        System.out.println(answer);
    }
    public static void dfs(int v){
        if(v==n){
            answer ++;
            return ;
        }

        for(int i=1; i<=n; i++){
            if(graph[v][i] == 1 && ch[i] == 0){
                ch[i] = 1;
                dfs(i);
                ch[i] = 0;
            }
        }
    }
}
