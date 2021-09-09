package inflearn.tree;

/**
 * 입력된 값의 부분 집합을 출력하세요.
 */
public class SubSet {

    static int n;
    static int[] ch;

    public static void main(String[] args) {
        SubSet ss = new SubSet();
        n = 3;
        ch=new int[n+1];
        ss.DFS(1);
    }
    public void DFS(int l){
        if(l==n+1) {
            for(int i=1; i<=n; i++){
                if(ch[i] == 1) System.out.print(i+" ");
            }
            System.out.println();
        }
        else{
            ch[l]=1;    //1은 사용
            DFS(l+1);   //트리 왼쪽
            ch[l]=0;    //0은 사용하지 않는다.
            DFS(l+1);   //트리 오른쪽
        }
    }
}
