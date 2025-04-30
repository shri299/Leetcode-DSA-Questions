class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Set<Character> window = new HashSet<>();
        // int left = 0, right = 0;
        // int maxLength = 0;

        // while (right < s.length()) {
        //     if (!window.contains(s.charAt(right))) {
        //         window.add(s.charAt(right));
        //         maxLength = Math.max(maxLength, right - left + 1);
        //         right++;
        //     } else {
        //         window.remove(s.charAt(left));
        //         left++;
        //     }
        // }

        // return maxLength;

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (window.containsKey(c)) {
                if(window.get(c)>=left){
                    left = Math.max(left, window.get(c) + 1);
                }
            }

            window.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;

    }
}