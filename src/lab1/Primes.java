package lab1;

public class Primes {
    public static void main(String[] args) {
        for (int n=2; n<=100; n++){
            if (isPrime(n))
                System.out.print(n+ ",");
        }
    }
    public static boolean isPrime(int n) {
        for (int a=2; a<n; a++) {
            if (n % a == 0)
                return false;
        }
        return true;

    }
}
