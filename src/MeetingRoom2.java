import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2{
    public static void main(String []argh)
    {
        MeetingRoom2 a = new MeetingRoom2();
        Interval in3 = new Interval(0, 30);
        Interval in1 = new Interval(4, 9);
        Interval in4 = new Interval(10, 16);
        Interval in2 = new Interval(5, 15);

        Interval[] intervals = {in1, in2, in3, in4};
        System.out.println(a.solution(intervals));
    }
    public int solution(Interval[] intervals){

        if(intervals == null || intervals.length == 0){
            return 0;
        }

        //1. 시간을 기준으로 sorting
        Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);
        Queue<Interval> pq = new PriorityQueue<>((Interval a, Interval b) -> a.end - b.end);

        pq.offer(intervals[0]);

        //2. 기준이될 0번째 배열은 미리 넣어주고 1부터 for문을 돌린다.
        for(int i=1; i< intervals.length; i++){

            if(pq.peek().end <= intervals[i].start){
                pq.poll();
            }
            pq.offer(intervals[i]);
        }

        return pq.size();
    }
}



