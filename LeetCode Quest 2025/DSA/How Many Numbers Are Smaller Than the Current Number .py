class Solution(object):
    def smallerNumbersThanCurrent(self, nums):
        # Sort a copy of nums
        sorted_nums = sorted(nums)
        # Map each number to the first index where it appears
        first_index = {}
        for i, v in enumerate(sorted_nums):
            if v not in first_index:
                first_index[v] = i
   # number of elements smaller
        # Build result: for each num, fetch its rank
        return [first_index[num] for num in nums]