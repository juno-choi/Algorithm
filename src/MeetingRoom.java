import java.util.Arrays;
import java.util.Comparator;

class Interval{
    int start;
    int end;

    Interval(){
        this.start = 0;
        this.end = 0;
    }
    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}
public class MeetingRoom{
    public static void main(String []argh)
    {
        MeetingRoom a = new MeetingRoom();
        //Interval in1 = new Interval(15, 20);
        //Interval in2 = new Interval(5, 10);
        //Interval in3 = new Interval(0, 30);

        Interval inter1 = new Interval(7,10);
        Interval inter2 = new Interval(2,4);
        Interval[] intervals = {inter1, inter2};
        System.out.println(a.solution(intervals));
    }
    public boolean solution(Interval[] intervals){
        //null check
        if(intervals == null){
            return false;
        }
        print(intervals);
        //정렬
        Arrays.sort(intervals, comp);
        System.out.println("------------");
        print(intervals);
        //여기서 부터 비교
        //앞의 end과 현재 start을 비교해서
        for(int i=1; i<intervals.length; i++){
            if(intervals[i-1].end > intervals[i].start){
                return false;
            }
        }
        return true;
    
    }
    Comparator<Interval> comp = new Comparator<Interval>(){
        @Override
        public int compare(Interval o1, Interval o2){
            return o1.start - o2.start;
        }
    };

    public void print(Interval[] intervals){
        for(Interval v : intervals){
            System.out.println(v.start + " "+ v.end);
        }
    }
}



