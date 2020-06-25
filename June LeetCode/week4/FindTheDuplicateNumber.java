/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:
Input: [1,3,4,2,2]
Output: 2
*/

class Solution {
    public int findDuplicate(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            
            if(nums[Math.abs(nums[i])]>=0){
              nums[Math.abs(nums[i])]=-1*(nums[Math.abs(nums[i])]);    
            }else{
                return Math.abs(nums[i]);
            }
        }
    return 0;
    }
}
