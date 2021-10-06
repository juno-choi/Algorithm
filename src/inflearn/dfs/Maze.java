package inflearn.dfs;

import java.util.Scanner;

/**
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
 *
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
 *
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 *
 * 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
 *
 */
public class Maze {
    static int[][] maze = new int[8][8];
    static int answer = 0;
    static int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<8; i++){
            for(int j=1; j<8; j++){
                maze[i][j] = sc.nextInt();
            }
        }

        dfs(1,1);

        System.out.println(answer);
    }
    public static void dfs(int x, int y){
        if(x>7 || y>7 || x<1 || y<1) return;
        if(maze[x][y] == 1) return;
        if(x==7 && y==7){
            answer++;
        }else{
            for(int[] dir : direction){
                maze[x][y] = 1;
                dfs(x+dir[0], y+dir[1]);
                maze[x][y] = 0;
            }
        }
    }
}
