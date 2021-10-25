package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ssireum {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        ArrayList<Body> list = new ArrayList<>();
        for(int i=0; i<input1; i++){
            Body body = new Body(in.nextInt(), in.nextInt());
            list.add(body);
        }
        Collections.sort(list);
        int result = solution(list);
        System.out.println(result);
    }

    private static int solution(ArrayList<Body> list) {
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(Body b : list){
            if(b.kg > max){
                max = b.kg;
                cnt++;
            }
        }
        return cnt;
    }

    static class Body implements Comparable<Body>{
        public int cm;
        public int kg;

        public Body(int cm, int kg) {
            this.cm = cm;
            this.kg = kg;
        }

        @Override
        public int compareTo(Body o) {
            return o.cm - this.cm;
        }
    }
}
