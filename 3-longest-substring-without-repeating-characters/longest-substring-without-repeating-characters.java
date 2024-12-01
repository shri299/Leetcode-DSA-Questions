class Solution {
    public int lengthOfLongestSubstring(String s) {

        ArrayList<Character> ans = new ArrayList<>();
        int max = 0;
        
        for (int i=0,j=0;i<s.length();) {

            if (!ans.contains(s.charAt(i))) {
                ans.add(s.charAt(i));
                max = Math.max(ans.size(),max);
                i++;
            } 
            else {
                ans.clear();
                i=j;
                j++;
            }
        }   
        return max;      
    }
}