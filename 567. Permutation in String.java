class Solution {

    static boolean compareFreq(int[] count1, int[] count2) {
         for (int i = 0; i < 26; i++) {
             if (count1[i] != count2[i]){
                 return false;
            }
        }
         return true;
    }     
    public boolean checkInclusion(String s1, String s2) {
        
        // basic check - > whether characters of s1 are present in s2 or not
        //table of s1
        
        if (s1.length() > s2.length()){
            return false;
        }

        //s1 ka freq table
        int[] count1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int index = ch - 'a';
            count1[index]++;
        }
        
        int j = 0;
        int windowLength = s1.length();
        int[] count2 = new int[26];

        //first window ka freq table
        for ( j = 0; j < windowLength; j++) {
            char ch = s2.charAt(j);
            int index = ch - 'a';
            count2[index]++;
        }

        if (compareFreq(count1, count2)){
            return true;
        }
        else {
            while (j < s2.length()){
                char newChar = s2.charAt(j);
                int newCharIndex = newChar - 'a';
                count2[newCharIndex]++;

                int oldCharIndex = j - windowLength;
                char oldChar = s2.charAt(oldCharIndex);
                int freqTableIndexOfOlChar = oldChar - 'a';

                count2[freqTableIndexOfOlChar]--;

                if (compareFreq(count1,count2))
                    return true;
                j++;
            }
        }
        return false;
    }
}
