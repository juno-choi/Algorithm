package inflearn.recursive;

/**
 * 2진수로 출력하기
 */
public class BinaryNumber {
    public static void main(String[] args) {
        DFS(11);
    }
    public static void DFS(int n){
        if(n==0) return;

        DFS(n/2);
        System.out.print(n%2);
    }
}
