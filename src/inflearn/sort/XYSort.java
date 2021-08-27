package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
 *
 * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
 */
public class XYSort {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        Point[] arr = new Point[input1];
        Point2[] arr2 = new Point2[input1];
        for(int i=0; i<input1; i++){
            int su1 = in.nextInt();
            int su2 = in.nextInt();
            Point p = new Point(su1,su2);
            arr[i] = p;

            Point2 p2 = new Point2(su1, su2);
            arr2[i] = p2;
        }

        solution(arr);
        for (Point p : arr) {
            System.out.print(p.x+" "+p.y);
            System.out.println();
        }
        System.out.println("-------------------------");
        Arrays.sort(arr2);
        for (Point2 p : arr2) {
            System.out.print(p.x+" "+p.y);
            System.out.println();
        }
    }
    public static void solution(Point[] arr){
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.x == o2.x) return o1.y-o2.y;
            else return o1.x - o2.x;
        });
    }
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Point2 implements Comparable<Point2>{
        int x;
        int y;

        public Point2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point2 o) {
            if(this.x == o.x) return this.y - o.y;  //= o1.y - o2.y
            else return this.x - o.x;
        }
    }
}
