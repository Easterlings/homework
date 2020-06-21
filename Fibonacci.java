
public class Fibonacci {

    public static long  of(long a){
        long a1 = 0;
        long a2 = 1;
        long sum = 0;
        if (a==1)
            return 1;

        for (int i=0;i<a-1;i++){
            sum = a1 + a2;
            a1 = a2;
            a2 = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        for(int i = 0; i < 200; i++)
            System.out.println(i+1 +":"+ of(i));
    }
}
