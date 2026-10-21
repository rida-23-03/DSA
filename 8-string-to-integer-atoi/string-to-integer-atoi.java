class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        long r = 0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() &&
            (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';
            r = r * 10 + d;

            if (r * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (r * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(r * sign);
    }
}