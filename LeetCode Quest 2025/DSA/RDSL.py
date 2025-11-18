# Remove Duplicates from Sorted List
class Solution(object):
    def deleteDuplicates(self, head):
        curr = head
        while curr and curr.next:
            if curr.val == curr.next.val:
                curr.next = curr.next.next  # skip duplicate
            else:
                curr = curr.next  # move forward
        return head
