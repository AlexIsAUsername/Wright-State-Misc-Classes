public class PrimeThread extends Thread {
    private int start;
    private int end;
    private int primeCount = 0;

    public PrimeThread(int start, int end){
        this.start = start;
        this.end = end;
    }

    public static boolean isPrime(int n){
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i*i <= n; i += 6)
            if (n % i == 0 || n % (i+2) == 0)
                return false;
        return true;
    }

    public int getPrimeCount() {
        return primeCount;
    }

    @Override
    public void run(){
        for (int i = start; i < end; i++){
            if (isPrime(i) == true){
                primeCount++;
            }
        }
    }
}
