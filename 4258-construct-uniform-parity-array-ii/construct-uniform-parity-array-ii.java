class Solution {
    public boolean uniformArray(int[] nums1) {
        
        int smallest = Integer.MAX_VALUE;
        for(int i : nums1)
        {
            smallest = Math.min(smallest,i);
        }

        // smallest is odd
        if(smallest % 2 == 1 )
        {
            return true;
        }

        //all even 
        for(int n : nums1)
        {
            // if there is any one odd
            if(n % 2 == 1)
            {
                return false;
            }
        }
        return true;
    }
}