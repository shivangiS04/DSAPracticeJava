class Solution {
    public String largestOddNumber(String num) {
        int len = num.length()-1;

        while(len>=0)
        {
            int d=num.charAt(len)-'0'; // Accessing character at index len
            if(d%2!=0)
                return num.substring(0, len+1);
            len--;
        }
        return ""; // Return an empty string instead of a single space
    }
}
