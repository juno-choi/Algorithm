package inflearn2.simulation;

public class M3 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 2, 0, 0}, {1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 3, 0, 0, 0, 1}, {0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0, 0, 0, 0, 0} };

        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = 0;

        int[][] personDirect = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[] person = {0, 0};
        int personDirectIndex = 0;

        int[][] dogDirect = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[] dog = {0, 0};
        int dogDirectIndex = 0;


        // 현수 2 찾기
        int boardLength = board.length;
        for (int i = 0; i < boardLength; i++) {
            int length = board[i].length;
            for (int j = 0; j < length; j++) {
                int su = board[i][j];
                if (su == 2) {
                    person[0] = i;
                    person[1] = j;
                } else if (su == 3) {
                    dog[0] = i;
                    dog[1] = j;
                }
            }
        }

        for (int i = 0; i < 10000; i++) {
            answer++;

            int personX = person[0] + personDirect[personDirectIndex][0];
            int personY = person[1] + personDirect[personDirectIndex][1];
            boolean personStay = false;

            int dogX = dog[0] + dogDirect[dogDirectIndex][0];
            int dogY = dog[1] + dogDirect[dogDirectIndex][1];
            boolean dogStay = false;

            if (personX >= boardLength || personY >= boardLength
                    || personX < 0 || personY < 0
                    || board[personX][personY] == 1
            ) {
                personDirectIndex++;
                personDirectIndex = personDirectIndex >= personDirect.length ? 0 : personDirectIndex;
                personStay = true;
            }

            if (dogX >= boardLength || dogY >= boardLength
                    || dogX < 0 || dogY < 0
                    || board[dogX][dogY] == 1
            ) {
                dogDirectIndex++;
                dogDirectIndex = dogDirectIndex >= dogDirect.length ? 0 : dogDirectIndex;
                dogStay = true;
            }

            if (!personStay) {
                person[0] = personX;
                person[1] = personY;
            }

            if (!dogStay) {
                dog[0] = dogX;
                dog[1] = dogY;
            }

            if(person[0] == dog[0] && person[1] == dog[1]){
                break;
            }
        }
        return answer == 9999 ? 0 : answer;
    }
}
