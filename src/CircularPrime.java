public class CircularPrime {

    public static boolean isPrime(int number) {

        if (number < 2) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {

            if (number % i == 0) {

                return false;
            }
        }

        return true;
    }


    public static int numberRotate(int number) {

        int lastDigit = number % 10;
        number = number / 10;
        int temp = 1;

        while (number / temp != 0)
            temp *= 10;

        return number + lastDigit * temp;
    }

    public static boolean isNumberCircularPrime(int number) {

            int x = number;

            while (isPrime(x) && ((x = numberRotate(x)) != number)) ;

            if (number == x && isPrime(number)) {

                return true;
            }

            else {

                return false;
            }
    }

    public static int findCircularPrimeInRange(int range) {

        int count = 0;

        for (int i = 2; i < range; i++) {

            if (isNumberCircularPrime(i))
                count++;
        }

        return count;
    }




    public static void main(String[] args) {

        int range = 1_000_000;

        System.out.println("There are " + CircularPrime.findCircularPrimeInRange(range) + " circular primes below " + range);

    }
}
