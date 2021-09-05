package inflearn.recursive;

public class Fibonacci {
    public static void main(String[] args) {
        int dfs = DFS(7);
        System.out.println("dfs = " + dfs);

        int n= 45;
        fibo = new int[n+1]; //0번째 배열은 사용하지 않을 것이기 때문에 n+1
        DFS3(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i] + " ");

        System.out.println();

        int fibonacci = fibonacci(5);
        System.out.println("fibonacci = " + fibonacci);
    }

    public static int DFS(int n){
        if(n==1) return 1;
        else if(n==2) return 1;
        else return DFS(n-2)+DFS(n-1);
    }

    //만약 코딩 인터뷰에서 fibo의 내용을 출력해야할 경우 효율적인 코드로 짜는 방법
    static int[] fibo;
    public static int DFS2(int n){
        if(n==1) return fibo[1] = 1;
        else if(n==2) return fibo[2] = 1;
        else return fibo[n] = DFS2(n-2) + DFS2(n-1);
    }

    //메모이제이션을 활용하면 더 빨리 결과를 낼수 있다.
    public static int DFS3(int n){
        if(fibo[n] != 0) return fibo[n];
        if(n==1) return fibo[1] = 1;
        else if(n==2) return fibo[2] = 1;
        else return fibo[n] = DFS3(n-2) + DFS3(n-1);
    }

    public static int fibonacci(int n){
        if(n < 2) return 1;
        int result = 0;
        int n1 = 0;
        int n2 = 1;

        for(int i=2; i<=n; i++){
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
