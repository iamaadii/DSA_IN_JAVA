/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.
*/
package Recursion.GetStrongHold;

public class StringToInteger {
    static int optimal(String s) {
        int res = 0;
        int sign = 1;
        int i=0;
        while(i<s.length() && s.charAt(i)==' '){
            i+=1;
        }
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i+=1;
        }

        while(i<s.length()){
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                break;
            }
            else{
                if(res > Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && c-'0' > 7)){
                    if(sign==1){
                        return Integer.MAX_VALUE;
                    }
                    else{
                        return Integer.MIN_VALUE;
                    }
                }
                res = res*10 + c-'0';
            }
            i+=1;
        }
        return res*sign;
    }

    public static void main(String[] args) {
        System.out.println(optimal("  -875sdjm54"));
    }
}
