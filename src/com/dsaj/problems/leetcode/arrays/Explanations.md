# LC 153 - Find min in rotated sorted array

## Approach: Binary Search

The solution uses a _modified binary search_ to find the minimum element in a rotated sorted array in O(log n) time.

**Algorithm:**

1. Initialize `front` (right pointer) to the last element and `rear` (left pointer) to the first element
2. In each iteration:
   - Calculate the middle index
   - If `nums[middle] <= nums[front]`: The minimum is in the left half (including middle), so update the minimum and move `front` left
   - Else if `nums[middle] > nums[rear]`: The minimum is in the right half, so update minimum with `nums[rear]` and move `rear` right
3. Return the minimum element found

**Key Insight 1:** By comparing the middle element with both boundaries, we can identify which half of the array contains the rotation point and thus the minimum value.

**Key Insight 2:** IF we identify that either half of the array is sorted, then it's first element will be the minimum. Compare it with the current min and store it. We can Ignore this half of array for next iteration.

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)
