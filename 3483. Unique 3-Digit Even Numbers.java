class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        // Count frequency of each digit
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        for (int i = 100; i <= 999; i += 2) {
            int num = i;
            int ones = num % 10;
            num /= 10;
            
            int tens = num % 10;
            num /= 10;

            int hundreds = num % 10;

            int[] used = new int[10];
            used[hundreds]++;
            used[tens]++;
            used[ones]++;

            boolean possible = true;

            for (int d = 0; d <= 9; d++) {
                if (used[d] > freq[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}
