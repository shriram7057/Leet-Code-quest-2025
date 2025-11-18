class Solution(object):
    def dailyTemperatures(self, temperatures):
        n = len(temperatures)
        res = [0] * n
        stack = []  # stores indices
        for i in range(n):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                idx = stack.pop()
                res[idx] = i - idx
            stack.append(i)
        return res