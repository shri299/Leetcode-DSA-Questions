class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(slow!=1 && fast!=1){
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
            if(slow==1 && fast==1){
                return true;
            }
            if(slow==fast){
                return false;
            }
        }
        return true;

    }

    private int findSquare(int n){
        int ans = 0;
        while(n>0){
            int rem = n % 10;
            ans += rem*rem;
            n = n/10;
        }
        return ans;
    }
}