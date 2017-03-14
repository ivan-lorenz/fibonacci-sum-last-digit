import java.util.*;

public class FibonacciSumLastDigit {
    public static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    public static long getFibonacciSumFast(long n) {
        if (n <= 1)
            return n;

        List<Integer> pisanoPeriod = getPisanoPeriodMod10();
        int periodSize = pisanoPeriod.size();
        long remainder = n % periodSize;

        long result = pisanoPeriod.stream().limit(remainder+1).reduce(0, (a,b) -> a + b);

        return result % 10;
    }

    public static List<Integer> getPisanoPeriodMod10() {

        ArrayList<Integer> F = new ArrayList<>();
        F.add(0);
        F.add(1);
        F.add(1);
        F.add(2);

        int i = 4;
        while(true) {
            if (F.get(i-2) == 0 && F.get(i-1) == 1)
                return F.subList(0,i-2);
            F.add((F.get(i-1) + F.get(i-2)) % 10);
            i++;
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}

