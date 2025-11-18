# Build an Array With Stack Operations 
class Solution(object):
    def buildArray(self, target, n):
        result = []
        current = 1
        for t in target:
            # Push numbers until we reach t
            while current < t:
                result.append("Push")
                result.append("Pop")
                current += 1
            # Push the target number
            result.append("Push")
            current += 1
        return result
