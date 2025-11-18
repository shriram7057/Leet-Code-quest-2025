Two Sum
 class Solution(object):
    def twoSum(self, nums, target):
        seen = {}  # value → index
        for i, num in enumerate(nums):
            diff = target - num
            if diff in seen:
                return [seen[diff], i]
            seen[num] = i