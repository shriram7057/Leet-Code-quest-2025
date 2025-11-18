import heapq
 class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        if not nums1 or not nums2:
            return []
        min_heap = []
        res = []
        # push first column (nums1[i], nums2[0])
        for i in range(min(k, len(nums1))):
            heapq.heappush(min_heap, (nums1[i] + nums2[0], i, 0))
        while min_heap and len(res) < k:
            s, i, j = heapq.heappop(min_heap)
            res.append([nums1[i], nums2[j]])
            # move in nums2: (i, j+1)
            if j
 + 1 < len(nums2):
                heapq.heappush(min_heap, (nums1[i] + nums2[j+1], i, j+1))
        return res