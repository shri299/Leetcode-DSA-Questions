public class Solution {

    public String stringHash(String s, int k) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        // Iterate through each k-length substring
        for (int i = 0; i < n; i += k) {
            String substring = s.substring(i, i + k);
            int sum = 0;

            // Calculate the sum of hash values for the substring
            for (char c : substring.toCharArray()) {
                sum += c - 'a';
            }

            // Find the hashed character
            int hashedChar = sum % 26;
            result.append((char) (hashedChar + 'a'));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "abcd";
        int k1 = 2;
        System.out.println(solution.stringHash(s1, k1)); // Output: "bf"

        // Example 2
        String s2 = "mxz";
        int k2 = 3;
        System.out.println(solution.stringHash(s2, k2)); // Output: "i"
    }
}