
public class StringToLong {
    /**
     * This code assumes that the input code point is in Hindu-Arabic numerals (the most common numeric symbols in the world).
     * Numeric determination outside this range would require determining the codepoint of a character and looking up valid
     * numerals in that range (so, for example, Japanese numerals are out). This algorithm will reject decimals as that
     * opens up rounding considerations that should be user specified and can't be expressed with a long.
     * @param num the string in the Latin-1 range
     * @return a 64 bit signed integer value
     */
    public static long convert(String num) {
        num = num.trim();
        long multiplier = 1;
        char sign = num.charAt(0);
        if (sign == '-') {
            multiplier = -1;
            num = num.substring(1);
        }
        return multiplier * compute(num, multiplier == 1 ? Long.MAX_VALUE : Long.MIN_VALUE);

    }

    /**
     * requirements said not to use existing java libraries so we define our own digit check
     * @param c the character to test
     * @return true if it represents a latin-1 number
     */
    private static boolean isNum(char c) {
        return c >= 0x30 && c <= 0x39;
    }

    /**
     * this actually takes the string and converts it to a number
     * @param s the string to "translate"
     * @param limit the upperbound. Note: always represented positive
     * @return the conversion if possible
     */
    private static long compute(String s,long limit) {
        int result = 0;
        int count = s.length();

        for (char c : s.toCharArray()) {
            if (isNum(c)) {

                int digit = (c & 0x0f);
                // 987: 9 become 900, 8 becomes 80
                int powerUp = pow(10, count--);
                digit *= powerUp;
                if (limit - result - digit < 0) {
                    throw new IllegalArgumentException(s + " is to large to be supported by a long value (Overflow)");
                }
                result += digit;

            }
            else
                throw new NumberFormatException(c + " is not a valid Latin-1 numeric character");

        }
        return result;
    }

    /**
     * a Simple implentation of power operation. Instructions said not to use java libraries.
     * power of zero = 1
     * @param n the number to raise
     * @param m ... to the power of
     * @return n^m
     */
    private static int pow(int n,int m) {
        int result = 1;
        if(m == 0)
            result = 1;
        else {
            for(int i = 1; i < m; i++)
                result *= n;
        }
        return result;
    }
}
