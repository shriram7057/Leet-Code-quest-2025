class Solution(object):
    def shuffle(self, nums, n):
        ans = []
        for i in range(n):
            ans.append(nums[i])      # x₁, x₂, ...
            ans.append(nums[i+n])    # y₁, y₂, ...
        return ans