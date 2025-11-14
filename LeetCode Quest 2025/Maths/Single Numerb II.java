class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int x : nums) {
            ones = (ones ^ x) & ~twos;
            twos = (twos ^ x) & ~ones;
        }

        return ones;
    }
}
