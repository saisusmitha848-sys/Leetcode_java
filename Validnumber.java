class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        boolean digitAfterExponent = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Digit
            if (Character.isDigit(c)) {
                seenDigit = true;

                // If we're after e/E, we need at least one digit there
                if (seenExponent) {
                    digitAfterExponent = true;
                }
            }

            // Decimal point
            else if (c == '.') {
                // Dot is not allowed after an exponent
                // and only one dot is allowed
                if (seenDot || seenExponent) {
                    return false;
                }

                seenDot = true;
            }

            // Exponent
            else if (c == 'e' || c == 'E') {
                // Exponent:
                // 1. Cannot appear twice
                // 2. Must have a number before it
                if (seenExponent || !seenDigit) {
                    return false;
                }

                seenExponent = true;

                // We haven't seen a digit after e yet
                digitAfterExponent = false;
            }

            // Sign
            else if (c == '+' || c == '-') {
                // Sign is valid only at the beginning
                // or immediately after e/E
                if (i != 0 && s.charAt(i - 1) != 'e'
                           && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Any other character is invalid
            else {
                return false;
            }
        }

        // Must contain at least one digit
        // and if exponent exists, it must have a digit after it
        return seenDigit && digitAfterExponent;
    }
}