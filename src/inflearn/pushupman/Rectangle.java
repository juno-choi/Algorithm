package inflearn.pushupman;

public class Rectangle {
    /**
     * 직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 
     * 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 
     * 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
     */
    public static void main(String[] args) {
        int[][] input = {{1,1},{2,2},{1,2}};
        int[] res = solution(input);
        System.out.println("x : "+res[0] + " y : " + res[1]);
    }
    //2차원 배열의 구조를 생각하면 충분히 if문으로만으로도 풀수 있다.
    //xor을 사용해서 간단하게 구현하는 방법도 있다!
    public static int[] solution(int[][] arr){
        int[] answer = new int[2];
        
        if(arr[0][0] == arr[1][0]){
            answer[0] = arr[2][0];
        }else if(arr[0][0] == arr[2][0]){
            answer[0] = arr[1][0];
        }else{
            answer[0] = arr[0][0];
        }

        if(arr[0][1] == arr[1][1]){
            answer[1] = arr[2][1];
        }else if(arr[0][1] == arr[2][1]){
            answer[1] = arr[1][1];
        }else{
            answer[1] = arr[0][1];
        }
        return answer;
    }
    
}
