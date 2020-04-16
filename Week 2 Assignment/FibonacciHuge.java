import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHuge(long n, long m) {
        if (n <= 1) return n;
        
        long previous=0, current=1;
        List<Long> pisano = new ArrayList<Long>();
        pisano.add((long) 0); pisano.add((long) 1);
        for (int i = 1; i < n; ++i) {
            long temp = current;
            pisano.add(current = ((previous + current)%m));
            previous = temp;
            if(pisano.get(pisano.size()-2)==0 && pisano.get(pisano.size()-1)==1){
                int length = pisano.size()-2;
                return pisano.get((int) (n%length));
            }
        }
        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

