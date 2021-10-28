package inflearn.greedy;

import java.util.*;

/**
 * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
 *
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
 *
 * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 *
 * 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
 */
public class MaximumSchedule {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        ArrayList<Schedule> list = new ArrayList<>();

        for(int i=0; i<input1; i++){
            Schedule s = new Schedule(in.nextInt(), in.nextInt());
            list.add(s);
        }

        Collections.sort(list);

        int result = solution(list);

        System.out.println(result);
    }

    private static int solution(ArrayList<Schedule> list) {
        int answer = 0;
        Queue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());

        int max = list.get(0).day;
        int j=0;
        for(int i=max; i>=1; i--){
            for(; j<list.size(); j++){
                if(list.get(j).day < i) break;
                que.offer(list.get(j).money);
            }
            if(!que.isEmpty()) answer += que.poll();
        }

        return answer;
    }

    public static class Schedule implements Comparable<Schedule>{
        int money;
        int day;

        public Schedule(int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Schedule o) {
            return o.day-this.day;
        }
    }
}
