package inflearn2.simulation;

public class M3 {
    public static void main(String[] args) {
        int[][] board = {
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}
        };

        System.out.println(solution(board));
    }
    public static int solution(int[][] board){
        int answer = 0;

        int[][] personDirect = {{-1,0},{0,1},{1,0},{0,-1}};
        int[] person = {0,0};
        int personDirectIndex = 0;

        int[][] dogDirect = {{-1,0},{0,1},{1,0},{0,-1}};
        int[] dog = {0,0};
        int dogDirectIndex = 0;


        // 현수 2 찾기
        int boardLength = board.length;
        for(int i=0; i<boardLength; i++){
            int length = board[i].length;
            for(int j=0; j<length; j++){
                int su = board[i][j];
                if(su == 2){
                    person[0] = i;
                    person[1] = j;
                }else if(su == 3){
                    dog[0] = i;
                    dog[1] = j;
                }

            }
        }
        // 강아지 3 찾기
        for(int i=0; i<10000; i++){
            int personX = person[0]+personDirect[personDirectIndex][0];
            int personY = person[1]+personDirect[personDirectIndex][1];
            boolean personStay = false;

            int dogX = dog[0]+dogDirect[dogDirectIndex][0];
            int dogY = dog[1]+dogDirect[dogDirectIndex][1];
            boolean dogStay = false;

            if(personX>= boardLength || personY>= boardLength || personX<0 || personY<0){
                personDirectIndex++;
                personStay = true;
                if(personDirectIndex == 4){
                    personDirectIndex= 0;
                }
            }
            if(dogX>= boardLength || dogY>= boardLength || dogX<0 || dogY<0){
                dogDirectIndex++;
                dogStay = true;
                if(dogDirectIndex == 4){
                    dogDirectIndex= 0;
                }
            }
            if(personStay){
                personX = person[0];
                personY = person[1];
            }
            if(dogStay){
                dogX = dog[0];
                dogY = dog[1];
            }

            int personSu = board[personX][personY];
            if(personSu == 1 && !personStay){
                personDirectIndex++;
                personStay = true;
                if(personDirectIndex == 4){
                    personDirectIndex= 0;
                }
            }

            int dogSu = board[dogX][dogY];
            if(dogSu == 1 && !dogStay){
                dogDirectIndex++;
                dogStay = true;
                if(dogDirectIndex == 4){
                    dogDirectIndex= 0;
                }
            }

            person[0] = personX;
            person[1] = personY;

            dog[0] = dogX;
            dog[1] = dogY;



            if(person[0] == dog[0] && person[1] == dog[1]){
                break;
            }

            answer++;
        }
        return answer == 9999 ? 0 : answer;
    }
}
