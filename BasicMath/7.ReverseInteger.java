//space=O(1)
//time =  O(d) d is the number of digits 

class Solution {
    public int reverse(int x) {
        // Initialize a long variable 'reverse' to store the reversed number.
        // Using long to handle overflow cases temporarily.
        long reverse = 0;
        
        // Initialize an int variable 'temp' to store the remainder when x is divided by 10.
        int temp;

        // Loop until x becomes 0.
        // This loop extracts each digit from x and adds it to 'reverse' in the reverse order.
        while (x != 0) {
            // Get the last digit of x.
            // For example, if x is 123, then 123 % 10 gives 3.
            temp = x % 10;

            // Append the digit to 'reverse'.
            // For example, if reverse is 12 and temp is 3, then reverse * 10 + temp gives 123.
            reverse = reverse * 10 + temp;

            // Remove the last digit from x.
            // For example, if x is 123, then 123 / 10 gives 12.
            x = x / 10;

            // Check if 'reverse' is outside the range of a 32-bit signed integer.
            // If it is, return 0 because the reversed number would overflow.
            if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
                return 0;
            }
        }

        // Return the reversed number as an int.
        // Casting to int is safe here because we already checked for overflow.
        return (int) reverse;
    }
}
