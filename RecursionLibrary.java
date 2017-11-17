public class RecursionLibrary {

  public static int greatestCommonDivisor(int a, int b) {
    // this function uses Euclid's algorithm to compute the gcd of 2 positive integers
    // this can also be written using Math.abs and % and
    // in this case we wouldn't need the assertion that both inputs are positive
    assert (a > 0 && b > 0) : "both a and be must be positive";
    if (a == b) {
      return a;
    } else if (a > b) {
      return greatestCommonDivisor(b, a - b);
    } else {
      return greatestCommonDivisor(a, b - a);
    }
  }


  public static boolean isPrime(int n) {
    // This method tests an input to see if it is prime or not.
    // we must use an assertion here to take into account negative inputs
    assert n > 0 :
        "n must be a non-negative integer";
    if (n < 2) {
      return false;
    } else {
      return primeTest(n, (int) Math.sqrt(n));
    }
  }

  private static boolean primeTest(int n, int k) {
    // this method is the helper to isPrime,where the recursion happens
    // it tests whether the number is prime by comparing it
    // through 1 to the square root of the number.
    if (k == 1) {
      return true;
    } else if (n % k == 0) {
      return false;
    } else {
      return primeTest(n, k - 1);
    }
  }

  public static int sumSquareDigits(int n) {
    // this method simply does as it's name suggests. however when creating tests
    // I noticed that there was a problem with negative inputs
    // (e.g sumSquareDigits(-103) returns 10609 which is incorrect so I had to add an assertion
    assert (n >= 0) : "n must be greater than or equal to 0!";
    if (n < 10) {
      return (int) Math.pow(n, 2);
    } else {
      return sumSquareDigits(n / 10) + (int) Math.pow((n % 10), 2);
    }
  }

  public static boolean isHappy(int n) {
    // similarly to isPrime, the recursion in this method happens in the helper method
    // but there are two different recursive calls this time.
    // unsure whether assertion is required here as I don't believe there are negative
    // happy numbers
    int r = 0;
    int t = 0;
    int nt = 0;
    return happyCounter(n, r, t, nt);
  }

  private static boolean happyCounter(int n, int r, int t, int nt) {
    // numbers that aren't happy numbers loop around 4 for some reason, and also
    // the numbers that are happy follow a sequence of all being happy numbers,
    // this result follows for unhappy numbers as well.
    if (n == 1) {
      return true;
    } else if (n == r) {
      return false;
    } else if (t > 0) {
      return happyCounter(sumSquareDigits(n), r, --t, nt);
    } else if (t == 0) {
      return happyCounter(sumSquareDigits(n), n, nt, ++nt);
    }

    return false;
  }
}
