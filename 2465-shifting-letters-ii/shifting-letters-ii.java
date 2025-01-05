class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] values = new int[s.length()+1];

        for(int[] it : shifts){
            int shift = (it[2] == 1) ? 1 : -1;
            values[it[0]] += shift;
            values[it[1]+1] += (shift*-1);
        }

        for(int i = 1;i < values.length;i++){
            values[i] += values[i-1];
        }

        StringBuilder ans = new StringBuilder();

        for(int i = 0;i < s.length();i++){
            int shift = ((values[i] % 26) + 26) % 26;

            char ele = (char) ((shift + (s.charAt(i)-'a')) % 26 + 'a');;

            ans.append(ele);
        }

        return ans.toString();
    }
}