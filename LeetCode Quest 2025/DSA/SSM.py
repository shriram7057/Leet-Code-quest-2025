class Solution(object):
    def repeatedStringMatch(self, a, b):
        cnt = 1
        s = a
        # repeat until s is at least as long as b
        while len(s) < len(b):
            s += a
            cnt += 1
        # check if b is in s
        if b in s:
            return cnt
        # check one more repetition
        s += a
        if b in s:
            return cnt + 1
        return -1
