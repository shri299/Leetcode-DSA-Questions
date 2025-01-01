class Solution {
    public int maxScore(String s) {
        int intialRight = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                intialRight++;
            }
        }
        int ans = Integer.MIN_VALUE;
        int initalLeft = 0;

        for(int i=0;i<s.length()-1;i++){
            int target = s.charAt(i);
            if(target=='0'){
                initalLeft = initalLeft + 1;
                ans = Math.max(ans,initalLeft+intialRight);
            }else if(target=='1'){
                intialRight = intialRight-1;
                ans = Math.max(ans,initalLeft+intialRight);
            }
        }

        return ans;
    }
}