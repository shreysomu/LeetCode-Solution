class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        //sliding window //Two pointer

        int l = 0;
        int ones = 0;

        String res = "";

        for(int r = 0 ;r < s.length(); r++){


            //Adding current character
            if(s.charAt(r) == '1'){
                ones++;
            }

            //if we are having more than k ones 
            //will move left pointer

            while(ones > k){
                if(s.charAt(l) == '1'){
                    ones--;
                }

                l++;
            }

            //removing not needed leading zeroes
            while(ones == k && s.charAt(l)=='0'){
                l++;
            }


            //having exactly k ones
            if(ones == k){
                String currentStr = s.substring(l,r+1);

                //First beautiful substring
                if(res.equals("")) {
                    res = currentStr;
                }

                else if (currentStr.length() < res.length()){
                    res = currentStr;
                }

                //same length then we need to 
                //select lexicographicaly smaller one

                else if(currentStr.length() == res.length() && currentStr.compareTo(res) < 0){
                    res = currentStr;
                }
            }
        }

        return res;
    }
}
