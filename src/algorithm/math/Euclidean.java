package algorithm.math;

public class Euclidean {
    //유클리드 호제법
    private int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
}
