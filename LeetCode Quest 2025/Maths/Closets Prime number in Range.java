class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieve(right);

        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, left); i <= right; i++) {
            if (isPrime[i]) primes.add(i);
        }

        if (primes.size() < 2) return new int[]{-1, -1};

        int bestA = -1, bestB = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                bestA = primes.get(i - 1);
                bestB = primes.get(i);
            }
        }

        return new int[]{bestA, bestB};
    }

    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        if (n >= 0) prime[0] = false;
        if (n >= 1) prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}
