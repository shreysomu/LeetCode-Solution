class Solution {
    public String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder();

        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);

            if(res.length() > 0 && res.charAt(res.length()-1) == ch){
                res.deleteCharAt(res.length() - 1);
            }
            else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}
