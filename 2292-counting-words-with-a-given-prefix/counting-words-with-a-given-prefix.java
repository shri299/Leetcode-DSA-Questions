class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for (String word : words) {
            int i = 0, j = 0;
            while (i < word.length() && j < pref.length()) {
                if (word.charAt(i) == pref.charAt(j)) {
                    i++;
                    j++;
                } else break;
            }
            if (j == pref.length()) cnt++;
        }
        return cnt;
    }
}