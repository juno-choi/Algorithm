public class Sum {
    /**
     * 각 자릿수의 합 구하기
     * 123 % 10 = 3
     * 123 / 10 = 12
     * 12 % 10 = 2
     * 1 % 10 = 1
     * 1 / 10 = 0
     * 
     * 1의 자리를 구합니다.
     * 1의 자리를 제고하고 나머지 숫자들을 오른쪽으로 한칸씩 이동시킵니다.
     * 더 이상 이동시킬 숫자가 없을때 까지 반복합니다.
     */
    public static void main(String[] args) {
        int n = solution(1234);
        System.out.println(n);
    }
    public static int solution(int n){
        int anwser = 0;

        //n이 0이될때까지 나눌거임
        while(n!=0){
            anwser += n%10;
            n = n/10;
        }
        return anwser;
    }
}
