class Solution(object):
    def findDisappearedNumbers(self, nums):
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -nums[index]    # mark as visited
        
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:                   # not visited
                result.append(i + 1)
        
        return result