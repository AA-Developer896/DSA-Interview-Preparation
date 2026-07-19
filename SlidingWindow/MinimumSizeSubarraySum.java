public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        //System.out.println(minSize);
        int currSum = 0;
        int left = 0, right = 0;
         while(right < nums.length) {
            currSum = currSum + nums[right];
            if(currSum >= target) {
                while(currSum >= target && left <= right) {
                    currSum -= nums[left];
                    left++;
                }
                minSize = Math.min(minSize, right - left + 1);
            } 
            //if(left > right) return 1;
            right++;
            
        }
        if(minSize == Integer.MAX_VALUE) return 0;
        return minSize + 1;
    }
    
}
