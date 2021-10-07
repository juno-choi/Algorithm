package inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
 *
 * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
 *
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
 *
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 *
 * 위와 같은 경로가 최단 경로의 길이는 12이다.
 */
public class Maze {
    static int[][] maze, check;
    static int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) {
        maze = new int[8][8];
        check = new int[8][8];

        Scanner sc = new Scanner(System.in);
        for(int i=1; i<8; i++){
            for(int j=1; j<8; j++){
                maze[i][j] = sc.nextInt();
            }
        }

        bfs(1,1);
        int result = check[7][7];
        if(result == 0) System.out.println(-1);
        else System.out.println(result);
    }

    public static void bfs(int x, int y){
        Queue<Pointer> que = new LinkedList<>();
        que.offer(new Pointer(x,y));

        while(!que.isEmpty()){
            Pointer p = que.poll();
            for(int[] dir : direction){
                int nx = p.x + dir[0];
                int ny = p.y + dir[1];
                if(nx>0 && nx<8 && ny>0 && ny<8 && maze[nx][ny] != 1){
                    check[nx][ny] = check[p.x][p.y] + 1;
                    maze[nx][ny] = 1;
                    que.offer(new Pointer(nx, ny));
                }
            }
        }
    }

    static class Pointer{
        int x;
        int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
