class Solution(object):
    def finalPrices(self, prices):
        stack = []
        n = len(prices)
        res = prices[:]
        for i in range(n):
            while stack and prices[stack[-1]] >= prices[i]:
                idx = stack.pop()
                res[idx] -= prices[i]
            stack.append(i)
        return res