class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();

        for (int n = left; n <= right; n++) {
            if (isSelfDividing(n)) {
                res.add(n);
            }
        }

        return res;
    }

    private boolean isSelfDividing(int n) {
        int x = n;
        while (x > 0) {
            int d = x % 10;
            if (d == 0 || n % d != 0) return false;
            x /= 10;
        }
        return true;
    }
}
