class Solution(object):
    def licenseKeyFormatting(self, s, k):
        # remove existing dashes and uppercase
        s = s.replace("-", "").upper()
        n = len(s)
        if n == 0:
            return ""
        # first group size
        first = n % k
        res = []
        # add first group if it exists
        if first > 0:
            res.append(s[:first])
        # add the rest in groups of k
        for i in range(first, n, k):
            res.append(s[i:i+k])
        return "-".join(res)
