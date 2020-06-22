/* problem->
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,3,2]
Output: 3
*/

class Solution {
     static final int INT_SIZE = 32; 
    public int singleNumber(int[] nums) {
       
         int result = 0; 
        int x, sum; 
          
        for(int i=0; i<INT_SIZE; i++) 
        { 
            sum = 0; 
            x = (1 << i); 
            for(int j=0; j<nums.length; j++) 
            { 
                if((nums[j] & x) == 0) 
                sum++; 
            } 
            if ((sum % 3) == 0) 
            result |= x; 
        } 
        return result;         
    }
}
