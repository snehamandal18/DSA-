class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i=0;
        int j=0;
        int ones = 0;
        int n = s.length();

        String result = "";

        while(j<n)
        {
            if(s.charAt(j) == '1') {
                ones++;
            }
            while(ones > k ) {
                if(s.charAt(i) == '1')
                {
                    ones--;
                }
                i++;
            }
            while(i <= j && s.charAt(i) == '0') 
            {
                i++;
            }
            if(ones == k)
            {
                String temp = s.substring(i,j+1);
                if(result.isEmpty() 
                || result.length() > temp.length() 
                || (temp.length() == result.length() && temp.compareTo(result) < 0)) 
                {
                    result = temp;
                }
            }
            j++;
        }
        return result;
    }
}