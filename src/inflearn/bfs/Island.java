package inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
 *
 * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
 *
 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 *
 * Image1.jpg
 *
 * 만약 위와 같다면 섬의 개수는 5개입니다.
 *
 *
 * 입력
 * 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
 *
 * 두 번째 줄부터 격자판 정보가 주어진다.
 *
 */
public class Island {
    static int[][] arr, check;
    static int[][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    static int input1, answer = 0;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        input1 = in.nextInt();
        arr = new int[input1+1][input1+1];
        check = new int[input1+1][input1+1];
        for(int i=1; i<=input1; i++){
            for(int j=1; j<=input1; j++){
                arr[i][j] = in.nextInt();
            }
        }
        solution(1,1);
        System.out.println(answer);
    }
    public static void solution(int x, int y){
        for(int i=1; i<=input1; i++){
            for(int j=1; j<=input1; j++){
                if(arr[i][j] != 0 && check[i][j] != 1){
                    Queue<Xy> que = new LinkedList();
                    que.offer(new Xy(i, j));
                    bfs(que);
                    answer++;
                }
            }
        }
    }
    public static void bfs(Queue<Xy> que){
        while(!que.isEmpty()){
            Xy xy = que.poll();
            check[xy.x][xy.y] = 1;
            for(int[] direct : dir){
                int nx = xy.x+direct[0];
                int ny = xy.y+direct[1];
                if(nx>0&&nx<=input1&&ny>0&&ny<=input1){
                    if(arr[nx][ny] == 1 && check[nx][ny] == 0){
                        que.offer(new Xy(nx,ny));
                        check[nx][ny] = 1;
                    }
                }
            }
        }
    }
    public static class Xy{
        int x;
        int y;

        public Xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
