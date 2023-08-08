package inflearn2.simulation;

public class M2 {
    public static void main(String[] args) {
//        int[][] board = {
//                {0,0,0,0,0},
//                {0,1,1,0,0},
//                {0,0,0,0,0},
//                {1,0,1,0,1},
//                {0,0,0,0,0}
//        };
//        int k = 10;

//        int [][]board = {
//                {0, 0, 0, 1, 0, 1},
//                {0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1},
//                {1, 1, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0}
//        };

        int[][] board ={{0, 0, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0,
                0}, {1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}};
        int k = 25;

        System.out.println(solution(board, k)[0] + ", "+solution(board, k)[1]);
    }
    public static int[] solution(int[][] board, int k){
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int directionIndex = 0;
        int[] current = {0,0};
        int boardLength = board.length;

        for(int i=0; i<k; i++){
            int x = current[0] + direction[directionIndex][0];
            int y = current[1] + direction[directionIndex][1];
            if(x >= boardLength || y >= boardLength || x < 0 || y < 0){
                directionIndex = changeDirection(directionIndex);
                continue;
            }
            int su = board[x][y];
            if(su == 1){
                directionIndex = changeDirection(directionIndex);
                continue;
            }

            // 0 일때
            current[0] += direction[directionIndex][0];
            current[1] += direction[directionIndex][1];
        }

        return current;
    }

    private static int changeDirection(int directionIndex) {
        directionIndex++;
        if(directionIndex == 4){
            directionIndex = 0;
        }
        return directionIndex;
    }
}
