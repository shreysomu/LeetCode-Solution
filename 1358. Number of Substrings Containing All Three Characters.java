class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int left = 0;
      //  int right = 0;
        int count = 0;

        for(int i = 0; i < s.length();i++){
            freq[s.charAt(i) - 'a']++;

            while(freq[0] > 0 && freq[1] >0 && freq[2] > 0){
                count += s.length() - i;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
}
