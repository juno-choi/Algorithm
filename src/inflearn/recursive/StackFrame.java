package inflearn.recursive;

/**
 * 재귀 함수 DFS 구현과 Stack Frame 이해
 */
public class StackFrame {
    public static void main(String[] args) {
        DFS(3);
    }
    public static void DFS(int n){
        if(n == 0) return;
        DFS(n-1);
        System.out.println(n);
    }
}
