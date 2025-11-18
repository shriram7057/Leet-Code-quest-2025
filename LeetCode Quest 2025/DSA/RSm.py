class Solution(object):
    def repeatedStringMatch(self, a, b):
        cnt = 1
        s = a
        # repeat until length >= len(b)
        while len(s) < len(b):
            s += a
            cnt += 1
        # check once
        if b in s:
            return cnt
        # check one more repetition
        s += a
        if b in s:
            return cnt + 1
        return -1
