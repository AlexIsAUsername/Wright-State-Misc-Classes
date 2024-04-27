public class SummingDigits{
    public static long sumDigits(long n){
        if (Long.valueOf(n).toString().length() == 1){
            return n;
        }
        Long a = sumDigits(n/10) + n%10;
        if (a.toString().length() > 1){
            return sumDigits(a/10) + a%10;
        }
        return a;
    }

    public static long sumDigits2(long n){
        if (Long.valueOf(n).toString().length() == 1){
            return n;
        }
        int total = 0;
        for (int i = 0; i < Long.valueOf(n).toString().length(); i++){
            total += Character.getNumericValue(Long.valueOf(n).toString().charAt(i));
        }
        return sumDigits2(total);
        
    }

    public static void main(String[] args){
        System.out.println(sumDigits2(999));
    }
}