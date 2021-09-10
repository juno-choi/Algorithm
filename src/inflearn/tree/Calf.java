package inflearn.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
 *
 * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
 *
 * 송아지는 움직이지 않고 제자리에 있다.
 *
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
 *
 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
 */
public class Calf {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();

        Calf c = new Calf();
        int bfs = c.bfs(input1, input2);
        int bfs2 = c.bfs2(input1, input2);
        System.out.println(bfs);
        System.out.println(bfs2);
    }
    public int bfs(int start, int calf){
        int count = 0;
        Jump jump = new Jump(start);

        while(jump.data != calf){

            int min = Integer.MAX_VALUE;
            int m = Math.abs(calf - jump.minus);
            int p = Math.abs(calf - jump.plus);
            int j = Math.abs(calf - jump.jump);

            min = Math.min(min, m);
            min = Math.min(min, p);
            min = Math.min(min, j);
            if(min == m) jump = new Jump(jump.minus);
            else if(min == p) jump = new Jump(jump.plus);
            else if(min == j) jump = new Jump(jump.jump);

            count++;
        }

        return count;
    }

    int[] dis = {1,-1,5};
    int[] ch;
    Queue<Integer> que = new LinkedList<>();
    public int bfs2(int s, int e){
        ch= new int[10001]; //방문 체크 배열
        ch[s] = 1;
        que.offer(s);
        int level = 0;
        while(!que.isEmpty()){
            int length = que.size();
            for(int i=0; i<length; i++){
                int x = que.poll();
                for(int j : dis){
                    int nx = x+j;
                    if(nx==e) return level+1;
                    if(nx>=1 && nx<=10000 && ch[nx]==0){
                        ch[nx] =1;
                        que.offer(nx);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
class Jump{
    int data;
    int plus;
    int minus;
    int jump;

    public Jump(int data) {
        this.data = data;
        plus = data+1;
        minus = data-1;
        jump = data+5;
    }
}
