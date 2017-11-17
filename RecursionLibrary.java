public class RecursionLibrary {

  public static int greatestCommonDivisor(int a, int b) {
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
    assert n > 0 :
        "n must be a non-negative integer";
    if (n < 2) {
      return false;
    } else {
      return primeTest(n, (int) Math.sqrt(n));
    }
  }

  private static boolean primeTest(int n, int k) {
    if (k == 1) {
      return true;
    } else if (n % k == 0) {
      return false;
    } else {
      return primeTest(n, k - 1);
    }
  }

  public static int sumSquareDigits(int n) {
    int result = sumSquareDigits(n / 10) + Math.pow((n % 10), 2);
    return result;
  }

  public static boolean isHappy(int n) {
    // TODO: Implement this method
    return false;
  }
}
