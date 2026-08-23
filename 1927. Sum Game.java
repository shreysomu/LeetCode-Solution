class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;

        //count ?
        // leftQ  = number of '?' on left
        // rightQ = number of '?' on right

        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        int sumDiff = leftSum - rightSum;
        int diffQ = leftQ - rightQ;

        // Odd difference in '?' count:
        // Alice can always force a win.
        if (Math.abs(diffQ) % 2 == 1) {
            return true;
        }

        // Equal number of '?'
        if (diffQ == 0) {
            return sumDiff != 0;
        }

        // Bob can force equality only in this case.
        return sumDiff + (diffQ / 2) * 9 != 0;
    }
}
