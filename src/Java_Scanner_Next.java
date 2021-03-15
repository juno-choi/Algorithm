
import java.util.*;

public class Java_Scanner_Next{

    /**
     * scanner hasNext를 사용하여 입력되는 n의 수를 출력하기
     */
    public static void main(String []argh)
    {
        Scanner sc=new Scanner(System.in);
        int su = 1;
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(su+". "+str);
            su++;
        }
    }
}

