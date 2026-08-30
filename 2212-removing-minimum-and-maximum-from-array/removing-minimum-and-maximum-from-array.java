class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
          
         int minIndex=0;
         int maxIndex=0;

         for(int i=0 ; i<n ; i++)
         {
            if(nums[i]<min)
            {
                min = nums[i];
                minIndex = i;
            }
            if(nums[i] > max)
            {
                max = nums[i];
                maxIndex = i;
            }
         } 
         int left = Math.min(minIndex,maxIndex);
         int right = Math.max(minIndex,maxIndex);

        return Math.min(left+1+n-right , Math.min(n-left , right+1)); 
    }
}