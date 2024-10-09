class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gLen = g.length;
        int sLen = s.length;

        Arrays.sort(s);
        Arrays.sort(g);

        int left = 0;
        int right = 0;

        while(right<gLen && left<sLen){
            if(g[right]<=s[left]){
                right++;
            }

            left++;
        }

        return right;
    }
}