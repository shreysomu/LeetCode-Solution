class Solution {


    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // pal[i][j] = true if s.substring(i, j + 1) is palindrome
        boolean[][] pal = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    // Length 1 or 2
                    if (j - i <= 1) {
                        pal[i][j] = true;
                    } 
                    // Length > 2
                    else {
                        pal[i][j] = pal[i + 1][j - 1];
                    }
                }
            }
        }

        // dp[i] = maximum number of non-overlapping
        // palindromes using first i characters
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {

            // Option 1: Skip current character
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // Option 2: Take a palindrome starting at i
            for (int j = i + k - 1; j < n; j++) {

                if (pal[i][j]) {

                    dp[j + 1] = Math.max(
                        dp[j + 1],
                        dp[i] + 1
                    );
                }
            }
        }

        return dp[n];
    }
}

    
