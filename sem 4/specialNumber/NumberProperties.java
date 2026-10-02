package specialNumber;

public class NumberProperties {

    // Helper method: Calculates powers purely using integers and loops (replaces Math.pow)
    private static long power(long base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

  f  // Helper method: Used specifically for the Happy Number algorithm
    private static int sumOfSquareOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    // Buzz Number: A number that either ends in 7 or is evenly divisible by 7.
    // (Example: 14 is divisible by 7; 27 ends in 7)
    public static boolean isBuzzNumber(int n) {
        return (n % 10 == 7) || (n % 7 == 0);
    }

    // Duck Number: A positive number that contains at least one '0'.
    // (Note: In pure int operations, an integer cannot "start" with 0 unless it is exactly 0)
    // (Example: 305)
    public static boolean isDuckNumber(int n) {
        if (n == 0) return false; 
        int temp = n;
        while (temp > 0) {
            if (temp % 10 == 0) return true;
            temp /= 10;
        }
        return false;
    }

    // Neon Number: A number where the sum of the digits of its square equals the original number.
    // (Example: 9. 9² = 81, and 8 + 1 = 9)
    public static boolean isNeonNumber(int n) {
        int square = n * n;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == n;
    }

    // Spy Number: A number where the sum of its digits is exactly equal to the product of its digits.
    // (Example: 1124. 1+1+2+4 = 8, and 1×1×2×4 = 8)
    public static boolean isSpyNumber(int n) {
        int sum = 0, product = 1;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return sum == product;
    }

    // Palindrome Number: A number that reads the exact same forwards and backwards.
    // (Example: 1221)
    public static boolean isPalindromeNumber(int n) {
        int original = n, reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }
        return original == reversed;
    }

    // Unique Number: A number where no digits repeat; every digit appears exactly once.
    // (Example: 1459)
    public static boolean isUniqueNumber(int n) {
        boolean[] seen = new boolean[10];
        while (n > 0) {
            int digit = n % 10;
            if (seen[digit]) return false;
            seen[digit] = true;
            n /= 10;
        }
        return true;
    }

    // Magic Number: A number where, if you repeatedly add its digits together, it eventually shrinks down to exactly 1.
    // (Example: 19. 1+9 = 10 -> 1+0 = 1)
    public static boolean isMagicNumber(int n) {
        while (n > 9) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    // Pronic (or Heteromecic) Number: A number that is the product of two consecutive integers.
    // (Example: 12, because 3 × 4 = 12)
    public static boolean isPronicNumber(int n) {
        for (int i = 0; i * (i + 1) <= n; i++) {
            if (i * (i + 1) == n) return true;
        }
        return false;
    }

    // Harshad (or Niven) Number: A number that is perfectly divisible by the sum of its own digits.
    // (Example: 18. 1+8 = 9, and 18 ÷ 9 = 2)
    public static boolean isHarshadNumber(int n) {
        if (n == 0) return false;
        int sum = 0, temp = n;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return n % sum == 0;
    }

    // Armstrong (or Narcissistic) Number: A number that equals the sum of its digits, each raised to the power of the total number of digits.
    // (Example: 153 is 3 digits. 1³ + 5³ + 3³ = 153)
    public static boolean isArmstrongNumber(int n) {
        int temp = n, digits = 0, sum = 0;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        temp = n;
        while (temp > 0) {
            sum += (int) power(temp % 10, digits);
            temp /= 10;
        }
        return sum == n;
    }

    // Prime Number: A number greater than 1 that can only be divided cleanly by 1 and itself.
    // (Example: 7)
    public static boolean isPrimeNumber(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Perfect Number: A number where the sum of all its positive divisors (excluding itself) perfectly equals the number.
    // (Example: 6. Divisors are 1, 2, 3. 1+2+3 = 6)
    public static boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    // Abundant Number: A number where the sum of its proper divisors is greater than the number itself.
    // (Example: 12. Divisors 1+2+3+4+6 = 16, which is > 12)
    public static boolean isAbundantNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum > n;
    }

    // Strong Number: A number where the sum of the factorials of its digits equals the original number.
    // (Example: 145. 1! + 4! + 5! = 1 + 24 + 120 = 145)
    public static boolean isStrongNumber(int n) {
        int sum = 0, temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            int fact = 1;
            for (int i = 1; i <= digit; i++) fact *= i;
            sum += fact;
            temp /= 10;
        }
        return sum == n;
    }

    // Disarium Number: A number where the sum of its digits, raised to the power of their specific positions (1st, 2nd, 3rd...), equals the number.
    // (Example: 135. 1¹ + 3² + 5³ = 1 + 9 + 125 = 135)
    public static boolean isDisariumNumber(int n) {
        int temp = n, digits = 0;
        // Find total number of digits
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        
        temp = n;
        int sum = 0;
        // Work backwards, reducing the power 'digits' each time
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) power(digit, digits);
            digits--;
            temp /= 10;
        }
        return sum == n;
    }

    // Automorphic Number: A number whose square ends with the exact same digits as the number itself.
    // (Example: 25. 25² = 625)
    public static boolean isAutomorphicNumber(long n) {
        long square = n * n;
        long temp = n;
        long divider = 1;
        while (temp > 0) {
            divider *= 10;
            temp /= 10;
        }
        return (square % divider) == n;
    }

    // Happy Number: A number where, if you repeatedly replace it with the sum of the squares of its digits, it eventually reaches 1. 
    // This uses Floyd's Cycle-Finding Algorithm (Tortoise and Hare) to avoid using a HashSet.
    // (Example: 13 -> 1² + 3² = 10 -> 1² + 0² = 1)
    public static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = sumOfSquareOfDigits(slow);
            fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast));
        } while (slow != fast && fast != 1);
        
        return fast == 1;
    }

    // Emirp Number: "Prime" spelled backwards. It is a prime number that turns into a different prime number when its digits are reversed.
    // (Example: 13 is prime, and reversed is 31, which is also prime)
    public static boolean isEmirpNumber(int n) {
        if (!isPrimeNumber(n)) return false;
        int reversed = 0, temp = n;
        while (temp > 0) {
            reversed = reversed * 10 + (temp % 10);
            temp /= 10;
        }
        return n != reversed && isPrimeNumber(reversed);
    }

    // Circular Prime: A prime number that remains prime no matter how many times you cyclically rotate its digits.
    // Uses integer division and modulo to shift the digits left.
    // (Example: 1193. 1931, 9311, and 3119 are all prime too)
    public static boolean isCircularPrime(int n) {
        if (!isPrimeNumber(n)) return false;
        
        int temp = n, digits = 0;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        
        int divisor = (int) power(10, digits - 1);
        int current = n;
        
        for (int i = 0; i < digits - 1; i++) {
            int firstDigit = current / divisor;
            int restOfNumber = current % divisor;
            current = (restOfNumber * 10) + firstDigit;
            
            if (!isPrimeNumber(current)) return false;
        }
        return true;
    }

    // Kaprekar Number: A number whose square can be split into two pieces that add back up to the original number.
    // Uses powers of 10 to mathematically "split" the integer.
    // (Example: 45. 45² = 2025. 20 + 25 = 45)
    public static boolean isKaprekarNumber(long n) {
        if (n == 1) return true;
        
        long square = n * n;
        long temp = square;
        int digitsInSquare = 0;
        
        while (temp > 0) {
            digitsInSquare++;
            temp /= 10;
        }
        
        for (int i = 1; i < digitsInSquare; i++) {
            long divisor = power(10, i);
            long rightPart = square % divisor;
            long leftPart = square / divisor;
            
            if (rightPart > 0 && leftPart + rightPart == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}