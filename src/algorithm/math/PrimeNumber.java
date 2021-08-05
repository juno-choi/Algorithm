package algorithm.math;

//소수
public class PrimeNumber {
    /**
     * 에라토스테네스 체
     */
    public int isPirme(int n) {
        int answer = 0;
        //에라토스테네스 체
        boolean[] isPrime = new boolean[n+1];
        isPrime [0] = true; //true일 경우 소수가 아님
        isPrime [1] = true;

        for(int i=2; i<n; i++){
            for(int j=2; i*j<=n; j++){
                isPrime[i*j] = true;
            }
        }

        for(int i=1; i<=n; i++){
            if(!isPrime[i]) answer++;
        }
        return answer;
    }
    
    /**
     * 에라토스테네스 체 (가장 쉬운 버전)
     */
    public static void solution(int input){
        int[] arr = new int[input+1];   //배열을 검사할때 배열과 index값을 맞추기 위해
        int count = 0;
        for(int i=2; i<=input; i++){
            if(arr[i]==0){  //arr[i] == 0일 경우 해당 index는 소수이므로 카운트
                count++;
                for(int j=i; j<=input; j+=i){  //해당 수의 배수들은 모두 체크
                    arr[j] = 1;
                }
            }
        }
        System.out.println(count);
    }
}
