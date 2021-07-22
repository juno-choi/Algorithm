package programmers;

public class PrimeNumberSearch {
    public static void main(String[] args) {
        PrimeNumberSearch t = new PrimeNumberSearch();
        int n = 10;
        int solution = t.solution(n);
        System.out.println("solution = " + solution);
    }
    public int solution(int n) {
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
}
