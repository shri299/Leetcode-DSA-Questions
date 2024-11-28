class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(" ") || s.length()==1){
            return 1;
        }
        int maxLength = 0;
        String str = "";
        List<Character> list = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(list.contains(s.charAt(j))){
                    //encounterd a repeated chanrecter
                    maxLength = Math.max(maxLength,list.size());
                    list.clear();
                    break;
                }else{
                    list.add(s.charAt(j));
                }
            }
        }

        return maxLength;
    }
}