import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1712 {
    /**
     * 월드전자는 노트북을 제조하고 판매하는 회사이다. 노트북 판매 대수에 상관없이 매년 임대료, 재산세, 보험료, 급여 등 A만원의 고정 비용이 들며, 한 대의 노트북을 생산하는 데에는 재료비와 인건비 등 총 B만원의 가변 비용이 든다고 한다.
     * 예를 들어 A=1,000, B=70이라고 하자. 이 경우 노트북을 한 대 생산하는 데는 총 1,070만원이 들며, 열 대 생산하는 데는 총 1,700만원이 든다.
     * 노트북 가격이 C만원으로 책정되었다고 한다. 일반적으로 생산 대수를 늘려 가다 보면 어느 순간 총 수입(판매비용)이 총 비용(=고정비용+가변비용)보다 많아지게 된다. 최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점(BREAK-EVEN POINT)이라고 한다.
     * A, B, C가 주어졌을 때, 손익분기점을 구하는 프로그램을 작성하시오.
     */
    public static void main(String[] args) throws Exception{
        /**
         * input = 1000 70 170
         * a = 1000 - 고정 비용
         * b = 70 - 한대당 추가되는 비용
         * c = 170 - 판매가격
         */ 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine().trim();

        sb.append(solve(input));
        System.out.print(sb);
    }
    public static Long solve(String str){
        String[] inputArr = str.split(" ");
        Long a = Long.parseLong(inputArr[0]);
        Long b = Long.parseLong(inputArr[1]);
        Long c = Long.parseLong(inputArr[2]);
        
        if(b>=c){
            return -1L;
        }
        // structure
        // n개의 상품을 판매했을때 a+(b*n) < c*n 커질때의 n의 값
        // 앞 1번과 2번의 크기 차이가 많이 날때는... 어떻게 좁힐까
        // 1000 + 70*1 = 1070
        // 170 * 1 = 170
        // for while
        /*
        Long n=1L;
        boolean flag = true;
        while(flag){
            if(a+(b*n)<(c*n)) return n;
            else n++;
        } 
        */
        return a/(c-b)+1;

    }
}
