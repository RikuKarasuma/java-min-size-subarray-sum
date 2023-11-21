class Solution {

   /*
   * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
   * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
   * 
   * Example 1:
   * Input: target = 7, nums = [2,3,1,2,4,3]
   * Output: 2
   * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
   *
   * Example 2:
   * 
   * Input: target = 4, nums = [1,4,4]
   * Output: 1
   * Example 3:
   * 
   * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
   * Output: 0
   */
   public int minSubArrayLen(int target, int[] nums) {

        if (target < 1)
            return 0;
       

        if (nums.length == 0)
            return 0;

        var currentSum = 0;
        var iterationLength = 1;
        var lastIterationLength = -1;
        var lastStartingPosition = 0;

        // Expanding sliding window
        for (int i = 0; i < nums.length; i ++, iterationLength ++ ) {

            // In cases where a single digit meets target
            if (nums[i] >= target)
                return 1;

            currentSum += nums[i];

            // If we meet the target.
            if (currentSum >= target) {

                // Check the new met targets length is lessor than our previous met target.
                if (iterationLength < lastIterationLength || lastIterationLength == -1) {
                     lastIterationLength = iterationLength;
                }
                iterationLength = 1;
                lastStartingPosition ++;
                i = lastStartingPosition;
                currentSum = nums[i];
            }
        }

        return lastIterationLength > 0 ? lastIterationLength : 0;
    }
}
