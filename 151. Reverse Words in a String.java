class Solution {
    public String reverseWords(String str) {
                StringBuilder res = new StringBuilder();
        int i = str.length()-1;

        while (i >= 0){
            while (i >= 0 && str.charAt(i) == ' '){
                i--;
            }

            if (i < 0){
                break;
            }

            int j = i;
            while (j >= 0 && str.charAt(j) != ' '){
                j--;
            }

            res.append(str, j+1, i+1);

            while (j >= 0 && str.charAt(j) == ' '){
                j--;
            }

            if (j >= 0){
                res.append(' ');
            }
            i = j;
        }
        return res.toString();
    }
}
