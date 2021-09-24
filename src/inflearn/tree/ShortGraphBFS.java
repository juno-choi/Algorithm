package inflearn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 그래프 1번 정점에서 각 정점으로 가는 최소 이동수를 구하세요.
 */
public class ShortGraphBFS {
    static int n,m = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        ch = new int[n+1];
        dis = new int[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        bfs(1);
        for (int i=1; i<=n; i++) {
            System.out.println(i+" = " +dis[i]);
        }
    }
    public static void bfs(int v){
        Queue<Integer> que = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        que.offer(v);
        while(!que.isEmpty()){
            int cv = que.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    que.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }
}
