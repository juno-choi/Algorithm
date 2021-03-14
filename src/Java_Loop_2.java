
import java.util.*;

public class Java_Loop_2{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            make_answer(a,b,n);
        }
        in.close();
    }

    private static void make_answer(int a, int b, int n){
        int answser = a + (int)Math.pow(2, 0) * b;
        System.out.print(answser);
        for(int i= 1; i<n; i++){
            answser += (int)Math.pow(2, i) * b;
            System.out.print(" "+answser);
        }
        System.out.println();
    }
}

