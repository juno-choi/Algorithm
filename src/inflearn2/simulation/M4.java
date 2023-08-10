package inflearn2.simulation;

public class M4 {
    public static void main(String[] args) {
        int c= 6;
        int r= 5;
        int k= 31;
        int[] solution = solution(c, r, k);
        System.out.println(solution[0] + ", " + solution[1]);
    }
    public static int[] solution(int c, int r, int k){
        // check 배열
        boolean[][] checkArray = new boolean[c][r];
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] start = {0, 0};
        int directionIndex = 0;
        int cnt = 1;
        checkArray[start[0]][start[1]] = true;

        if(k > c*r){
            return new int[]{0,0};
        }

        while(cnt < k){
            if(cnt > c*r){
                break;
            }

            int x = start[0] + direction[directionIndex][0];
            int y = start[1] + direction[directionIndex][1];
            if(x < 0 || y < 0 || x >= c || y >= r || checkArray[x][y]){
                directionIndex = (directionIndex + 1) % 4;
                continue;
            }

            checkArray[x][y] = true;
            start[0] = x;
            start[1] = y;
            cnt++;
        }

        return new int[]{start[0]+1, start[1]+1};
    }
}
