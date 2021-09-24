package inflearn.tree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 5개의 정점을 가지는 방향 그래프의 모든 경로의 가지 수를 출력하는 프로그램을 작성하는 문제가 있다. 이때 입력되는 예시는
 *
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 *
 */
public class AdjacencyMatrix2ArrayList {
    static int n,m,answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        ch = new int[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
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
        for(int nv : graph.get(v)){
            if(ch[nv] == 0){
                ch[nv] = 1;
                dfs(nv);
                ch[nv] = 0;
            }
        }
    }
}
