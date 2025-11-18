class Solution(object):
    def exclusiveTime(self, n, logs):
        res = [0] * n
        stack = []
        prev = 0
        for log in logs:
 = int(f)
            f, typ, t = log.split(':')
            f
            t
 = int(t)
            if typ == "start":
                if stack:
                    res[stack[-1]] += t - prev
                stack.append(f)
                prev = t
            else:
  # "end"
                res[stack.pop()] += t - prev + 1
                prev = t + 1
        return res