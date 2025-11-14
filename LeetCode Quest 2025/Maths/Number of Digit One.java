class Solution {
    public int countDigitOne(int n) {
        long pos = 1;
        int count = 0;

        while (pos <= n) {
            long high = n / (pos * 10);
            long curr = (n / pos) % 10;
            long low = n % pos;

            if (curr == 0) {
                count += high * pos;
            } else if (curr == 1) {
                count += high * pos + (low + 1);
            } else {
                count += (high + 1) * pos;
            }

            pos *= 10;
        }

        return count;
    }
}
