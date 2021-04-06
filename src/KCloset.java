import java.util.PriorityQueue;
import java.util.Queue;

public class KCloset {
    public static void main(String[] args) {
        KCloset kCloset = new KCloset();
        int[][] points = {{1,3},{-2,2}};
        System.out.println("=");
        int k=1;

        int[][] result = kCloset.solve(points, k);
        System.out.println(result[0][0]+ ", " +result[0][1]);
    }

    /**
     * 원점으로부터의 거리를 구한다.
     * ex) -2,2 = 거리는 8
     * 원점으로 부터 거리를 구하는 공식
     * (x2-x1)^2 + (y2-y1)^2
     * (0-(-2))^2 + (0-2)^2 = 8
     *
     * 원점에서 제일 작은 거리에 있는 값을 구한다
     * PriorityQueue를 사용한다.
     *
     * Priority Queue
     * 1. 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조
     * 2. 큐에 들어가는 원소 비교 기준 필요
     * 3. 이진트리 구조, 시간 복잡도 O(NlogN)
     *
     * minHeap 구조로 priority queue를 만든다.
     */
    public int[][] solve(int[][] points, int k){
        //1. data structure
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]*a[0]+a[1]+a[1])-(b[0]*b[0]+b[1]*b[1]));
        int[][] result = new int[k][2];

        //2. for, while
        for(int[] p : points){
            pq.offer(p);
        }
        int index = 0;
        while(index<k){
            result[index] = pq.poll();
            index++;
        }

        return result;
    }

}
