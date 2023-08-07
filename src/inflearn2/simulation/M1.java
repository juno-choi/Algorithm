package inflearn2.simulation;

public class M1 {
    public static void main(String[] args) {
        int n = 5;
        int[][] array = {{1,3},{2,4},{1,4}};
        char[] solution = solution(n, array);
        for(char c : solution){
            System.out.println(c);
        }
    }
    public static char[] solution(int n, int[][] array){
        // 배열을 만들기
        char[] answer = new char[n];

        for(int i=0; i<n; i++){
            answer[i] = (char) ('A'+i);
        }

        // 배열에 따라 값 스위칭
        for(int i=0; i<array.length; i++){
            int[] arr = array[i];

            for(int j=0; j<arr.length; j++){
                int su = arr[j];

                char temp;
                char c1 = answer[su-1];
                char c2 = answer[su];
                temp = c1;
                c1 = c2;
                c2 = temp;
                answer[su-1] = c1;
                answer[su] = c2;
            }
        }

        return answer;
    }
}
