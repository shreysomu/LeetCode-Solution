class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int totalOnes = 0;

        int prevZero = Integer.MIN_VALUE;
        int maxNumberOfActiveSession = 0;

        int i = 0;

        while(i<n){
            int j = i;
            while(j<n && s.charAt(j) == s.charAt(i)){
                j++;
            }
           int n1 = j - i;
           if(s.charAt(i) == '1'){
            totalOnes += n1;
           }
           else{
            maxNumberOfActiveSession = Math.max(maxNumberOfActiveSession,prevZero + n1);
            prevZero = n1;
           }
           i = j;
        }

        return totalOnes + maxNumberOfActiveSession;
    }
}
