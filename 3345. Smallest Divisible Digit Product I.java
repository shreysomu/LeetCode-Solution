class Solution {

    private int productOfDigits(int num) {
        int product = 1;

        while (num > 0) {
            product *= (num % 10);
            num /= 10;
        }

        return product;
    }

    public int smallestNumber(int n, int t) {

        while (true) {

            if (productOfDigits(n) % t == 0) {
                return n;
            }

            n++;
        }
    }
}
