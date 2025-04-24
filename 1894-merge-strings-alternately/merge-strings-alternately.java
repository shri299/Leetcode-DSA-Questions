class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            str.append(word1.charAt(i)).append(word2.charAt(i));
            i++;
        }

        if (i < word1.length()) {
            for (int j = i; j < word1.length(); j++) {
                str.append(word1.charAt(j));
            }
        }

        if (i < word2.length()) {
            for (int j = i; j < word2.length(); j++) {
                str.append(word2.charAt(j));
            }
        }

        return str.toString();
    }
}