class Solution(object):
    def findErrorNums(self, nums):
        n = len(nums)
        seen = set()
        duplicate = -1
        
        for num in nums:
            if num in seen:
                duplicate = num
            seen.add(num)
        
        # sum of numbers from 1..n
        expected_sum = n * (n + 1) // 2
        actual_sum = sum(nums)
        
        missing = expected_sum - (actual_sum - duplicate)
        
        return [duplicate, missing]
