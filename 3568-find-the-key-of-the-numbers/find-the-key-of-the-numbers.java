class Solution {

    public int generateKey(int num1, int num2, int num3) {
        // Convert the numbers to strings, padded with leading zeros to ensure they are 4 digits
        String str1 = String.format("%04d", num1);
        String str2 = String.format("%04d", num2);
        String str3 = String.format("%04d", num3);
        
        // Initialize a StringBuilder to store the key
        StringBuilder key = new StringBuilder();
        
        // Iterate over the digits
        for (int i = 0; i < 4; i++) {
            // Get the ith digit from each number
            int digit1 = str1.charAt(i) - '0';
            int digit2 = str2.charAt(i) - '0';
            int digit3 = str3.charAt(i) - '0';
            
            // Find the minimum of the three digits
            int minDigit = Math.min(digit1, Math.min(digit2, digit3));
            
            // Append the minimum digit to the key
            key.append(minDigit);
        }
        
        // Convert the key to an integer to remove any leading zeros
        return Integer.parseInt(key.toString());
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        System.out.println(solution.generateKey(1, 10, 1000)); // Output: 0
        System.out.println(solution.generateKey(987, 879, 798)); // Output: 777
        System.out.println(solution.generateKey(1, 2, 3)); // Output: 1
    }
}